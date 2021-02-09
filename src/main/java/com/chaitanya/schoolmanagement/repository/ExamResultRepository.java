package com.chaitanya.schoolmanagement.repository;

import com.chaitanya.schoolmanagement.model.exam.ExamResult;
import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.model.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamResultRepository extends JpaRepository<ExamResult, String> {
    ExamResult findByStudentAndQuestionPaper(Student student, QuestionPaper questionPaper);

    ExamResult findByIdAndStudentAndQuestionPaper(String id, Student student, QuestionPaper questionPaper);
}
