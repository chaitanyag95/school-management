package com.chaitanya.schoolmanagement.ui.forms.student.exam.controller;

import com.chaitanya.schoolmanagement.model.exam.Question;
import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.payload.NextQuestionPayload;
import com.chaitanya.schoolmanagement.service.exam.ExamResultService;
import com.chaitanya.schoolmanagement.service.exam.QuestionPaperService;
import com.chaitanya.schoolmanagement.service.exam.QuestionService;
import com.chaitanya.schoolmanagement.ui.forms.exam.view.ExamFrame;
import com.chaitanya.schoolmanagement.ui.forms.question.view.ViewQuestionFrame;
import com.chaitanya.schoolmanagement.ui.forms.student.exam.model.StudentExamTableModel;
import com.chaitanya.schoolmanagement.ui.forms.student.exam.view.StudentExamFrame;
import com.chaitanya.schoolmanagement.ui.forms.student.exam.view.StudentExamTableBtnPanel;
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import com.chaitanya.schoolmanagement.util.notification.Notifications;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class StudentExamController extends AbstractFrameController {
    private final StudentExamFrame studentExamFrame;
    private final StudentExamTableModel questionPaperTableModel;
    private final QuestionService questionService;
    private final ViewQuestionFrame viewQuestionFrame;
    private final ExamResultService examResultService;
    private final QuestionPaperService questionPaperService;

    @PostConstruct
    private void prepareListeners() {
        StudentExamTableBtnPanel studentExamTableBtnPanel = studentExamFrame.getTableBtnPanel();
        registerAction(studentExamTableBtnPanel.getStartExamBtn(), (e) -> startExam());
        registerAction(viewQuestionFrame.getNextBtn(), (e) -> getNextQuestion());
        registerAction(viewQuestionFrame.getPrevBtn(), (e) -> getPreviousQuestion());
    }


    private void getNextQuestion() {
        NextQuestionPayload nextQuestionPayload = viewQuestionFrame.getQuestionNumberFromForm();
        try {
            Question question = questionService.getNextQuestion(nextQuestionPayload);
            viewQuestionFrame.setVisible(false);
            viewQuestionFrame.setViewQuestionForm(question);
            viewQuestionFrame.setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void getPreviousQuestion() {
        NextQuestionPayload nextQuestionPayload = viewQuestionFrame.getQuestionNumberFromForm();
        Question question = questionService.getPreviousQuestion(nextQuestionPayload);
        viewQuestionFrame.setVisible(false);
        viewQuestionFrame.setViewQuestionForm(question);
        viewQuestionFrame.setVisible(true);
    }

    private void startExam() {
        try {
            JTable questionPaperTable = studentExamFrame.getStudentExamTablePanel().getQuestionPaperTable();
            int selectedRow = questionPaperTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                QuestionPaper questionPaper = questionPaperTableModel.getEntityByRow(selectedRow);
                List<Question> questionList = questionService.findAllQuestionsByQuestionPaperId(questionPaper.getId());
                String studentId = questionPaperService.getUserIDRecordFromStore();
                viewQuestionFrame.setViewQuestionForm(questionList.get(0));
                examResultService.saveExamResult(questionPaper.getId(), studentId);
                viewQuestionFrame.setVisible(true);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

    @Override
    public void prepareAndOpenFrame() {
    }
}
