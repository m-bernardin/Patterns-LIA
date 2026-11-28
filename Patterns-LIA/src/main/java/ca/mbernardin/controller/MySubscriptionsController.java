package ca.mbernardin.controller;

import ca.mbernardin.dao.ConferenceDatabaseAccessObject;
import ca.mbernardin.dao.SubscriptionDatabaseAccessObject;
import ca.mbernardin.model.Conference;
import ca.mbernardin.model.Session;
import ca.mbernardin.model.Subscription;
import ca.mbernardin.service.SubscriptionRow;
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
import java.util.Set;

public class MySubscriptionsController {
    @FXML
    private ChoiceBox<Locale> languageField;
    @FXML
    private TableView<SubscriptionRow> subsTable;
    @FXML
    private TableColumn<SubscriptionRow, String> idCol;
    @FXML
    private TableColumn<SubscriptionRow, String> conferencesCol;
    @FXML
    private TableColumn<SubscriptionRow, java.sql.Date> startDateCol;
    @FXML
    private TableColumn<SubscriptionRow, java.sql.Date> endDateCol;
    @FXML
    private TableColumn<SubscriptionRow, String> statusCol;

    private final ObservableList<SubscriptionRow> subscriptions = FXCollections.observableArrayList();

    @FXML
    void initialize() {

        languageField.getItems().addAll(Locale.ENGLISH, Locale.FRENCH);
        languageField.setValue(Session.getLocale());

        idCol.setCellValueFactory(new PropertyValueFactory<>("conferenceId"));
        conferencesCol.setCellValueFactory(new PropertyValueFactory<>("conference"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        subsTable.setItems(subscriptions);
        refreshButton();
    }
    @FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        ChangeScenes(actionEvent, "TO_BE_DECIDED", "TO_BE_DECIDED");
    }
    @FXML
    public void refreshButton() {
        subscriptions.setAll(loadRows());
    }
    @FXML
    public void cancelSubscriptionButton() {
        SubscriptionRow selected = subsTable.getSelectionModel().getSelectedItem();
        if(selected == null) return;
        int userId = Session.getCurrentUserId();
        if(userId < 0) return;

        SubscriptionDatabaseAccessObject.removeFromWaitingList(userId, selected.getConferenceId());
        refreshButton();
    }

    private ObservableList<SubscriptionRow> loadRows() {
        ObservableList<SubscriptionRow> rows = FXCollections.observableArrayList();
        int userId = Session.getCurrentUserId();
        if(userId < 0) return rows;

        Set<Subscription> all = SubscriptionDatabaseAccessObject.getAll();
        if(all == null) return rows;
        for(Subscription subscription : all) {
            if(subscription.getUser_id() != userId) continue;
            Conference conference = ConferenceDatabaseAccessObject.getById(subscription.getConference_id());
            if(conference != null) rows.add(new SubscriptionRow(subscription, conference));
        }
        return rows;
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
