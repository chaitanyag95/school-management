package com.chaitanya.schoolmanagement.ui.forms.student.welcome.view;

import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.util.border.Borders;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Slf4j
@Component
public class WelcomeStudentPanel extends JPanel {
    private static final int LAYOUT_ROWS = 6;
    private static final int LAYOUT_COLS = 5;
    private static final int HORIZONTAL_GAP = 30;
    private static final int VERTICAL_GAP = 40;
    private static final int TEXT_FIELD_COLUMNS = 20;


    private JLabel nameTF;
    private JLabel phoneNumberTF;
    private JLabel emailTF;
    private JLabel courseTF;

    @PostConstruct
    private void preparePanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
        setSize(600, 600);
    }

    private void initComponents() {
        JLabel nameLbl = new JLabel(ConstMessagesEN.Labels.NAME);
        JLabel courseLbl = new JLabel(ConstMessagesEN.Labels.COURSE);
        JLabel phoneNumberLbl = new JLabel(ConstMessagesEN.Labels.PHONE_NUMBER);
        JLabel emailLbl = new JLabel(ConstMessagesEN.Labels.EMAIL);


        nameTF = new JLabel();
        phoneNumberTF = new JLabel();
        emailTF = new JLabel();
        courseTF = new JLabel();


        add(nameLbl);
        add(nameTF);
        add(phoneNumberLbl);
        add(phoneNumberTF);
        add(emailLbl);
        add(emailTF);
        add(courseLbl);
        add(courseTF);
    }

    public void setStudentForm(Student student) {
        log.info("******** setting  student for welcome frame **********");
        nameTF.setText(student.getFullName());
        courseTF.setText(student.getCourse().getName());
        phoneNumberTF.setText(student.getPhoneNumber());
        emailTF.setText(student.getEmail());
    }
}
