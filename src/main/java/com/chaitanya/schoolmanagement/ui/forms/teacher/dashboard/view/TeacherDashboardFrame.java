package com.chaitanya.schoolmanagement.ui.forms.teacher.dashboard.view;


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
public class TeacherDashboardFrame extends JDialog {
    private final TeacherDashboardPanel teacherDashboardPanel;
    private final AddQuestionBtn addQuestionBtn;
    private static final int DEFAULT_WIDTH = 750;
    private static final int DEFAULT_HEIGHT = 400;


    @PostConstruct
    private void prepareFrame() {
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.DialogTitles.TEACHER_DASHBOARD);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    private void initComponents() {
        //setSize(600, 600);
        add(teacherDashboardPanel, BorderLayout.CENTER);
        add(addQuestionBtn,BorderLayout.SOUTH);
    }

}
