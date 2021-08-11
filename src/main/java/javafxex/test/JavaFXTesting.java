package javafxex.test;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JavaFXTesting extends Application {

    // ---------------------------------------------
    @Override
    public void start(Stage stage) {
        System.out.println("\nSTART");
        System.out.println("PATH TEST: " + JavaFXTesting.class.getResource("/javafxex/test/JavaFXTesting.fxml").toExternalForm());
        try {
            FXMLLoader loader = new FXMLLoader(JavaFXTesting.class.getResource("/javafxex/test/JavaFXTesting.fxml"));

            ZoomingPane zp = new ZoomingPane(loader.load());
            Group gp = new Group(zp);
            JFXTestController jfx = (JFXTestController) loader.getController();
            //BorderPane bpp = new BorderPane(zp);
            ScrollPane scBPP = new ScrollPane(gp);

            zp.setStyle("-fx-border-style: solid solid solid solid;  -fx-border-width: 2;  -fx-border-color: blue; -fx-padding : 6 6 6 6;");
            scBPP.setStyle("-fx-border-style: solid solid solid solid;  -fx-border-width: 2;  -fx-border-color: red; -fx-padding : 6 6 6 6;");

            Scene scene = new Scene(scBPP);

            zp.zoomFactorProperty().bind(jfx.getScale());

            jfx.setZp(zp);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // scene.getStylesheets().add(JavaFXTesting.class.getResource("/com/cofii/ts/first/VF.css").toExternalForm());

    }

    public static void main(String[] args) {
        launch(args);
    }
}
