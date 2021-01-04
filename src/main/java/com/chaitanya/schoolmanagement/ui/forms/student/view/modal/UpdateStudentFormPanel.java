package com.chaitanya.schoolmanagement.ui.forms.student.view.modal;

import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.ui.forms.student.model.CourseComboBoxModel;
import com.chaitanya.schoolmanagement.util.border.Borders;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
@Slf4j
@Setter
@Getter
public class UpdateStudentFormPanel extends JPanel {
    private static final int LAYOUT_ROWS = 6;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;
    private final CourseComboBoxModel courseComboBoxModel;


    private JTextField nameTF;
    private JComboBox<Course> courseCB;
    private JTextField phoneNumberTF;
    private JTextField emailTF;
    private String studentId;

    public UpdateStudentFormPanel(CourseComboBoxModel courseComboBoxModel) {
        this.courseComboBoxModel = courseComboBoxModel;
    }

    @PostConstruct
    public void preparePanel() {
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


        nameTF = new JTextField(TEXT_FIELD_COLUMNS);
        courseCB = new JComboBox<>(courseComboBoxModel);
        phoneNumberTF = new JTextField(TEXT_FIELD_COLUMNS);
        emailTF = new JTextField(TEXT_FIELD_COLUMNS);


        add(nameLbl);
        add(nameTF);
        add(courseLbl);
        add(courseCB);
        add(phoneNumberLbl);
        add(phoneNumberTF);
        add(emailLbl);
        add(emailTF);
    }


    public Student getStudentFromUpdateStudentForm() {
        Student student = new Student(studentId, nameTF.getText(), emailTF.getText(), courseComboBoxModel.getSelectedItem(), phoneNumberTF.getText());
        return student;
    }

    public void clearForm() {
        nameTF.setText(Strings.EMPTY);
        phoneNumberTF.setText(Strings.EMPTY);
        emailTF.setText(Strings.EMPTY);
    }

    public void setStudentForm(Student student) {
        log.info("******** setting update student form field **********");
        nameTF.setText(student.getFullName());
        phoneNumberTF.setText(student.getPhoneNumber());
        emailTF.setText(student.getEmail());
        courseCB.getModel().setSelectedItem(student.getCourse());
        studentId = student.getId();
    }
}
