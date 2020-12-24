package com.chaitanya.schoolmanagement.ui.forms.main.view;

import com.chaitanya.schoolmanagement.util.border.Borders;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import com.chaitanya.schoolmanagement.util.ui.LookAndFeelUtils;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;


@Component
@Getter
public class MainMenuFrame extends JFrame {

    private JButton studentBtn;
    private JButton teacherBtn;
    private JButton adminBtn;

    @PostConstruct
    private void prepareFrame() {
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        getRootPane().setBorder(Borders.createEmptyBorder());
        setTitle(ConstMessagesEN.Labels.MAIN_MENU);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        LookAndFeelUtils.setWindowsLookAndFeel();
        setLayout(new GridLayout(1, 2, 200, 200));
        setTitle("Student Management System");
    }

    private void initComponents() {
        studentBtn = new JButton(ConstMessagesEN.Labels.STUDENT);
        teacherBtn = new JButton(ConstMessagesEN.Labels.TEACHERS);
        adminBtn = new JButton(ConstMessagesEN.Labels.ADMIN);
        add(adminBtn);
        add(teacherBtn);
        add(studentBtn);
    }

}
