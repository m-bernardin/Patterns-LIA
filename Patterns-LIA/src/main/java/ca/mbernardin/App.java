package ca.mbernardin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static void main( String[] args ) throws IOException {
        System.out.println("Hello world!");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //setUpDatabase();
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/ca/mbernardin/View/MyProfile.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Conference Management System");
        stage.setScene(scene);
        stage.show();
    }
}
