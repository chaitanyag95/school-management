package com.chaitanya.schoolmanagement.model.exam;

import com.chaitanya.schoolmanagement.enums.ResultStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ExamResult {
    @Id
    private String id = UUID.randomUUID().toString();
    private String studentId;
    private String questionPaperId;
    private int totalQuestion;
    private int attemptedQuestion = 0;
    private int remainingQuestion;
    private int correctQuestion = 0;
    private int inCorrectQuestion = 0;
    private double percentage;
    private ResultStatus result;

}
