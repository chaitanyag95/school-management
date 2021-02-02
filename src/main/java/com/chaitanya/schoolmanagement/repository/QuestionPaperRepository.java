package com.chaitanya.schoolmanagement.repository;

import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionPaperRepository extends JpaRepository<QuestionPaper, String> {
    QuestionPaper findByPaperCode(String paperCode);

}
