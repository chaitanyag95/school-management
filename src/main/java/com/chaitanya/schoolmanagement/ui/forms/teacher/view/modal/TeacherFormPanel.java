package com.chaitanya.schoolmanagement.ui.forms.teacher.view.modal;

import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.model.teacher.Teacher;
import com.chaitanya.schoolmanagement.ui.forms.student.model.CourseComboBoxModel;
import com.chaitanya.schoolmanagement.util.border.Borders;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
@Slf4j
public class TeacherFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 6;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;
    private final CourseComboBoxModel courseComboBoxModel;


    private JTextField nameTF;
    private JTextField phoneNumberTF;
    private JTextField emailTF;
    private JPasswordField passwordField;
    private JComboBox<Course> courseCB;

    public TeacherFormPanel(CourseComboBoxModel courseComboBoxModel) {
        this.courseComboBoxModel = courseComboBoxModel;
    }

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
        JLabel nameLbl = new JLabel(ConstMessagesEN.Labels.NAME);
        JLabel courseLbl = new JLabel(ConstMessagesEN.Labels.COURSE);
        JLabel phoneNumberLbl = new JLabel(ConstMessagesEN.Labels.PHONE_NUMBER);
        JLabel emailLbl = new JLabel(ConstMessagesEN.Labels.EMAIL);
        JLabel passwordLbl = new JLabel(ConstMessagesEN.Labels.PASSWORD);


        nameTF = new JTextField(TEXT_FIELD_COLUMNS);
        courseCB = new JComboBox<>(courseComboBoxModel);
        phoneNumberTF = new JTextField(TEXT_FIELD_COLUMNS);
        emailTF = new JTextField(TEXT_FIELD_COLUMNS);
        passwordField = new JPasswordField(TEXT_FIELD_COLUMNS);


        add(nameLbl);
        add(nameTF);
        add(phoneNumberLbl);
        add(phoneNumberTF);
        add(emailLbl);
        add(emailTF);
        add(passwordLbl);
        add(passwordField);
        add(courseLbl);
        add(courseCB);
    }


    public Teacher getTeacherFromForm() {
        return new Teacher(nameTF.getText(), emailTF.getText(), courseComboBoxModel.getSelectedItem(), phoneNumberTF.getText(),new String(passwordField.getPassword()));
    }


    public void clearForm() {
        nameTF.setText(Strings.EMPTY);
        courseCB.setSelectedIndex(0);
        phoneNumberTF.setText(Strings.EMPTY);
        emailTF.setText(Strings.EMPTY);
        courseCB.setSelectedIndex(0);
        passwordField.setText(Strings.EMPTY);
    }

}
