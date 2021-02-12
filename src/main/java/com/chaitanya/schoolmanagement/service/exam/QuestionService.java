package com.chaitanya.schoolmanagement.service.exam;

import com.chaitanya.schoolmanagement.model.exam.Question;
import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.payload.NextQuestionPayload;
import com.chaitanya.schoolmanagement.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionPaperService questionPaperService;

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
        //addQuestionInQuestionPaper(question1.getQuestionPaper(), question);
        log.info(" ******* question successfully paper added ******** " + question.getId());
        return question;
    }

    /*private void addQuestionInQuestionPaper(QuestionPaper questionPaper, Question question) {
        log.info(" ***** saving questions in question paper class ***********");
        List<Question> questions = new ArrayList<>();
        questions.add(question);
        questionPaper.setQuestions(questions);
        questionPaperService.saveQuestionPaper(questionPaper);
    }*/

    public List<Question> findAllQuestionsByQuestionPaperId(String questionPaperId) {
        //Optional<QuestionPaper> questionPaper = questionPaperService.getQuestionPaperById(questionPaperId);
        QuestionPaper questionPaper = questionPaperService.getQuestionPaperById(questionPaperId).get();
        //   List<Question> questionList = questionRepository.findAllByQuestionPaper(questionPaper);
        List<Question> questions = questionRepository.findByQuestionId(questionPaper.getId());
        return questions;
    }

    public void remove(Question question) {
        questionRepository.delete(question);
    }

    public Question getNextQuestion(NextQuestionPayload nextQuestionPayload) {
        int questionNo = nextQuestionPayload.getQuestionNo() + 1;
        Optional<QuestionPaper> questionPaper = questionPaperService.getQuestionPaperById(nextQuestionPayload.getQuestionPaperId());
        Question question = questionRepository.findByQuestionNo(questionNo,nextQuestionPayload.getQuestionPaperId());
        return question;
    }

    public Question getPreviousQuestion(NextQuestionPayload nextQuestionPayload) {
        int questionNo = nextQuestionPayload.getQuestionNo() - 1;
        Optional<QuestionPaper> questionPaper = questionPaperService.getQuestionPaperById(nextQuestionPayload.getQuestionPaperId());
        Question question = questionRepository.findByQuestionNo(questionNo,nextQuestionPayload.getQuestionPaperId());
        return question;
    }

    public Question getQuestionById(String questionId) {
        return questionRepository.findById(questionId).get();
    }

}
