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
public class AddTeacherFrame extends JDialog {

    private final TeacherFormPanel teacherFormPanel;
    private final TeacherFormBtnPanel teacherFormBtnPanel;

    @PostConstruct
    private void prepareFrame() {
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.DialogTitles.TEACHER_MODAL);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }

    private void initComponents() {
        add(teacherFormPanel, BorderLayout.CENTER);
        add(teacherFormBtnPanel, BorderLayout.SOUTH);
    }

}
