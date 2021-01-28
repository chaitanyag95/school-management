package com.chaitanya.schoolmanagement.payload;

import com.chaitanya.schoolmanagement.model.course.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddQuestionPaperDto {
    private String paperTitle;
    private String paperDsc;
    private Course course;
    private String duration;
}
