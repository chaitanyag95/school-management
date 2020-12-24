package com.chaitanya.schoolmanagement.ui.forms.login.teacher.view;


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
public class TeacherLoginFrame extends JDialog {

    private final TeacherLoginFormPanel teacherLoginFormPanel;
    private final TeacherLoginFormBtnPanel teacherLoginFormBtnPanel;

    @PostConstruct
    private void prepareFrame() {
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.DialogTitles.TEACHER_LOGIN_MODAL);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setBounds(100, 100, 400, 250);
        setModal(true);
    }

    private void initComponents() {
        add(teacherLoginFormPanel, BorderLayout.CENTER);
        add(teacherLoginFormBtnPanel, BorderLayout.SOUTH);
    }

}
