package com.chaitanya.schoolmanagement.repository;

import com.chaitanya.schoolmanagement.model.exam.Question;
import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
    List<Question> findAllByQuestionPaperOrderByQuestionNoAsc(QuestionPaper questionPaper);

    Question findByQuestionNoAndQuestionPaper(int questionNo, QuestionPaper questionPaper);

    List<Question> findAllByQuestionPaper(QuestionPaper questionPaper);
}
