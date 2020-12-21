package com.chaitanya.schoolmanagement.ui.forms.client.controller;


import com.chaitanya.schoolmanagement.model.Student;
import com.chaitanya.schoolmanagement.service.student.StudentService;
import com.chaitanya.schoolmanagement.ui.forms.client.view.modal.AddClientFrame;
import com.chaitanya.schoolmanagement.ui.forms.client.view.modal.FormBtnPanel;
import com.chaitanya.schoolmanagement.ui.forms.client.view.modal.FormPanel;
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
@AllArgsConstructor
public class ClientController extends AbstractFrameController {

    private final AddClientFrame addClientFrame;
    private final StudentService studentService;

    @PostConstruct
    private void prepareListeners() {
        FormBtnPanel formBtnPanel = addClientFrame.getFormBtnPanel();
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
        registerAction(formBtnPanel.getSaveBtn(), (e) -> saveClient());
    }

    @Override
    public void prepareAndOpenFrame() {
        showClientsFrame();
    }

    private void saveClient() {
        FormPanel formPanel = addClientFrame.getFormPanel();
        Student student = formPanel.getStudentFromForm();
        studentService.save(student);
        closeModalWindow();
    }


    private void showClientsFrame() {
        addClientFrame.setVisible(true);
    }

    private void showAddClientModal() {
        addClientFrame.setVisible(true);
    }


    private void closeModalWindow() {
        addClientFrame.getFormPanel().clearForm();
        addClientFrame.dispose();
    }


}
