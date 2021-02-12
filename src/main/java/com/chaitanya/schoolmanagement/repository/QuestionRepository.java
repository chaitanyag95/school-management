package com.chaitanya.schoolmanagement.repository;

import com.chaitanya.schoolmanagement.model.exam.Question;
import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
    List<Question> findAllByQuestionPaperOrderByQuestionNoAsc(QuestionPaper questionPaper);

    @Query(value = "select * from question where question_no =:questionNo AND question_paper =:questionPaper", nativeQuery = true)
    Question findByQuestionNo(int questionNo, String questionPaper);

    List<Question> findAllByQuestionPaper(QuestionPaper questionPaper);

    @Query(value = "select * from question where question_paper =:questionPaper", nativeQuery = true)
    List<Question> findByQuestionId(String questionPaper);
}
