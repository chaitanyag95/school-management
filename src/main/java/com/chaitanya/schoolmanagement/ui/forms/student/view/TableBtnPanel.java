package com.chaitanya.schoolmanagement.ui.forms.student.view;

import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Component
@Getter
public class TableBtnPanel extends JPanel {

    private JButton addBtn;
    private JButton removeBtn;
    private JButton editBtn;

    @PostConstruct
    private void preparePanel() {
        initComponents();
    }

    private void initComponents() {
        addBtn = new JButton(ConstMessagesEN.Labels.ADD_BTN);
        add(addBtn);

        editBtn = new JButton(ConstMessagesEN.Labels.EDIT);
        add(editBtn);

        removeBtn = new JButton(ConstMessagesEN.Labels.REMOVE_BTN);
        add(removeBtn);
    }

}
