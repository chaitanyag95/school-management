package com.chaitanya.schoolmanagement.ui.forms.student.exam.view;

import com.chaitanya.schoolmanagement.ui.forms.student.exam.model.StudentExamTableModel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
@Getter
public class StudentExamTablePanel extends JPanel {

    private final StudentExamTableModel studentExamTableModel;

    private JTable questionPaperTable;

    StudentExamTablePanel(StudentExamTableModel studentExamTableModel) {
        this.studentExamTableModel = studentExamTableModel;
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
        questionPaperTable = new JTable(studentExamTableModel);
        questionPaperTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane paneWithTable = new JScrollPane(questionPaperTable);
        add(paneWithTable, BorderLayout.CENTER);
    }
}