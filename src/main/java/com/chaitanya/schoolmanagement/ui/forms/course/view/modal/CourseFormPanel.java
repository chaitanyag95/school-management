package com.chaitanya.schoolmanagement.ui.forms.course.view.modal;


import com.chaitanya.schoolmanagement.model.course.Course;
import com.chaitanya.schoolmanagement.util.border.Borders;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class CourseFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 5;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JTextField nameTF;


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
        JLabel nameLbl = new JLabel(ConstMessagesEN.Labels.COURSE_NAME);
        nameTF = new JTextField(TEXT_FIELD_COLUMNS);
        add(nameLbl);
        add(nameTF);

    }

    public Course getEntityFromForm() {
        return new Course(
                nameTF.getText()
        );
    }

    public void clearForm() {
        nameTF.setText(Strings.EMPTY);
    }

}
