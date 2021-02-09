package com.chaitanya.schoolmanagement.model.exam;

import com.chaitanya.schoolmanagement.enums.ResultStatus;
import com.chaitanya.schoolmanagement.model.student.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ExamResult {
    @Id
    private String id = UUID.randomUUID().toString();
    @ManyToOne
    @JoinColumn(name = "questionPaperId")
    private QuestionPaper questionPaper;
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;
    @ElementCollection
    private Map<Question, String> questionAnswerMap = new HashMap<>();
    private int totalQuestion;
    private int attemptedQuestion = 0;
    private int remainingQuestion;
    private int correctQuestion = 0;
    private int inCorrectQuestion = 0;
    private double percentage;
    private ResultStatus result;

}
