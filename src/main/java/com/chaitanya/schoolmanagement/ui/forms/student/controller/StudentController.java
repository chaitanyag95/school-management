package com.chaitanya.schoolmanagement.ui.forms.student.controller;

import com.chaitanya.schoolmanagement.model.address.AddressEntity;
import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.service.address.AddressService;
import com.chaitanya.schoolmanagement.service.student.StudentService;
import com.chaitanya.schoolmanagement.ui.forms.student.model.AddressComboBoxModel;
import com.chaitanya.schoolmanagement.ui.forms.student.model.StudentTableModel;
import com.chaitanya.schoolmanagement.ui.forms.student.view.StudentFrame;
import com.chaitanya.schoolmanagement.ui.forms.student.view.TableBtnPanel;
import com.chaitanya.schoolmanagement.ui.forms.student.view.modal.*;
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;
import com.chaitanya.schoolmanagement.util.notification.Notifications;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.client.ClientValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class StudentController extends AbstractFrameController {

    private final StudentFrame studentFrame;
    private final AddStudentFrame addStudentFrame;
    private final StudentTableModel studentTableModel;
    private final StudentService studentService;
    private final ClientValidator clientValidator;
    private final AddressService addressService;
    private final AddressComboBoxModel addressComboBoxModel;
    //private final UpdateStudentFrame updateStudentFrame;


    @PostConstruct
    private void prepareListeners() {
        TableBtnPanel tableBtnPanel = studentFrame.getTableBtnPanel();
        FormBtnPanel formBtnPanel = addStudentFrame.getFormBtnPanel();

        registerAction(tableBtnPanel.getAddBtn(), (e) -> showAddClientModal());
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeClient());
        registerAction(formBtnPanel.getSaveBtn(), (e) -> saveClient());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
        //registerAction(tableBtnPanel.getRemoveBtn(), (e) -> updateStudent());
    }

    @Override
    public void prepareAndOpenFrame() {
        loadClients();
        showClientsFrame();
        loadAddresses();
    }

    private void loadClients() {
        List<Student> students = studentService.findAll();
        studentTableModel.clear();
        studentTableModel.addEntities(students);
    }

    private void loadAddresses() {
        List<AddressEntity> addresses = addressService.findAll();
        addressComboBoxModel.clear();
        addressComboBoxModel.addElements(addresses);
    }


    private void showClientsFrame() {
        studentFrame.setVisible(true);
    }

    private void showAddClientModal() {
        addStudentFrame.setVisible(true);
    }


    private void saveClient() {
        FormPanel formPanel = addStudentFrame.getFormPanel();
        Student student = formPanel.getStudentFromForm();
        Optional<ValidationError> errors = clientValidator.validate(student);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            studentService.save(student);
            studentTableModel.addEntity(student);
            closeModalWindow();
        }
    }

    private void closeModalWindow() {
        addStudentFrame.getFormPanel().clearForm();
        addStudentFrame.dispose();
    }

    private void removeClient() {
        try {
            JTable studentTable = studentFrame.getStudentTablePanel().getStudentTable();
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Student student = studentTableModel.getEntityByRow(selectedRow);
                studentService.remove(student);
                studentTableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

    /*private void updateStudent() {
        try {
            JTable studentTable = studentFrame.getStudentTablePanel().getStudentTable();
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        ConstMessagesEN.Messages.NON_ROW_SELECTED,
                        ConstMessagesEN.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Student student = studentTableModel.getEntityByRow(selectedRow);
                showUpdateStudentForm(student);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }*/

}
