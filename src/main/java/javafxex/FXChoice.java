package javafxex;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXChoice {

    private Stage window = new Stage();
    private Scene scene;
    private Label label;
    private Button button1 = new Button("No");
    private Button button2 = new Button("Yes");

    public FXChoice(String title, String message) {
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);

        label = new Label(message);
        button1.setOnAction(e -> window.close());
        button2.setOnAction(e -> {
            window.close();
            FXMainData.getInstance().getWindow1().close();
        });

        VBox layout = new VBox(8);
        layout.getChildren().addAll(label, button1, button2);
        layout.setAlignment(Pos.CENTER);

        scene = new Scene(layout, 200, 100);
        window.setScene(scene);
        window.showAndWait();
    }

}
