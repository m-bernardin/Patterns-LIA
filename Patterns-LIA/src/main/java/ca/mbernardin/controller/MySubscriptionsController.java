package ca.mbernardin.controller;

import ca.mbernardin.model.Session;
import ca.mbernardin.model.Subscription;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Locale;

public class MySubscriptionsController {
    @FXML
    private ChoiceBox<Locale> languageField;
    @FXML
    private TableView<Subscription> subsTable;
    @FXML
    private TableColumn<Subscription, String> idCol;
    @FXML
    private TableColumn<Subscription, String> conferencesCol;
    @FXML
    private TableColumn<Subscription, LocalDateTime> startDateCol;
    @FXML
    private TableColumn<Subscription, LocalDateTime> endDateCol;
    @FXML
    private TableColumn<Subscription, String> statusCol;
    @FXML
    private final ObservableList<Subscription> subscriptions = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        languageField.getItems().addAll(Locale.ENGLISH, Locale.FRENCH);
        languageField.setValue(Session.getLocale());

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        conferencesCol.setCellValueFactory(new PropertyValueFactory<>("conference"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        subsTable.setItems(subscriptions);
    }
    @FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        ChangeScenes(actionEvent, "TO_BE_DECIDED", "TO_BE_DECIDED");
    }
    @FXML
    public void refreshButton() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        conferencesCol.setCellValueFactory(new PropertyValueFactory<>("conference"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        subsTable.setItems(subscriptions);
    }
    @FXML
    public void cancelSubscriptionButton() {

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
