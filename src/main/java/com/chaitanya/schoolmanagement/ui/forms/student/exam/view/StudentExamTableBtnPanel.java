package com.chaitanya.schoolmanagement.ui.forms.student.exam.view;

import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Component
@Getter
public class StudentExamTableBtnPanel extends JPanel {
    private JButton startExamBtn;
    private JButton backBtn;


    @PostConstruct
    private void preparePanel() {
        initComponents();
    }

    private void initComponents() {
        startExamBtn = new JButton("Start Exam");
        add(startExamBtn);

        backBtn = new JButton("Back");
        add(backBtn);
    }
}
