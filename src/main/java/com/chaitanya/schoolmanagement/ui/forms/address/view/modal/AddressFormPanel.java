package com.chaitanya.schoolmanagement.ui.forms.address.view.modal;


import com.chaitanya.schoolmanagement.model.address.AddressEntity;
import com.chaitanya.schoolmanagement.util.border.Borders;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class AddressFormPanel extends JPanel {

    private static final int LAYOUT_ROWS = 5;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JTextField streetTF;
    private JTextField flatNumberTF;
    private JTextField cityTF;
    private JTextField postalCodeTF;

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
        JLabel streetLbl = new JLabel(ConstMessagesEN.Labels.STREET);
        JLabel flatNumberLbl = new JLabel(ConstMessagesEN.Labels.FLAT_NUMBER);
        JLabel cityLbl = new JLabel(ConstMessagesEN.Labels.CITY);
        JLabel postalCodeLbl = new JLabel(ConstMessagesEN.Labels.POSTAL_CODE);

        streetTF = new JTextField(TEXT_FIELD_COLUMNS);
        flatNumberTF = new JTextField(TEXT_FIELD_COLUMNS);
        cityTF = new JTextField(TEXT_FIELD_COLUMNS);
        postalCodeTF = new JTextField(TEXT_FIELD_COLUMNS);

        add(streetLbl);
        add(streetTF);


        add(flatNumberLbl);
        add(flatNumberTF);
        add(cityLbl);
        add(cityTF);
        add(postalCodeLbl);
        add(postalCodeTF);
    }

    public AddressEntity getEntityFromForm() {
        return new AddressEntity(
                streetTF.getText(),
                flatNumberTF.getText(),
                cityTF.getText(),
                postalCodeTF.getText()
        );
    }

    public void clearForm() {
        streetTF.setText(Strings.EMPTY);
        flatNumberTF.setText(Strings.EMPTY);
        cityTF.setText(Strings.EMPTY);
        postalCodeTF.setText(Strings.EMPTY);
    }

}
