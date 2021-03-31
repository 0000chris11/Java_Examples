package javafxex;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FXMainData {

    //COMPS
    private static FXMainData instance;
    private Stage window1;
    private Scene scene1, scene2;
    private Label label1, label2;
    private Button button1, button2, button3;
    private Button changeLAF = new Button("Change L&F/CSS");
    //STRING PROPERTY EXAMPLE
    private StringProperty name = new SimpleStringProperty(this, "name", null);

    private FXMainData() {

    }

    public static FXMainData getInstance() {
        if(instance == null){
            instance = new FXMainData();
        }
        return instance;
    }

    public Stage getWindow1() {
        return window1;
    }

    public void setWindow1(Stage window1) {
        this.window1 = window1;
    }

    public Scene getScene1() {
        return scene1;
    }

    public void setScene1(Scene scene1) {
        this.scene1 = scene1;
    }

    public Scene getScene2() {
        return scene2;
    }

    public void setScene2(Scene scene2) {
        this.scene2 = scene2;
    }

    public Label getLabel1() {
        return label1;
    }

    public void setLabel1(Label label1) {
        this.label1 = label1;
    }

    public Label getLabel2() {
        return label2;
    }

    public void setLabel2(Label label2) {
        this.label2 = label2;
    }

    public Button getButton1() {
        return button1;
    }

    public void setButton1(Button button1) {
        this.button1 = button1;
    }

    public Button getButton2() {
        return button2;
    }

    public void setButton2(Button button2) {
        this.button2 = button2;
    }

    public Button getButton3() {
        return button3;
    }

    public void setButton3(Button button3) {
        this.button3 = button3;
    }

    public Button getChangeLAF() {
        return changeLAF;
    }

    public void setChangeLAF(Button changeLAF) {
        this.changeLAF = changeLAF;
    }
    //STRING PROPERTY
    public StringProperty name(){
        return name;
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    
}
