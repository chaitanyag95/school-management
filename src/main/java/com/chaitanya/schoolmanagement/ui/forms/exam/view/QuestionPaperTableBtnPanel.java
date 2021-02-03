package com.chaitanya.schoolmanagement.ui.forms.exam.view;

import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Component
@Getter
public class QuestionPaperTableBtnPanel extends JPanel {
    private JButton addQuestionBtn;
    private JButton removeBtn;
    private JButton editQuestionPaperBtn;
    private JButton backBtn;


    @PostConstruct
    private void preparePanel() {
        initComponents();
    }

    private void initComponents() {
        addQuestionBtn = new JButton(ConstMessagesEN.Labels.ADD_QUESTION);
        add(addQuestionBtn);

        editQuestionPaperBtn = new JButton(ConstMessagesEN.Labels.EDIT_QUESTION_PAPER);
        add(editQuestionPaperBtn);

        removeBtn = new JButton(ConstMessagesEN.Labels.REMOVE_BTN);
        add(removeBtn);

        backBtn = new JButton("Back");
        add(backBtn);
    }
}
