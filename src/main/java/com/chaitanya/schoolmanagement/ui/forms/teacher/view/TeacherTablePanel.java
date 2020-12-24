package com.chaitanya.schoolmanagement.ui.forms.teacher.view;

import com.chaitanya.schoolmanagement.ui.forms.teacher.model.TeacherTableModel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
@Getter
public class TeacherTablePanel extends JPanel {

    private final TeacherTableModel teacherTableModel;

    private JTable teacherTable;


    TeacherTablePanel(TeacherTableModel teacherTableModel) {
        this.teacherTableModel = teacherTableModel;
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
        teacherTable = new JTable(teacherTableModel);
        teacherTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane paneWithTable = new JScrollPane(teacherTable);
        add(paneWithTable, BorderLayout.CENTER);
    }

}
