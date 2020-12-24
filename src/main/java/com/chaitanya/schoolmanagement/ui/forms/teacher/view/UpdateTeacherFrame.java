package com.chaitanya.schoolmanagement.ui.forms.teacher.view;

import com.chaitanya.schoolmanagement.ui.forms.teacher.view.modal.UpdateTeacherFormBtnPanel;
import com.chaitanya.schoolmanagement.ui.forms.teacher.view.modal.UpdateTeacherFormPanel;
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
public class UpdateTeacherFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 750;
    private static final int DEFAULT_HEIGHT = 340;

    private final UpdateTeacherFormBtnPanel formBtnPanel;
    private final UpdateTeacherFormPanel formPanel;

    @PostConstruct
    private void prepareFrame() {
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.Labels.UPDATE_STUDENT);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }
}
