package com.chaitanya.schoolmanagement.util.notification;


import com.chaitanya.schoolmanagement.util.constant.ConstMessagesEN;

import javax.swing.*;

public class Notifications {

    public static void showFormValidationAlert(String message) {
        JOptionPane.showMessageDialog(null,
                message,
                ConstMessagesEN.Messages.INFORMATION_TITLE,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showDeleteRowErrorMessage() {
        JOptionPane.showMessageDialog(null,
                ConstMessagesEN.Messages.DELETE_ROW_ERROR,
                ConstMessagesEN.Messages.ALERT_TILE,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showDeletedSuccessfulMessage() {
        JOptionPane.showMessageDialog(null,
                ConstMessagesEN.Messages.DELETED_QUESTION_PAPER,
                ConstMessagesEN.Messages.ALERT_TILE,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void show() {
        JOptionPane.showMessageDialog(null,
                ConstMessagesEN.Messages.DELETED_QUESTION_PAPER,
                ConstMessagesEN.Messages.ALERT_TILE,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showNotAppearedErrorMessage() {
        JOptionPane.showMessageDialog(null,
                ConstMessagesEN.Messages.NOT_APPEARED,
                ConstMessagesEN.Messages.ALERT_TILE,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showAppearedErrorMessage() {
        JOptionPane.showMessageDialog(null,
                ConstMessagesEN.Messages.APPEARED,
                ConstMessagesEN.Messages.ALERT_TILE,
                JOptionPane.ERROR_MESSAGE);
    }
}
