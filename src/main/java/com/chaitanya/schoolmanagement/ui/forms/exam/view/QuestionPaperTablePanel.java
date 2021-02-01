package com.chaitanya.schoolmanagement.ui.forms.exam.view;

import com.chaitanya.schoolmanagement.ui.forms.exam.model.QuestionPaperTableModel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
@Getter
public class QuestionPaperTablePanel extends JPanel {

    private final QuestionPaperTableModel questionPaperTableModel;

    private JTable questionPaperTable;

    QuestionPaperTablePanel(QuestionPaperTableModel questionPaperTableModel) {
        this.questionPaperTableModel = questionPaperTableModel;
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
        questionPaperTable = new JTable(questionPaperTableModel);
        questionPaperTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane paneWithTable = new JScrollPane(questionPaperTable);
        add(paneWithTable, BorderLayout.CENTER);
    }
}