package com.chaitanya.schoolmanagement.ui.forms.exam.controller;

import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.model.teacher.Teacher;
import com.chaitanya.schoolmanagement.payload.AddQuestionPaperDto;
import com.chaitanya.schoolmanagement.service.course.CourseService;
import com.chaitanya.schoolmanagement.service.exam.QuestionPaperService;
import com.chaitanya.schoolmanagement.ui.forms.exam.view.AddExamFrame;
import com.chaitanya.schoolmanagement.ui.forms.student.model.CourseComboBoxModel;
import com.chaitanya.schoolmanagement.ui.forms.teacher.dashboard.view.TeacherDashboardFrame;
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import com.chaitanya.schoolmanagement.util.notification.Notifications;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.exam.AddQuestionPaperValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;


@Controller
@AllArgsConstructor
@Slf4j
public class ExamController extends AbstractFrameController {
    private final AddExamFrame addExamFrame;
    private final TeacherDashboardFrame teacherDashboardFrame;
    private final CourseService courseService;
    private final CourseComboBoxModel courseComboBoxModel;
    private final AddQuestionPaperValidator questionPaperValidator;
    private final QuestionPaperService questionPaperService;

    @PostConstruct
    private void prepareListeners() {
        registerAction(addExamFrame.getBackBtn(), (e) -> backToTeacherDashboard());
        registerAction(addExamFrame.getSaveBtn(), (e) -> saveQuestionPaper());
    }

    private void saveQuestionPaper() {
        AddQuestionPaperDto addQuestionPaperDto = addExamFrame.getQuestionPaperFromForm();
        Optional<ValidationError> errors = questionPaperValidator.validate(addQuestionPaperDto);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            questionPaperService.save(addQuestionPaperDto);
        }

    }

    private void backToTeacherDashboard() {
        teacherDashboardFrame.setVisible(true);
        addExamFrame.setVisible(false);
    }

    @Override
    public void prepareAndOpenFrame() {
        log.info(" ********* course added in add question form ********** ");
        loadCourses();
        showAddQuestionFrame();
    }

    private void showAddQuestionFrame() {
        addExamFrame.setVisible(true);
    }


    private void loadCourses() {
        List<Course> courses = courseService.findAll();
        courseComboBoxModel.clear();
        courseComboBoxModel.addElements(courses);
        log.info(" ******* course added ********  " + courses);
    }


}
