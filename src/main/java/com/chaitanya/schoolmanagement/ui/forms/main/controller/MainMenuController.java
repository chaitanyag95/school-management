package com.chaitanya.schoolmanagement.ui.forms.main.controller;

import com.chaitanya.schoolmanagement.ui.forms.client.controller.ClientController;
import com.chaitanya.schoolmanagement.ui.forms.main.view.MainMenuFrame;
/*import com.danielmichalski.reservations.business.ui.forms.forms.controller.FormsController;

import com.danielmichalski.reservations.business.ui.reports.reports.controller.ReportsController;
import com.danielmichalski.reservations.business.ui.shared.controller.AbstractFrameController;*/
import com.chaitanya.schoolmanagement.ui.shared.controller.AbstractFrameController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.event.ActionListener;

@Controller
@AllArgsConstructor
public class MainMenuController extends AbstractFrameController {

    private final MainMenuFrame mainMenuFrame;
    private final ClientController clientController;
   /* private final ReportsController reportsController;*/

    public void prepareAndOpenFrame() {
        registerAction(mainMenuFrame.getCreateStudentBtn(), (e) -> createStudentWindow());
        /*registerAction(mainMenuFrame.getReportsBtn(), (e) -> openReportsWindow());*/
        mainMenuFrame.setVisible(true);
    }

    private void createStudentWindow() {
        clientController.prepareAndOpenFrame();
    }

    /*private void openReportsWindow() {
        reportsController.prepareAndOpenFrame();
    }*/

}
