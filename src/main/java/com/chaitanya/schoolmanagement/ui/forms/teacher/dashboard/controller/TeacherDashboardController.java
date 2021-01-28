package com.chaitanya.schoolmanagement.ui.forms.teacher.dashboard.controller;

import com.chaitanya.schoolmanagement.model.teacher.Teacher;
import com.chaitanya.schoolmanagement.ui.forms.exam.controller.ExamController;
import com.chaitanya.schoolmanagement.ui.forms.teacher.dashboard.view.AddQuestionBtn;
import com.chaitanya.schoolmanagement.ui.forms.teacher.dashboard.view.TeacherDashboardFrame;
import com.chaitanya.schoolmanagement.ui.forms.teacher.dashboard.view.TeacherDashboardPanel;
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
@AllArgsConstructor
@Slf4j
public class TeacherDashboardController extends AbstractFrameController {
    private final TeacherDashboardFrame teacherDashboardFrame;
    private final TeacherDashboardPanel teacherDashboardPanel;
    private final ExamController examController;


    @PostConstruct
    private void prepareListeners() {
        AddQuestionBtn addQuestionBtn = teacherDashboardFrame.getAddQuestionBtn();
        registerAction(addQuestionBtn.getAddQuestion(), (e) -> showAddQuestionFrame());
    }

    private void showAddQuestionFrame() {
        examController.prepareAndOpenFrame();
        teacherDashboardFrame.setVisible(false);
    }

    public void prepareAndOpenFrame(Teacher teacher) {
        loadTeacher(teacher);
        showTeacherDashboard();
    }

    private void showTeacherDashboard() {
        teacherDashboardFrame.setVisible(true);
    }

    private void loadTeacher(Teacher teacher) {
        teacherDashboardPanel.setTeacherForm(teacher);
    }

    @Override
    public void prepareAndOpenFrame() {

    }
}
