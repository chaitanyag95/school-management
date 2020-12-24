package com.chaitanya.schoolmanagement.ui.forms.login.student.controller;


import com.chaitanya.schoolmanagement.model.student.Student;
import com.chaitanya.schoolmanagement.payload.LoginDto;
import com.chaitanya.schoolmanagement.service.login.LoginService;
import com.chaitanya.schoolmanagement.service.student.StudentService;
import com.chaitanya.schoolmanagement.ui.forms.login.student.view.StudentLoginFormBtnPanel;
import com.chaitanya.schoolmanagement.ui.forms.login.student.view.StudentLoginFormPanel;
import com.chaitanya.schoolmanagement.ui.forms.login.student.view.StudentLoginFrame;
import com.chaitanya.schoolmanagement.ui.forms.student.welcome.controller.WelcomeStudentController;
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import com.chaitanya.schoolmanagement.util.notification.Notifications;
import com.chaitanya.schoolmanagement.validation.ValidationError;
import com.chaitanya.schoolmanagement.validation.login.LoginValidator;
import com.chaitanya.schoolmanagement.validation.login.StudentLoginValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class StudentLoginController extends AbstractFrameController {

    private final StudentLoginFrame studentLoginFrame;
    private final LoginService loginService;
    private final StudentLoginValidator loginValidator;
    private final WelcomeStudentController welcomeStudentController;
    @Autowired
    private StudentService studentService;

    @PostConstruct
    private void prepareListeners() {
        StudentLoginFormBtnPanel formBtnPanel = studentLoginFrame.getStudentLoginFormBtnPanel();
        registerAction(formBtnPanel.getLoginBtn(), (e) -> login());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
    }

    @Override
    public void prepareAndOpenFrame() {
        showClientsFrame();
    }

    private void showClientsFrame() {
        studentLoginFrame.setVisible(true);
    }


    private void login() {
        StudentLoginFormPanel formPanel = studentLoginFrame.getStudentLoginFormPanel();
        LoginDto studentLoginDto = formPanel.getStudentFromForm();
        Optional<ValidationError> errors = loginValidator.validate(studentLoginDto);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            if (loginService.verifyStudentCredentials(studentLoginDto)) {
                Student student = studentService.getStudentByEmail(studentLoginDto.getEmail());
                welcomeStudentController.prepareAndOpenFrame(student);
                closeModalWindow();
            }
        }
    }

    private void closeModalWindow() {
        studentLoginFrame.getStudentLoginFormPanel().clearForm();
        studentLoginFrame.dispose();
    }

}
