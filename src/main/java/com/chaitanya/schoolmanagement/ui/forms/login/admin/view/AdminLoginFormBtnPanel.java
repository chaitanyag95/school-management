package com.chaitanya.schoolmanagement.ui.forms.login.admin.view;


import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Component
@Getter
public class AdminLoginFormBtnPanel extends JPanel {

    private JButton loginBtn;
    private JButton cancelBtn;

    @PostConstruct
    private void initPanel() {
        initComponents();
    }

    private void initComponents() {
        loginBtn = new JButton(ConstMessagesEN.Labels.LOGIN);
        add(loginBtn);

        cancelBtn = new JButton(ConstMessagesEN.Labels.CANCEL_BTN);
        add(cancelBtn);
    }

}
