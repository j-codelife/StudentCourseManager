package edu.farmingdale.csc311;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainApplication extends Application {
    private static final double APP_WIDTH = 1100;
    private static final double APP_HEIGHT = 720;
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        primaryStage.setTitle("Student Course Manager");
        primaryStage.setMinWidth(900);
        primaryStage.setMinHeight(620);
        showView("splash-view.fxml");
        primaryStage.show();
    }

    public static void showView(String fxmlFile) throws IOException {
        URL viewUrl = MainApplication.class.getResource(fxmlFile);
        if (viewUrl == null) {
            throw new IOException("FXML resource not found: " + fxmlFile);
        }

        Parent root = FXMLLoader.load(viewUrl);
        Scene scene = primaryStage.getScene();
        if (scene == null) {
            scene = new Scene(root, APP_WIDTH, APP_HEIGHT);
            primaryStage.setScene(scene);
        } else {
            scene.setRoot(root);
        }

        primaryStage.centerOnScreen();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
