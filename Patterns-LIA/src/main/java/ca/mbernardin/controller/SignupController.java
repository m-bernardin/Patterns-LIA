package ca.mbernardin.controller;

import ca.mbernardin.dao.UserDatabaseAccessObject;
import ca.mbernardin.i18n.I18n;
import ca.mbernardin.model.Session;
import ca.mbernardin.service.AccountValidator;
import ca.mbernardin.service.HashingService;
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
    public void switchLang(){
        Session.toggleLocale();
        populateText();
    }

    // TODO implement this once this system is figured out
    @FXML
    public void back(){}

    @FXML
    public void validate(){
        try{
            if(AccountValidator.validateNewAccount(nameField.getText(),emailField.getText(),ageField.getText(),psswdField.getText()))UserDatabaseAccessObject.create(nameField.getText(),emailField.getText(),Integer.parseInt(ageField.getText()),HashingService.hash(psswdField.getText()));
        }
        catch(InvalidFormatException e){
            // TODO code to show error box
        }
    }

    private void populateText(){
        titleLbl.setText(I18n.translate("signup.titleLbl"));
        nameLbl.setText(I18n.translate("signup.nameLbl"));
        emailLbl.setText(I18n.translate("signup.emailLbl"));
        ageLbl.setText(I18n.translate("signup.ageLbl"));
        psswdLbl.setText(I18n.translate("signup.psswdLbl"));
        backBttn.setText(I18n.translate("signup.backBttn"));
        validateBttn.setText(I18n.translate("signup.validateBttn"));
    }

}
