package edu.farmingdale.csc311;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Lightweight runtime check for all FXML and CSS resources. This is launched
 * manually during development and does not require a testing framework.
 */
public class FxmlSmokeTestApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        String[] views = {"login-view.fxml", "landing-view.fxml", "splash-view.fxml"};

        for (String view : views) {
            URL resource = MainApplication.class.getResource(view);
            if (resource == null) {
                throw new IllegalStateException("Missing resource: " + view);
            }

            Parent root = FXMLLoader.load(resource);
            Scene scene = new Scene(root, 1100, 720);
            root.applyCss();
            root.layout();
            System.out.println("Loaded " + view + " (" + scene.getRoot().getClass().getSimpleName() + ")");
        }

        System.out.println("FXML smoke test passed.");
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
