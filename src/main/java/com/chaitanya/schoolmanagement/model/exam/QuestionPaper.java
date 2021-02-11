package com.chaitanya.schoolmanagement.model.exam;

import com.chaitanya.schoolmanagement.model.course.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Component
public class QuestionPaper {
    @Id
    private String id = UUID.randomUUID().toString();
    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;
    private String paperTitle;
    private String paperDsc;
    private String duration;
    private Date dateCreated = new Date();
    private Date lastUpdated;
    private String paperCode;
    private String createdById;

}
