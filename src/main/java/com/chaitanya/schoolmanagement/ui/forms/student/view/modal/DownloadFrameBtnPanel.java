package com.chaitanya.schoolmanagement.ui.forms.student.view.modal;

import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Component
@Getter
public class DownloadFrameBtnPanel extends JPanel {
    private JButton saveAsCsvBtn;
    private JButton saveAsExcelBtn;
    private JButton cancelBtn;

    @PostConstruct
    private void initPanel() {
        initComponents();
    }

    private void initComponents() {
        saveAsCsvBtn = new JButton(ConstMessagesEN.Labels.SaveAsCSV);
        add(saveAsCsvBtn);
        saveAsExcelBtn = new JButton(ConstMessagesEN.Labels.SaveAsExcel);
        add(saveAsExcelBtn);
        cancelBtn = new JButton(ConstMessagesEN.Labels.CANCEL_BTN);
        add(cancelBtn);
    }
}
