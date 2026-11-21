package ca.mbernardin.controller;

import ca.mbernardin.dao.UserDatabaseAccessObject;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;

public class MyProfileController {
    @FXML
    private TextField fullname_ft;
    @FXML
    private TextField email_ft;
    @FXML
    private TextField age_ft;

    private UserDatabaseAccessObject userDAO = new UserDatabaseAccessObject();

    @FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        ChangeScenes(actionEvent, "TO_BE_DECIDED", "TO_BE_DECIDED");
    }
    @FXML
    public void saveChangesButton(ActionEvent actionEvent) {
        
    }
    @FXML
    public void ChangeScenes(ActionEvent event, String fxml, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
