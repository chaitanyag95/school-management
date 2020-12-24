package com.chaitanya.schoolmanagement.ui.forms.student.welcome.view;

import com.chaitanya.schoolmanagement.ui.forms.student.view.modal.FormBtnPanel;
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


    @PostConstruct
    private void prepareFrame() {
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.DialogTitles.WELCOME_STUDENT_MODAL);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        //setBounds(200, 200, 600, 600);
        setSize(600, 600);
        setResizable(true);
        setModal(true);
    }

    private void initComponents() {
        setSize(600, 600);
        add(welcomeStudentPanel, BorderLayout.CENTER);
    }

}
