package com.chaitanya.schoolmanagement.ui.forms.student.welcome.view;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Component
@Getter
public class StudentDashboardBtnPanel extends JPanel {
    private JButton examBtn;

    @PostConstruct
    private void preparePanel() {
        initComponents();
    }

    private void initComponents() {
        examBtn = new JButton("Ongoing Exams");
        add(examBtn);
    }
}
