package com.chaitanya.schoolmanagement.ui.forms.student.view;

import com.chaitanya.schoolmanagement.ui.forms.student.model.StudentTableModel;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
@Getter
public class StudentTablePanel extends JPanel {

    private final StudentTableModel studentTableModel;

    private JTable studentTable;


    StudentTablePanel(StudentTableModel studentTableModel) {
        this.studentTableModel = studentTableModel;
    }

    @PostConstruct
    private void preparePanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setLayout(new BorderLayout());
    }

    private void initComponents() {
        studentTable = new JTable(studentTableModel);
        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane paneWithTable = new JScrollPane(studentTable);
        add(paneWithTable, BorderLayout.CENTER);
    }

}
