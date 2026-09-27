package edu.farmingdale.csc311;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label usernameLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    @FXML
    private void initialize() {
        usernameLabel.setLabelFor(usernameField);
        passwordLabel.setLabelFor(passwordField);
        statusLabel.setText("Use any username and password to preview the interface.");
    }

    @FXML
    private void handleLogin() {
        if (usernameField.getText().isBlank() || passwordField.getText().isBlank()) {
            statusLabel.setText("Please enter both a username and password.");
            statusLabel.getStyleClass().setAll("status-label", "status-error");
            return;
        }

        try {
            MainApplication.showView("landing-view.fxml");
        } catch (IOException exception) {
            statusLabel.setText("Unable to open the course manager.");
            statusLabel.getStyleClass().setAll("status-label", "status-error");
            exception.printStackTrace();
        }
    }

    @FXML
    private void handleCancel() {
        usernameField.clear();
        passwordField.clear();
        usernameField.requestFocus();
        statusLabel.setText("Login cleared.");
        statusLabel.getStyleClass().setAll("status-label");
    }
}
