package com.chaitanya.schoolmanagement.ui.forms.student.welcome.controller;

import com.chaitanya.schoolmanagement.model.exam.QuestionPaper;
import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.service.exam.QuestionPaperService;
import com.chaitanya.schoolmanagement.ui.forms.exam.controller.ExamController;
import com.chaitanya.schoolmanagement.ui.forms.exam.view.ExamFrame;
import com.chaitanya.schoolmanagement.ui.forms.question.view.AddQuestionFrame;
import com.chaitanya.schoolmanagement.ui.forms.student.exam.model.StudentExamTableModel;
import com.chaitanya.schoolmanagement.ui.forms.student.exam.view.StudentExamFrame;
import com.chaitanya.schoolmanagement.ui.forms.student.welcome.view.StudentDashboardBtnPanel;
import com.chaitanya.schoolmanagement.ui.forms.student.welcome.view.WelcomeStudentFrame;
import com.chaitanya.schoolmanagement.ui.forms.student.welcome.view.WelcomeStudentPanel;
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class WelcomeStudentController extends AbstractFrameController {
    private final WelcomeStudentFrame welcomeStudentFrame;
    private final WelcomeStudentPanel welcomeStudentPanel;
    private final ExamController examController;
    private final StudentExamFrame examFrame;
    private final QuestionPaperService questionPaperService;
    private final StudentExamTableModel studentExamTableModel;


    @PostConstruct
    private void prepareListeners() {
        StudentDashboardBtnPanel studentDashboardBtnPanel = welcomeStudentFrame.getStudentDashboardBtnPanel();
        registerAction(studentDashboardBtnPanel.getExamBtn(), (e) -> openOngoingExam());
    }

    private void openOngoingExam() {
        loadQuestionPapers();
        welcomeStudentFrame.setVisible(false);
        examFrame.setVisible(true);
    }

    public void loadQuestionPapers() {
        List<QuestionPaper> questionPapers = questionPaperService.getAllQuestionPapers();
        studentExamTableModel.clear();
        studentExamTableModel.addEntities(questionPapers);
    }


    public void prepareAndOpenFrame(Student student) {
        loadStudent(student);
        showWelcomeStudentFrame();
    }

    private void showWelcomeStudentFrame() {
        welcomeStudentFrame.setVisible(true);
    }

    private void loadStudent(Student student) {
        welcomeStudentPanel.setStudentForm(student);
    }

    @Override
    public void prepareAndOpenFrame() {
    }
}
