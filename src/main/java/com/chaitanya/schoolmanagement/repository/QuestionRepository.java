package com.chaitanya.schoolmanagement.repository;

import com.chaitanya.schoolmanagement.model.exam.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
}
