package com.chaitanya.schoolmanagement.repository;

import com.chaitanya.schoolmanagement.model.exam.ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamResultRepository extends JpaRepository<ExamResult, String> {
    ExamResult findByStudentIdAndQuestionPaperId(String studentId, String questionPaperId);

    ExamResult findByIdAndStudentIdAndQuestionPaperId(String id, String studentId, String questionPaperId);
}
