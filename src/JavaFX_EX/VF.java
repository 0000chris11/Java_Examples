/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFX_EX;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Christopher
 */
public class VF extends Application {

      Button btn = new Button("BTN 1");
      Button btn2 = new Button("BTN 2");

      public static void main(String[] args) {
            launch(args);
      }

      @Override
      public void start(Stage stage) throws Exception {
            stage.setTitle("JavaFX Example");
            stage.centerOnScreen();

            StackPane layout = new StackPane();
            Group layout2 = new Group();
            ObservableList<Node> nodes = layout2.getChildren();
            
            nodes.add(0, btn);
            nodes.add(1, btn2);
            
            Scene sc = new Scene(layout2, 300, 200);
            
            stage.setScene(sc);
            stage.show();
      }
}
