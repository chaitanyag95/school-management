package com.chaitanya.schoolmanagement.ui.forms.teacher.view.modal;

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
public class DownloadTeacherDataFrame extends JDialog {
    private DownloadTeacherFrameBtnPanel downloadTeacherFrameBtnPanel;

    @PostConstruct
    private void prepareFrame() {
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.DialogTitles.STUDENT_MODAL);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setModal(true);
    }

    private void initComponents() {
        add(downloadTeacherFrameBtnPanel, BorderLayout.CENTER);
    }
}
