package com.chaitanya.schoolmanagement.ui.forms.student.view.modal;

import com.chaitanya.schoolmanagement.model.address.AddressEntity;
import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.ui.forms.student.model.AddressComboBoxModel;
import com.chaitanya.schoolmanagement.util.border.Borders;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class FormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 6;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;
    private final AddressComboBoxModel addressComboBoxModel;


    private JTextField nameTF;
    private JTextField courseTF;
    private JTextField phoneNumberTF;
    private JTextField emailTF;
    private JComboBox<AddressEntity> addressCB;

    public FormPanel(AddressComboBoxModel addressComboBoxModel) {
        this.addressComboBoxModel = addressComboBoxModel;
    }

    @PostConstruct
    private void preparePanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel nameLbl = new JLabel(ConstMessagesEN.Labels.NAME);
        JLabel courseLbl = new JLabel(ConstMessagesEN.Labels.COURSE);
        JLabel addressLbl = new JLabel(ConstMessagesEN.Labels.ADDRESS);
        JLabel phoneNumberLbl = new JLabel(ConstMessagesEN.Labels.PHONE_NUMBER);
        JLabel emailLbl = new JLabel(ConstMessagesEN.Labels.EMAIL);


        nameTF = new JTextField(TEXT_FIELD_COLUMNS);
        courseTF = new JTextField(TEXT_FIELD_COLUMNS);
        addressCB = new JComboBox<>(addressComboBoxModel);
        phoneNumberTF = new JTextField(TEXT_FIELD_COLUMNS);
        emailTF = new JTextField(TEXT_FIELD_COLUMNS);


        add(nameLbl);
        add(nameTF);
        add(courseLbl);
        add(courseTF);
        add(phoneNumberLbl);
        add(phoneNumberTF);
        add(emailLbl);
        add(emailTF);
        add(addressLbl);
        add(addressCB);
    }

    /*public ClientEntity getClientFromForm() {
        return new ClientEntity(
                addressComboBoxModel.getSelectedItem(),
                nameTF.getText(),
                surnameTF.getText(),
                peselTF.getText(),
                phoneNumberTF.getText(),
                emailTF.getText()
        );
    }*/

    public Student getStudentFromForm() {
        return new Student(nameTF.getText(), emailTF.getText(), courseTF.getText(), phoneNumberTF.getText());
    }

    public void clearForm() {
        nameTF.setText(Strings.EMPTY);
        courseTF.setText(Strings.EMPTY);
        phoneNumberTF.setText(Strings.EMPTY);
        emailTF.setText(Strings.EMPTY);
        addressCB.setSelectedIndex(0);
    }

}
