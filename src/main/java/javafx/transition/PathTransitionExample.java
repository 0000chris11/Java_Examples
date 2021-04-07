package javafx.transition;

import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathTransitionExample extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("Move me!");
        Button button = new Button("PathTransition");
        Button button2 = new Button("TranslateTransition");
        
        //ALSO TRY TranslateTransition
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(label);
        translateTransition.setDuration(Duration.millis(500));
        //translateTransition.setByX(100);
        translateTransition.setFromX(-30);
        translateTransition.setToX(0);
        translateTransition.setAutoReverse(true);

        Line line = new Line(-100, 0, 0, 0);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(label);
        pathTransition.setDuration(Duration.millis(1000));
        pathTransition.setPath(line);
        //pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);

        button.setOnAction(e -> pathTransition.play());
        button2.setOnAction(e -> translateTransition.play());
        
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(label, button, button2);

        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
