package com.chaitanya.schoolmanagement.ui.forms.student.welcome.view;

import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
@AllArgsConstructor
@Getter
public class WelcomeStudentFrame extends JDialog {
    private final WelcomeStudentPanel welcomeStudentPanel;
    private final StudentDashboardBtnPanel studentDashboardBtnPanel;
    private static final int DEFAULT_WIDTH = 750;
    private static final int DEFAULT_HEIGHT = 400;


    @PostConstruct
    private void prepareFrame() {
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.DialogTitles.WELCOME_STUDENT_MODAL);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    private void initComponents() {
        add(welcomeStudentPanel, BorderLayout.CENTER);
        add(studentDashboardBtnPanel, BorderLayout.SOUTH);
    }

}
