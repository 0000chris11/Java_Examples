package javafxex;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FXMain extends Application{
    
    private FXMainData dt = FXMainData.getInstance();

    public static void main(String[] args) {        
        launch(args);      
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        dt.setWindow1(primaryStage);
        dt.getWindow1().setTitle("Scene Change Test");

        dt.getWindow1().setOnCloseRequest(e -> {
            e.consume();
            new FXChoice("Choice Window", "Are you sure you want to close the program");
        });
        
        dt.setLabel1(new Label("Scene 1"));
        dt.setButton1(new Button("To Scene 2"));
        dt.getButton1().setOnAction(e -> dt.getWindow1().setScene(dt.getScene2()));

        dt.setLabel2(new Label("Scene 2"));
        dt.setButton2(new Button("To Scene 1"));
        dt.getButton2().setOnAction(e -> dt.getWindow1().setScene(dt.getScene1()));

        dt.setButton3(new Button("Summon Small Window"));
        dt.getButton3().setOnAction(e -> new FXSmallWindow("Small Window", "Please close me"));

        VBox layout1 = new VBox(8);
        layout1.getChildren().addAll(dt.getLabel1(), dt.getButton1(), dt.getButton3());
        layout1.setAlignment(Pos.CENTER);
        dt.setScene1(new Scene(layout1, 200, 200));

        VBox layout2 = new VBox(8);
        layout2.getChildren().addAll(dt.getLabel2(), dt.getButton2());
        layout2.setAlignment(Pos.CENTER);
        dt.setScene2(new Scene(layout2, 200, 200));

        dt.getWindow1().setScene(dt.getScene1());
        dt.getWindow1().show();
    }

}
