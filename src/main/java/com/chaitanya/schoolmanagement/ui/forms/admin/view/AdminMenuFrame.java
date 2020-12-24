package com.chaitanya.schoolmanagement.ui.forms.admin.view;

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
public class AdminMenuFrame extends JFrame {

    private JButton studentBtn;
    private JButton courseBtn;
    private JButton teacherBtn;


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
        setLayout(new GridLayout(1, 3, 200, 20));
        setTitle("Welcome Admin");
    }

    private void initComponents() {
        studentBtn = new JButton(ConstMessagesEN.Labels.STUDENT);
        courseBtn = new JButton(ConstMessagesEN.Labels.COURSES);
        teacherBtn = new JButton(ConstMessagesEN.Labels.TEACHERS);


        add(studentBtn);
        add(courseBtn);
        add(teacherBtn);


    }

}
