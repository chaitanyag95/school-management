package com.chaitanya.schoolmanagement.ui.forms.question.controller;

import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.model.exam.Question;
import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.service.course.CourseService;
import com.chaitanya.schoolmanagement.service.exam.QuestionService;
import com.chaitanya.schoolmanagement.ui.forms.exam.model.QuestionTableModel;
import com.chaitanya.schoolmanagement.ui.forms.exam.view.ExamDashboardFrame;
import com.chaitanya.schoolmanagement.ui.forms.exam.view.QuestionDashboardFrame;
import com.chaitanya.schoolmanagement.ui.forms.exam.view.QuestionTableBtnPanel;
import com.chaitanya.schoolmanagement.ui.forms.exam.view.QuestionTableFrame;
import com.chaitanya.schoolmanagement.ui.forms.question.view.AddQuestionFrame;
import com.chaitanya.schoolmanagement.ui.forms.question.view.EditQuestionFrame;
import com.chaitanya.schoolmanagement.ui.forms.question.view.ViewQuestionFrame;
import com.chaitanya.schoolmanagement.ui.forms.student.model.CourseComboBoxModel;
import com.chaitanya.schoolmanagement.ui.forms.teacher.dashboard.view.TeacherDashboardFrame;
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import com.chaitanya.schoolmanagement.util.notification.Notifications;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.question.QuestionValidator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@Slf4j
public class QuestionController extends AbstractFrameController {
    private final AddQuestionFrame addQuestionFrame;
    private final TeacherDashboardFrame teacherDashboardFrame;
    private final CourseService courseService;
    private final CourseComboBoxModel courseComboBoxModel;
    private final QuestionValidator questionValidator;
    private final QuestionService questionService;
    private final QuestionDashboardFrame questionDashboardFrame;
    private final QuestionTableFrame questionTableFrame;
    private final QuestionTableModel questionTableModel;
    private final ExamDashboardFrame examDashboardFrame;
    private final EditQuestionFrame editQuestionFrame;
    private final ViewQuestionFrame viewQuestionFrame;


    @PostConstruct
    private void prepareListeners() {
        QuestionTableBtnPanel questionTableBtnPanel = questionTableFrame.getTableBtnPanel();
        registerAction(questionTableBtnPanel.getAddQuestionBtn(), (e) -> openAddQuestionToQuestionPaper());
        registerAction(questionTableBtnPanel.getEditQuestionBtn(), (e) -> openEditQuestionFrame());
        registerAction(questionTableBtnPanel.getRemoveBtn(), (e) -> deleteQuestionsFromQuestionPaper());
        registerAction(questionTableBtnPanel.getViewQuestionBtn(), (e) -> selectAndViewQuestion());
        registerAction(addQuestionFrame.getBackBtn(), (e) -> backToExamDashboard());
        registerAction(addQuestionFrame.getSaveBtn(), (e) -> saveQuestionInQuestionPaper());
        registerAction(questionDashboardFrame.getViewQuestionBtn(), (e) -> viewQuestionsInQuestionPaper());
        registerAction(editQuestionFrame.getBackBtn(), (e) -> backToQuestionTable());
        registerAction(viewQuestionFrame.getNextBtn(), (e) -> openNextQuestion());

    }


    private void selectAndViewQuestion() {
        try {
            JTable questionPaperTable = questionTableFrame.getQuestionTablePanel().getQuestionTable();
            int selectedRow = questionPaperTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Question question = questionTableModel.getEntityByRow(selectedRow);
                viewQuestionFrame.setViewQuestionForm(question);
                viewQuestionFrame.setVisible(true);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

    private void openNextQuestion() {

    }

    private void deleteQuestionsFromQuestionPaper() {
        try {
            JTable questionPaperTable = questionTableFrame.getQuestionTablePanel().getQuestionTable();
            int selectedRow = questionPaperTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Question question = questionTableModel.getEntityByRow(selectedRow);
                questionService.remove(question);
                questionTableModel.removeRow(selectedRow);
                Notifications.showDeletedSuccessfulMessage();
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

    private void backToQuestionTable() {
        editQuestionFrame.setVisible(false);
        viewQuestionsInQuestionPaper();
    }

    private void openEditQuestionFrame() {
        try {
            JTable questionPaperTable = questionTableFrame.getQuestionTablePanel().getQuestionTable();
            int selectedRow = questionPaperTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Question question = questionTableModel.getEntityByRow(selectedRow);
                showUpdateQuestionWindow(question);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

    private void showUpdateQuestionWindow(Question question) {
        loadQuestionForEdit(question);
    }

    private void loadQuestionForEdit(Question question) {
        editQuestionFrame.setEditQuestionForm(question);
        questionTableFrame.setVisible(false);
        editQuestionFrame.setVisible(true);
    }

    private void backToExamDashboard() {
        addQuestionFrame.setVisible(false);
        examDashboardFrame.setVisible(true);
    }

    private void openAddQuestionToQuestionPaper() {
        questionTableFrame.setVisible(false);
        addQuestionFrame.setVisible(true);
    }

    private void viewQuestionsInQuestionPaper() {
        String questionPaperId = questionDashboardFrame.getQuestionPaperId();
        loadQuestions(questionPaperId);
        questionDashboardFrame.setVisible(false);
        questionTableFrame.setVisible(true);
    }

    private void loadQuestions(String questionPaperId) {
        List<Question> questionList = questionService.findAllQuestionsByQuestionPaperId(questionPaperId);
        questionTableModel.clear();
        questionTableModel.addEntities(questionList);

    }

    private void saveQuestionInQuestionPaper() {
        Question question = addQuestionFrame.getQuestionFromForm();
        Optional<ValidationError> errors = questionValidator.validate(question);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            questionService.saveQuestion(question);
            addQuestionFrame.clearForm();
            addQuestionFrame.setVisible(false);
            questionDashboardFrame.setVisible(true);
        }

    }

    private void backToTeacherDashboard() {
        teacherDashboardFrame.setVisible(true);
        addQuestionFrame.setVisible(false);
    }

    @Override
    public void prepareAndOpenFrame() {
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
