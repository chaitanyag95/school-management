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

    private JButton createStudentBtn;
    private JButton studentListBtn;

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
        setResizable(false);
        LookAndFeelUtils.setWindowsLookAndFeel();
        setLayout(new GridLayout(1, 2, 200, 200));
        setTitle("Student Management System");
    }

    private void initComponents() {
        createStudentBtn = new JButton(ConstMessagesEN.Labels.CREATE_STUDENT);
        studentListBtn = new JButton(ConstMessagesEN.Labels.STUDENT_LIST);

        add(createStudentBtn);
        add(studentListBtn);
    }

}
