package edu.farmingdale.csc311;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

import java.io.IOException;

public class SplashController {
    @FXML
    private ProgressBar loadingProgress;

    @FXML
    private Label progressLabel;

    private Timeline loadingTimeline;

    @FXML
    private void initialize() {
        loadingProgress.setProgress(0);

        loadingTimeline = new Timeline(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(loadingProgress.progressProperty(), 0)),
                new KeyFrame(Duration.seconds(1.1), event -> progressLabel.setText("Preparing your courses..."),
                        new KeyValue(loadingProgress.progressProperty(), 0.45)),
                new KeyFrame(Duration.seconds(2.1), event -> progressLabel.setText("Almost ready..."),
                        new KeyValue(loadingProgress.progressProperty(), 0.82)),
                new KeyFrame(Duration.seconds(2.8), event -> openLogin(),
                        new KeyValue(loadingProgress.progressProperty(), 1.0))
        );
        loadingTimeline.play();
    }

    private void openLogin() {
        try {
            MainApplication.showView("login-view.fxml");
        } catch (IOException exception) {
            progressLabel.setText("Unable to open the login screen.");
            exception.printStackTrace();
        }
    }
}
