package com.chaitanya.schoolmanagement.service.exam;

import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.payload.AddQuestionPaperDto;
import com.chaitanya.schoolmanagement.payload.EmailDto;
import com.chaitanya.schoolmanagement.repository.QuestionPaperRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QuestionPaperService {
    @Autowired
    private QuestionPaperRepository questionPaperRepository;

    public void save(AddQuestionPaperDto addQuestionPaperDto) {
        log.info("********** Saving Question paper record ***********");
        QuestionPaper questionPaper = new QuestionPaper();
        questionPaper.setCourse(addQuestionPaperDto.getCourse());
        questionPaper.setDuration(addQuestionPaperDto.getDuration());
        questionPaper.setPaperTitle(addQuestionPaperDto.getPaperTitle());
        questionPaper.setPaperDsc(addQuestionPaperDto.getPaperDsc());
        questionPaperRepository.save(questionPaper);
    }
}
