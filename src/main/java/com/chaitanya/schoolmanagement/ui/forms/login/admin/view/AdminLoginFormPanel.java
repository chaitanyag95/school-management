package com.chaitanya.schoolmanagement.ui.forms.login.admin.view;


import com.chaitanya.schoolmanagement.payload.LoginDto;
import com.chaitanya.schoolmanagement.util.border.Borders;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class AdminLoginFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 6;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;


    private JTextField emailTF;
    private JPasswordField passwordTF;


    @PostConstruct
    private void preparePanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel emailLbl = new JLabel(ConstMessagesEN.Labels.EMAIL);
        JLabel phoneNumberLbl = new JLabel(ConstMessagesEN.Labels.PASSWORD);
        emailLbl.setHorizontalAlignment(SwingConstants.LEFT);
        emailLbl.setBounds(10, 11, 120, 25);
        emailLbl.setFont(new Font("Arial", Font.BOLD, 14));

        emailTF = new JTextField(TEXT_FIELD_COLUMNS);
        emailTF.setFont(new Font("Arial", Font.PLAIN, 14));
        emailTF.setBounds(140, 11, 200, 25);
        passwordTF = new JPasswordField(TEXT_FIELD_COLUMNS);


        add(emailLbl);
        add(emailTF);

        add(phoneNumberLbl);
        add(passwordTF);

    }

    public LoginDto getClientFromForm() {
        return new LoginDto(
                emailTF.getText(),
                new String(passwordTF.getPassword())
        );
    }

    public void clearForm() {
        emailTF.setText(Strings.EMPTY);
        passwordTF.setText(Strings.EMPTY);
    }

}
