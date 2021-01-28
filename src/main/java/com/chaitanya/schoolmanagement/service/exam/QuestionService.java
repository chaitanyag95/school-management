package com.chaitanya.schoolmanagement.service.exam;

import com.chaitanya.schoolmanagement.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
}
