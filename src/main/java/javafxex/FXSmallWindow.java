package javafxex;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXSmallWindow {
    
    private Stage window = new Stage();
    private Scene scene;
    private Label label;
    private Button button = new Button("Close Window");

    public FXSmallWindow(String title, String message){
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);

        label = new Label(message);
        button.setOnAction(e -> window.close());

        VBox layout = new VBox(8);
        layout.getChildren().addAll(label, button);
        layout.setAlignment(Pos.CENTER);

        scene = new Scene(layout, 200, 100);
        window.setScene(scene);
        window.showAndWait();
    }

}
