package javafxex;

import com.cofii2.components.javafx.TextFieldAutoC;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LayoutResizeTest extends Application{

    private VBox vBox;

    private String[] data = {"Yuugure", "Digimon", "Sunshine", "Little"};

    private GridPane gridPane = new GridPane();
    private Label lb1 = new Label("LABEL 1");
    private Label lb2 = new Label("LABEL 2");
    private TextFieldAutoC tfa1 = new TextFieldAutoC(0, data);
    private TextFieldAutoC tfa2 = new TextFieldAutoC(1, data);
    private Button btn1 = new Button("BTN 1");
    private Button btn2 = new Button("BTN 1");

    private HBox bottom;
    private Button btnInfo = new Button("Info");
    //-----------------------------------------------------------
    private void btnInfoAction(ActionEvent e){
        System.out.println("\nINFO");
        //System.out.println("GridPane 0 min Height: " + gridPane.getRowConstraints().get(0).getMinHeight());
        //System.out.println("GridPane 0 pref Height: " + gridPane.getRowConstraints().get(0).getPrefHeight());
        //System.out.println("GridPane 0 max Height: " + gridPane.getRowConstraints().get(0).getMaxHeight());
        //System.out.println("GridPane 0 vgrow: " + gridPane.getRowConstraints().get(0).getVgrow());
        System.out.println("tfa 0 min height: " + tfa1.getMinHeight());
        System.out.println("tfa 0 pref height: " + tfa1.getPrefHeight());
        System.out.println("tfa 0 max height: " + tfa1.getMaxHeight());
        System.out.println("lv 0 min height: " + tfa1.getLv().getMinHeight());
        System.out.println("lv 0 pref height: " + tfa1.getLv().getPrefHeight());
        System.out.println("lv 0 max height: " + tfa1.getLv().getMaxHeight());
        System.out.println("lv 0 vgrow: " + VBox.getVgrow(tfa1.getLv()));
    }
    //-----------------------------------------------------------
    @Override
    public void start(Stage stage) throws Exception {
        gridPane.add(lb1, 0, 0);
        gridPane.add(lb2, 0, 1);
        gridPane.add(tfa1, 1, 0);
        gridPane.add(tfa2, 1, 1);
        gridPane.add(btn1, 2, 0);
        gridPane.add(btn2, 2, 1);
        
        GridPane.setValignment(lb1, VPos.TOP);
        GridPane.setValignment(lb2, VPos.TOP);
        GridPane.setValignment(tfa1, VPos.TOP);
        GridPane.setValignment(tfa2, VPos.TOP);
        GridPane.setValignment(btn1, VPos.TOP);
        GridPane.setValignment(btn2, VPos.TOP);

        GridPane.setVgrow(tfa1, Priority.ALWAYS);

        btnInfo.setOnAction(this::btnInfoAction);
        bottom = new HBox(btnInfo);

        vBox = new VBox(gridPane, bottom);
        Scene scene = new Scene(vBox, 400, 400);
        stage.setScene(scene);
        stage.show();

    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
