package javafxex.fxml.main;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Location is required.
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("scr/main/java/javafxex/fxml/view/FXMLMain.fxml"));
        primaryStage.setTitle("FXML Test");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
