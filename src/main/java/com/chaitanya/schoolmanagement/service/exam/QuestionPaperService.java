package com.chaitanya.schoolmanagement.service.exam;

import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.payload.AddQuestionPaperDto;
import com.chaitanya.schoolmanagement.repository.QuestionPaperRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
