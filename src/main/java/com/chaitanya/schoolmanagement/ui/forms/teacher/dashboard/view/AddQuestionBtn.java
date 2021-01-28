package com.chaitanya.schoolmanagement.ui.forms.teacher.dashboard.view;

import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Component
@Getter
public class AddQuestionBtn extends  JPanel{
    private JButton addQuestion;


    @PostConstruct
    private void initPanel() {
        initComponents();
    }

    private void initComponents() {
        addQuestion = new JButton(ConstMessagesEN.Labels.ADD_QUESTION);
        add(addQuestion);
    }
}
