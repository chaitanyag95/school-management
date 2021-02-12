package com.chaitanya.schoolmanagement.model.exam;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Question {
    @Id
    private String id = UUID.randomUUID().toString();
    private int questionNo;
    private String question;
    private String answerOne;
    private String answerTwo;
    private String answerThree;
    private String answerFour;
    private String correctAnswer;
    @ManyToOne
    @JoinColumn(name = "questionPaper")
    private QuestionPaper questionPaper;
    // Java Exam - > 10 Questions
    // Many question have one question paper

}
