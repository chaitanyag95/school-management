package com.chaitanya.schoolmanagement.model.exam;

import com.chaitanya.schoolmanagement.model.course.Course;
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
    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;
    private String question;
    private String answerOne;
    private String answerTwo;
    private String answerThree;
    private String answerFour;
    private String correctAnswer;

}
