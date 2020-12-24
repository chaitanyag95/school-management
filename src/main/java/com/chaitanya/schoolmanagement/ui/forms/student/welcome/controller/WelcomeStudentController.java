package com.chaitanya.schoolmanagement.ui.forms.student.welcome.controller;

import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.ui.forms.student.welcome.view.WelcomeStudentFrame;
import com.chaitanya.schoolmanagement.ui.forms.student.welcome.view.WelcomeStudentPanel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
@Slf4j
public class WelcomeStudentController {
    private WelcomeStudentFrame welcomeStudentFrame;
    private WelcomeStudentPanel welcomeStudentPanel;


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
}
