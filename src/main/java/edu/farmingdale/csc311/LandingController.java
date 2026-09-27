package edu.farmingdale.csc311;

import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class LandingController {
    @FXML
    private TableView<CourseRow> coursesTable;

    @FXML
    private TableColumn<CourseRow, String> courseCodeColumn;

    @FXML
    private TableColumn<CourseRow, String> courseNameColumn;

    @FXML
    private TableColumn<CourseRow, String> meetingColumn;

    @FXML
    private TableView<AssignmentRow> assignmentsTable;

    @FXML
    private TableColumn<AssignmentRow, String> assignmentColumn;

    @FXML
    private TableColumn<AssignmentRow, String> assignmentCourseColumn;

    @FXML
    private TableColumn<AssignmentRow, String> dueColumn;

    @FXML
    private void initialize() {
        coursesTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        assignmentsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);

        courseCodeColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().code()));
        courseNameColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().name()));
        meetingColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().meeting()));

        assignmentColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().title()));
        assignmentCourseColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().course()));
        dueColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().dueDate()));

        coursesTable.setItems(FXCollections.observableArrayList(
                new CourseRow("CSC 311", "Advanced Programming", "Mon / Wed 10:00 AM"),
                new CourseRow("CSC 329", "Data Structures II", "Tue / Thu 1:00 PM"),
                new CourseRow("CSC 325", "Database Systems", "Mon / Wed 2:30 PM"),
                new CourseRow("SOC 122", "Introduction to Sociology", "Friday 9:00 AM")
        ));

        assignmentsTable.setItems(FXCollections.observableArrayList(
                new AssignmentRow("JavaFX UI Lab", "CSC 311", "Oct 2"),
                new AssignmentRow("Binary Tree Review", "CSC 329", "Oct 4"),
                new AssignmentRow("Schema Diagram", "CSC 325", "Oct 7"),
                new AssignmentRow("Discussion Post", "SOC 122", "Oct 9")
        ));
    }

    @FXML
    private void handleSignOut() {
        try {
            MainApplication.showView("login-view.fxml");
        } catch (IOException exception) {
            showError("Unable to return to the login screen.");
            exception.printStackTrace();
        }
    }

    @FXML
    private void handleExit() {
        Platform.exit();
    }

    @FXML
    private void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(MainApplication.getPrimaryStage());
        alert.setTitle("About Student Course Manager");
        alert.setHeaderText("Student Course Manager");
        alert.setContentText("A CSC 311 JavaFX interface project built with FXML, controllers, and CSS.");
        alert.showAndWait();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(MainApplication.getPrimaryStage());
        alert.setTitle("Navigation Error");
        alert.setHeaderText("Something went wrong");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public record CourseRow(String code, String name, String meeting) {
    }

    public record AssignmentRow(String title, String course, String dueDate) {
    }
}
