package com.chaitanya.schoolmanagement.service.exam;

import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.payload.AddQuestionPaperDto;
import com.chaitanya.schoolmanagement.repository.QuestionPaperRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        questionPaperRepository.save(questionPaper);
        log.info(" ******* question successfully paper added ******** " + questionPaper.getPaperTitle());
        return questionPaper;
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
