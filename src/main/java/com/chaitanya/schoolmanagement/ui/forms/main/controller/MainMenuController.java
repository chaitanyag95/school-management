package com.chaitanya.schoolmanagement.ui.forms.main.controller;

import com.chaitanya.schoolmanagement.ui.forms.address.controller.AddressController;
import com.chaitanya.schoolmanagement.ui.forms.student.controller.StudentController;
import com.chaitanya.schoolmanagement.ui.forms.main.view.MainMenuFrame;
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class MainMenuController extends AbstractFrameController {

    private final MainMenuFrame mainMenuFrame;
    private final StudentController studentController;
    private final AddressController addressController;


    public void prepareAndOpenFrame() {
        registerAction(mainMenuFrame.getCreateStudentBtn(), (e) -> createStudentWindow());
        registerAction(mainMenuFrame.getAddressesBtn(), (e) -> openAddressWindow());
        mainMenuFrame.setVisible(true);
    }

    private void openAddressWindow() {
        addressController.prepareAndOpenFrame();
    }

    private void createStudentWindow() {
        studentController.prepareAndOpenFrame();
    }


}
