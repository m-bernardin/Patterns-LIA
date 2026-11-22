package ca.mbernardin.controller;

import ca.mbernardin.dao.UserDatabaseAccessObject;
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
    private TextField fullname_ft;
    @FXML
    private TextField email_ft;
    @FXML
    private TextField age_ft;

    private UserService us = new UserService();
    private UserDatabaseAccessObject userdao = new UserDatabaseAccessObject();

    private User currentUser;

    @FXML
    public void initialize() {

        // this is something we need to do:
        // The code doesn't have a way of telling which user is the current user (if i'm not wrong). So I can't display the current user's info for now.

        fullname_ft.setText(userdao.getById(CURRENT_USER_ID).full_name);
        email_ft.setText(userdao.getById(CURRENT_USER_ID).email);
        age_ft.setText(userdao.getById(CURRENT_USER_ID).age);
    }

    @FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        ChangeScenes(actionEvent, "TO_BE_DECIDED", "TO_BE_DECIDED");
    }
    @FXML
    public void saveChangesButton(ActionEvent actionEvent) {
        us.serviceModifyName(fullname_ft.getText());
        us.serviceModifyEmail(email_ft.getText());
        us.serviceModifyAge(age_ft.getText());
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
