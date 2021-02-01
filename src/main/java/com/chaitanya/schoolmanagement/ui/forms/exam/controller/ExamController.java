package com.chaitanya.schoolmanagement.ui.forms.exam.controller;

import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.payload.AddQuestionPaperDto;
import com.chaitanya.schoolmanagement.service.course.CourseService;
import com.chaitanya.schoolmanagement.service.exam.QuestionPaperService;
import com.chaitanya.schoolmanagement.ui.forms.exam.model.QuestionPaperTableModel;
import com.chaitanya.schoolmanagement.ui.forms.exam.view.AddExamFrame;
import com.chaitanya.schoolmanagement.ui.forms.exam.view.ExamDashboardFrame;
import com.chaitanya.schoolmanagement.ui.forms.exam.view.ExamFrame;
import com.chaitanya.schoolmanagement.ui.forms.exam.view.QuestionPaperTableBtnPanel;
import com.chaitanya.schoolmanagement.ui.forms.student.model.CourseComboBoxModel;
import com.chaitanya.schoolmanagement.ui.forms.teacher.dashboard.view.TeacherDashboardFrame;
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import com.chaitanya.schoolmanagement.util.notification.Notifications;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.exam.AddQuestionPaperValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;
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
    private final QuestionPaperTableModel questionPaperTableModel;
    private final ExamFrame examFrame;
    private final ExamDashboardFrame examDashboardFrame;

    @PostConstruct
    private void prepareListeners() {
        QuestionPaperTableBtnPanel questionPaperTableBtnPanel = examFrame.getTableBtnPanel();
        registerAction(questionPaperTableBtnPanel.getAddQuestionBtn(), (e) -> showAddQuestionFrame());
        registerAction(questionPaperTableBtnPanel.getRemoveBtn(), (e) -> deleteQuestionPaper());
        registerAction(addExamFrame.getBackBtn(), (e) -> backToExamDashboard());
        registerAction(addExamFrame.getSaveBtn(), (e) -> saveQuestionPaper());
        registerAction(examDashboardFrame.getBackBtn(), (e) -> backToTeacherDashboard());
        registerAction(examDashboardFrame.getViewQuestionPaperBtn(), (e) -> viewQuestionPaperFrame());
        registerAction(examDashboardFrame.getAddQuestionPaperBtn(), (e) -> showAddQuestionFrame());
    }

    private void deleteQuestionPaper() {
        try {
            JTable questionPaperTable = examFrame.getQuestionPaperTablePanel().getQuestionPaperTable();
            int selectedRow = questionPaperTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                QuestionPaper questionPaper = questionPaperTableModel.getEntityByRow(selectedRow);
                questionPaperService.remove(questionPaper);
                questionPaperTableModel.removeRow(selectedRow);
                Notifications.showDeletedSuccessfulMessage();
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

    private void backToExamDashboard() {
        addExamFrame.setVisible(false);
        examDashboardFrame.setVisible(true);
    }

    private void viewQuestionPaperFrame() {
        loadQuestionPapers();
        examFrame.setVisible(true);
        examDashboardFrame.setVisible(false);
    }

    private void saveQuestionPaper() {
        AddQuestionPaperDto addQuestionPaperDto = addExamFrame.getQuestionPaperFromForm();
        Optional<ValidationError> errors = questionPaperValidator.validate(addQuestionPaperDto);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            QuestionPaper questionPaper = questionPaperService.save(addQuestionPaperDto);
            questionPaperTableModel.addEntity(questionPaper);
            addExamFrame.setVisible(false);
            examFrame.setVisible(true);
        }

    }

    private void loadQuestionPapers() {
        List<QuestionPaper> questionPapers = questionPaperService.getAllQuestionPapers();
        questionPaperTableModel.clear();
        questionPaperTableModel.addEntities(questionPapers);
    }

    private void backToTeacherDashboard() {
        examDashboardFrame.setVisible(false);
        teacherDashboardFrame.setVisible(true);
    }

    @Override
    public void prepareAndOpenFrame() {
        //log.info(" ********* course added in add question form ********** ");
        //loadCourses();
        loadQuestionPapers();
        examDashboardFrame.setVisible(true);
        //examFrame.setVisible(true);
        //showAddQuestionFrame();
    }

    private void showAddQuestionFrame() {
        log.info(" ********* course added in add question form ********** ");
        loadCourses();
        addExamFrame.setVisible(true);
        examDashboardFrame.setVisible(false);
        examFrame.setVisible(false);

    }


    private void loadCourses() {
        List<Course> courses = courseService.findAll();
        courseComboBoxModel.clear();
        courseComboBoxModel.addElements(courses);
        log.info(" ******* course added ********  " + courses);
    }


}
