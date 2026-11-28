package ca.mbernardin.controller;

import ca.mbernardin.dao.UserDatabaseAccessObject;
import ca.mbernardin.model.Session;
import ca.mbernardin.model.User;
import ca.mbernardin.service.UserService;
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
    private TextField fullname_tf;
    @FXML
    private TextField email_tf;
    @FXML
    private TextField age_tf;

    //private final UserService us = new UserService();
    //private final UserDatabaseAccessObject userdao = new UserDatabaseAccessObject();

    private User currentUser;

    @FXML
    public void initialize() {

        User u = UserDatabaseAccessObject.getById(Session.getCurrentUserId());
        if(u==null) {
            return;
        }
        fullname_tf.setText(u.getFullName());
        email_tf.setText(u.getEmail());
        age_tf.setText(u.getAge() + "");
    }

    @FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        ChangeScenes(actionEvent, "DESTINATION_TOBEDECIDED", "TITLE_TOBEDECIDED");
    }
    @FXML
    public void saveChangesButton(ActionEvent actionEvent) {
        UserService.serviceModifyName(fullname_tf.getText());
        UserService.serviceModifyEmail(email_tf.getText());
        UserService.serviceModifyAge(age_tf.getText());
        initialize();
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
