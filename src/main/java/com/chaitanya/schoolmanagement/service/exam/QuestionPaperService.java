package com.chaitanya.schoolmanagement.service.exam;

import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.payload.AddQuestionPaperDto;
import com.chaitanya.schoolmanagement.repository.QuestionPaperRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class QuestionPaperService {
    @Autowired
    private QuestionPaperRepository questionPaperRepository;

    public QuestionPaper save(AddQuestionPaperDto addQuestionPaperDto) {
        log.info("********** Saving Question paper record ***********");
        QuestionPaper questionPaper = new QuestionPaper();
        questionPaper.setCourse(addQuestionPaperDto.getCourse());
        questionPaper.setDuration(addQuestionPaperDto.getDuration());
        questionPaper.setPaperTitle(addQuestionPaperDto.getPaperTitle());
        questionPaper.setPaperDsc(addQuestionPaperDto.getPaperDsc());
        questionPaper.setPaperCode(addQuestionPaperDto.getPaperCode());
        String teacherId = getUserIDRecordFromStore();
        if (!teacherId.equals("") && teacherId != null) {
            questionPaper.setCreatedById(teacherId);
        }
        questionPaperRepository.save(questionPaper);
        log.info(" ******* question successfully paper added ******** " + questionPaper.getPaperTitle());
        return questionPaper;
    }

    public void saveQuestionPaper(QuestionPaper questionPaper) {
        questionPaperRepository.save(questionPaper);
    }

    public String[] getDetailsStoredInStore() throws IOException {
        FileReader fileReader = new FileReader("/home/chaitannya/Persistence/src/main/resources/userDetails.csv");
        CSVReader csvReader = new CSVReaderBuilder(fileReader)
                .withSkipLines(1)
                .build();
        List<String[]> allData = csvReader.readAll();
        String[] userDetails = allData.get(0);
        return userDetails;
    }

    public String getUserIDRecordFromStore() {
        try {
            String[] userDetails = getDetailsStoredInStore();
            Optional<String> id = Arrays.stream(userDetails).findFirst();
            return id.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getQuestionPaperIdFromStore() {
        try {
            String[] userDetails = getDetailsStoredInStore();
            log.info(" ****** getting question paper id from store ****** " + userDetails[5]);
            return userDetails[5];

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getExamResultIdFromStore() {
        try {
            String[] userDetails = getDetailsStoredInStore();
            log.info(" ****** getting exam result  id from store ****** " + userDetails[4]);
            return userDetails[4];

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean isQuestionPaperExistByPaperCode(AddQuestionPaperDto addQuestionPaperDto) {
        QuestionPaper questionPaper = questionPaperRepository.findByPaperCode(addQuestionPaperDto.getPaperCode());
        if (questionPaper != null) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public List<QuestionPaper> getAllQuestionPapers() {
        return questionPaperRepository.findAll();
    }

    public void remove(QuestionPaper questionPaper) {
        questionPaperRepository.delete(questionPaper);
    }

    public QuestionPaper updateQuestionPaper(AddQuestionPaperDto addQuestionPaperDto) {
        QuestionPaper questionPaper = questionPaperRepository.findByPaperCode(addQuestionPaperDto.getPaperCode());
        if (questionPaper != null) {
            log.info("********** updating existing question paper  ***********" + questionPaper.getId());
            questionPaper.setPaperTitle(addQuestionPaperDto.getPaperTitle());
            questionPaper.setPaperDsc(addQuestionPaperDto.getPaperDsc());
            questionPaper.setCourse(addQuestionPaperDto.getCourse());
            questionPaper.setLastUpdated(new Date());
            questionPaperRepository.save(questionPaper);
            return questionPaper;
        }
        log.info("********** Student record not found, Error occurred ***********");
        return null;
    }

    public Optional<QuestionPaper> getQuestionPaperById(String questionPaperId) {
        return questionPaperRepository.findById(questionPaperId);
    }

}
