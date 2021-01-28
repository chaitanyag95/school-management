package com.chaitanya.schoolmanagement.ui.forms.question.controller;

import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.service.course.CourseService;
import com.chaitanya.schoolmanagement.ui.forms.question.view.AddQuestionFrame;
import com.chaitanya.schoolmanagement.ui.forms.student.model.CourseComboBoxModel;
import com.chaitanya.schoolmanagement.ui.forms.teacher.dashboard.view.TeacherDashboardFrame;
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class QuestionController extends AbstractFrameController {
    private final AddQuestionFrame addQuestionFrame;
    private final TeacherDashboardFrame teacherDashboardFrame;
    private final CourseService courseService;
    private final CourseComboBoxModel courseComboBoxModel;

    @PostConstruct
    private void prepareListeners() {
        registerAction(addQuestionFrame.getBackBtn(), (e) -> backToTeacherDashboard());
    }

    private void backToTeacherDashboard() {
        teacherDashboardFrame.setVisible(true);
        addQuestionFrame.setVisible(false);
    }

    @Override
    public void prepareAndOpenFrame() {
        log.info(" ********* course added in add question form ********** ");
        loadCourses();
        showAddQuestionFrame();
    }

    private void showAddQuestionFrame() {
        addQuestionFrame.setVisible(true);
    }


    private void loadCourses() {
        List<Course> courses = courseService.findAll();
        courseComboBoxModel.clear();
        courseComboBoxModel.addElements(courses);
        log.info(" ******* course added ********  " + courses);
    }
}
