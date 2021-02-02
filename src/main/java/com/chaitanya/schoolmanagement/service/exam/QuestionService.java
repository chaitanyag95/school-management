package com.chaitanya.schoolmanagement.service.exam;

import com.chaitanya.schoolmanagement.model.exam.Question;
import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.payload.AddQuestionPaperDto;
import com.chaitanya.schoolmanagement.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Question saveQuestion(Question question1) {
        log.info("********** Saving Question Record ***********");
        Question question = new Question();
        question.setQuestion(question1.getQuestion());
        question.setQuestionPaper(question1.getQuestionPaper());
        question.setAnswerOne(question1.getAnswerOne());
        question.setAnswerTwo(question1.getAnswerTwo());
        question.setAnswerThree(question1.getAnswerThree());
        question.setAnswerFour(question1.getAnswerFour());
        question.setCorrectAnswer(question1.getCorrectAnswer());
        question.setQuestionNo(question1.getQuestionNo());
        questionRepository.save(question);
        log.info(" ******* question successfully paper added ******** " + question.getId());
        return question;
    }
}
