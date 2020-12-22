package com.chaitanya.schoolmanagement.ui.forms.student.view;


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
public class StudentFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 750;
    private static final int DEFAULT_HEIGHT = 340;

    private final StudentTablePanel studentTablePanel;
    private final TableBtnPanel tableBtnPanel;

    @PostConstruct
    private void prepareFrame() {
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.Labels.CLIENTS);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(studentTablePanel, BorderLayout.CENTER);
        add(tableBtnPanel, BorderLayout.SOUTH);
    }

}
