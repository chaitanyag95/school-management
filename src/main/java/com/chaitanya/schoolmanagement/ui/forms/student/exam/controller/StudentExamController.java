package com.chaitanya.schoolmanagement.ui.forms.student.exam.controller;

import com.chaitanya.schoolmanagement.enums.ResultStatus;
import com.chaitanya.schoolmanagement.model.exam.ExamResult;
import com.chaitanya.schoolmanagement.model.exam.Question;
import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.payload.NextQuestionPayload;
import com.chaitanya.schoolmanagement.service.exam.ExamResultService;
import com.chaitanya.schoolmanagement.service.exam.QuestionPaperService;
import com.chaitanya.schoolmanagement.service.exam.QuestionService;
import com.chaitanya.schoolmanagement.ui.forms.question.view.ViewQuestionFrame;
import com.chaitanya.schoolmanagement.ui.forms.student.exam.model.StudentExamTableModel;
import com.chaitanya.schoolmanagement.ui.forms.student.exam.view.StudentExamFrame;
import com.chaitanya.schoolmanagement.ui.forms.student.exam.view.StudentExamTableBtnPanel;
import com.chaitanya.schoolmanagement.ui.forms.student.exam.view.StudentResultWindow;
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
    private final StudentResultWindow studentResultWindow;

    @PostConstruct
    private void prepareListeners() {
        StudentExamTableBtnPanel studentExamTableBtnPanel = studentExamFrame.getTableBtnPanel();
        registerAction(studentExamTableBtnPanel.getStartExamBtn(), (e) -> startExam());
        registerAction(viewQuestionFrame.getNextBtn(), (e) -> getNextQuestion());
        registerAction(viewQuestionFrame.getPrevBtn(), (e) -> getPreviousQuestion());
        registerAction(viewQuestionFrame.getSubmitBtn(), (e) -> submitExam());
        registerAction(studentExamTableBtnPanel.getResultBtn(), (e) -> seeResultWindow());
    }

    private void seeResultWindow() {
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
                String studentId = questionPaperService.getUserIDRecordFromStore();
                ExamResult examResult = examResultService.getExamResultByQuestionPaperAndStudentId(questionPaper.getId(), studentId);
                studentResultWindow.setExamResult(examResult, questionPaper, studentId);
                studentResultWindow.setVisible(true);
            }
        } catch (Exception e) {
            Notifications.showNotAppearedErrorMessage();
        }
    }

    private void submitExam() {
        String examResultId = questionPaperService.getExamResultIdFromStore();
        ExamResult examResult = examResultService.getExamResultById(examResultId);
        int correctQuestion = examResult.getCorrectQuestion();
        int totalQuestion = examResult.getTotalQuestion();
        try {
            double percentage = (correctQuestion * 100) / totalQuestion;
            if (percentage > 33) {
                examResult.setResult(ResultStatus.PASSED);
            } else {
                examResult.setResult(ResultStatus.FAILED);
            }
            examResult.setPercentage(percentage);
            examResultService.save(examResult);
            viewQuestionFrame.setVisible(false);
            String studentId = questionPaperService.getUserIDRecordFromStore();
            QuestionPaper questionPaper = questionPaperService.getQuestionPaperById(questionPaperService.getQuestionPaperIdFromStore()).get();
            studentResultWindow.setExamResult(examResult, questionPaper, studentId);
            studentResultWindow.setVisible(true);
        } catch (ArithmeticException arithmeticException) {
            System.out.println(arithmeticException.getStackTrace());
        }
    }


    private void getNextQuestion() {
        NextQuestionPayload nextQuestionPayload = viewQuestionFrame.getQuestionNumberFromForm();
        examResultService.save(viewQuestionFrame.getExamResultFromForm());
        try {
            Question question = questionService.getNextQuestion(nextQuestionPayload);
            viewQuestionFrame.setVisible(false);
            viewQuestionFrame.setViewQuestionForm(question);
            viewQuestionFrame.clearSelection();
            viewQuestionFrame.setVisible(true);
        } catch (NullPointerException nullPointerException) {
            log.info("******* this is last question ******** -> from null pointer exception of getNextQuestion() -> StudentExamController ");
            Notifications.showLastQuestionMessage();
            Question question = questionService.getQuestionById(nextQuestionPayload.getQuestionId());
            viewQuestionFrame.setVisible(false);
            viewQuestionFrame.setViewQuestionForm(question);
            viewQuestionFrame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void getPreviousQuestion() {

        NextQuestionPayload nextQuestionPayload = viewQuestionFrame.getQuestionNumberFromForm();
        try {
            Question question = questionService.getPreviousQuestion(nextQuestionPayload);
            viewQuestionFrame.setVisible(false);
            viewQuestionFrame.setViewQuestionForm(question);
            viewQuestionFrame.setVisible(true);
        } catch (NullPointerException e) {
            log.info("******* this is first question ******** -> from null pointer exception of getPreviousQuestion() -> StudentExamController ");
            Notifications.showPreviousQuestionMessage(viewQuestionFrame);
            Question question = questionService.getQuestionById(nextQuestionPayload.getQuestionId());
            viewQuestionFrame.setVisible(false);
            viewQuestionFrame.setViewQuestionForm(question);
            viewQuestionFrame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
                ExamResult examResult = examResultService.getExamResultByQuestionPaperAndStudentId(questionPaper.getId(), questionPaperService.getUserIDRecordFromStore());
                if (examResult == null) {
                    List<Question> questionList = questionService.findAllQuestionsByQuestionPaperId(questionPaper.getId());
                    String studentId = questionPaperService.getUserIDRecordFromStore();
                    viewQuestionFrame.setViewQuestionForm(questionList.get(0));
                    viewQuestionFrame.startTimer();
                    examResultService.saveExamResult(questionPaper.getId(), studentId);
                    viewQuestionFrame.setVisible(true);
                } else {
                    Notifications.showAppearedErrorMessage();
                }
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }


    @Override
    public void prepareAndOpenFrame() {
    }
}
