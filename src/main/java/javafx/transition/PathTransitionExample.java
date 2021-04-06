package javafx.transition;

import javafx.animation.PathTransition;
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
        Button button = new Button("Move Label");
        
        //ALSO TRY TranslateTransition

        Line line = new Line(-100, 0, 0, 0);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(label);
        pathTransition.setDuration(Duration.millis(1000));
        pathTransition.setPath(line);
        //pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);

        button.setOnAction(e -> pathTransition.play());
        
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(label, button);

        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
