package com.chaitanya.schoolmanagement.ui.forms.login.admin.view;


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
public class AdminLoginFrame extends JDialog {

    private final AdminLoginFormPanel adminLoginFormPanel;
    private final AdminLoginFormBtnPanel adminLoginFormBtnPanel;

    @PostConstruct
    private void prepareFrame() {
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.DialogTitles.ADMIN_LOGIN_MODAL);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setBounds(100, 100, 400, 250);
        setModal(true);
    }

    private void initComponents() {
        add(adminLoginFormPanel, BorderLayout.CENTER);
        add(adminLoginFormBtnPanel, BorderLayout.SOUTH);
    }

}
