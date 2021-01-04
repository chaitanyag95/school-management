package com.chaitanya.schoolmanagement.ui.forms.student.view.modal;

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
public class DownloadDataFrame extends JDialog {
    private DownloadFrameBtnPanel downloadFrameBtnPanel;

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
        add(downloadFrameBtnPanel, BorderLayout.CENTER);
    }
}
