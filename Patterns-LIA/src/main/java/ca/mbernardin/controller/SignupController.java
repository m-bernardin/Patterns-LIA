package ca.mbernardin.controller;

import ca.mbernardin.dao.UserDatabaseAccessObject;
import ca.mbernardin.service.AccountValidator;
import ca.mbernardin.service.exceptions.InvalidFormatException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * SignupController
 */
public class SignupController {
    @FXML private Button langSwitchBttn;
    @FXML private Label titleLbl;
    @FXML private Label nameLbl;
    @FXML private TextField nameField;
    @FXML private Label emailLbl;
    @FXML private TextField emailField;
    @FXML private Label ageLbl;
    @FXML private TextField ageField;
    @FXML private Label psswdLbl;
    @FXML private TextField psswdField;
    @FXML private Button backBttn;
    @FXML private Button validateBttn;

    @FXML
    public void initialize(){
        populateText();
    }

    @FXML
    public void switchLang(){}

    @FXML
    public void back(){}

    @FXML
    public void validate(){
        try{
            if(AccountValidator.validateNewAccount(nameField.getText(),emailField.getText(),ageField.getText(),psswdField.getText()))UserDatabaseAccessObject.create(nameField.getText(),emailField.getText(),Integer.parseInt(ageField.getText()),Hasher.hash(psswdField.getText()));
        }
        catch(InvalidFormatException e){
            // TODO code to show error box
        }
    }

    private void populateText(){}

}
