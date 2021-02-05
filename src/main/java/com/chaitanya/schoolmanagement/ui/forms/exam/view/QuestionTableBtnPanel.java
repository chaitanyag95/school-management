package com.chaitanya.schoolmanagement.ui.forms.exam.view;

import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Component
@Getter
public class QuestionTableBtnPanel extends JPanel {
    private JButton addQuestionBtn;
    private JButton removeBtn;
    private JButton editQuestionBtn;
    private JButton viewQuestionBtn;


    @PostConstruct
    private void preparePanel() {
        initComponents();
    }

    private void initComponents() {
        addQuestionBtn = new JButton(ConstMessagesEN.Labels.ADD_QUESTION);
        add(addQuestionBtn);

        editQuestionBtn = new JButton(ConstMessagesEN.Labels.EDIT_QUESTION_PAPER);
        add(editQuestionBtn);

        removeBtn = new JButton(ConstMessagesEN.Labels.REMOVE_BTN);
        add(removeBtn);

        viewQuestionBtn = new JButton(ConstMessagesEN.Labels.VIEW);
        add(viewQuestionBtn);

    }
}
