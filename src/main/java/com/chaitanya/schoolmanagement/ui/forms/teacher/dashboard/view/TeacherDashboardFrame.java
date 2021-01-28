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


    @PostConstruct
    private void prepareFrame() {
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.DialogTitles.TEACHER_DASHBOARD);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        //setBounds(200, 200, 600, 600);
        setSize(900, 980);
        setResizable(true);
        setModal(true);
    }

    private void initComponents() {
        //setSize(600, 600);
        add(teacherDashboardPanel, BorderLayout.CENTER);
        add(addQuestionBtn,BorderLayout.SOUTH);
    }

}
