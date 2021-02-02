package com.chaitanya.schoolmanagement.ui.forms.exam.view;

import com.chaitanya.schoolmanagement.ui.forms.exam.model.QuestionPaperTableModel;
import com.chaitanya.schoolmanagement.ui.forms.exam.model.QuestionTableModel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
@Getter
public class QuestionTablePanel extends JPanel {

    private final QuestionTableModel questionTableModel;

    private JTable questionTable;


    QuestionTablePanel(QuestionTableModel questionTableModel) {
        this.questionTableModel = questionTableModel;
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
        questionTable = new JTable(questionTableModel);
        questionTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane paneWithTable = new JScrollPane(questionTable);
        add(paneWithTable, BorderLayout.CENTER);
    }
}
