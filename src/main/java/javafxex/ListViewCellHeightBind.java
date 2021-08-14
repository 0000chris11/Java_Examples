package javafxex;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener.Change;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewCellHeightBind extends Application {

    private ListView<String> listView;
    private DoubleProperty itemsHeight = new SimpleDoubleProperty();

    private void itemsChanged(Change<? extends String> c){
        while(c.next()){
            double lvHeight = listView.getFixedCellSize() * c.getList().size();
            listView.setMaxHeight(lvHeight);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        listView = new ListView<>();
        listView.setFixedCellSize(24);
        ObservableList<String> itens = listView.getItems();
        
        itens.addListener(this::itemsChanged);
        /*
        listView.setCellFactory(param -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                itemsHeight.setValue(getHeight());
                // System.out.println(getHeight());
                if (empty || item == null) {
                    setText(null);
                } else {
                    /*
                     * Hyperlink link = new Hyperlink(item); setGraphic(link);
                     
                    setText(item);
                }
            }
        });
        */
        listView.getItems().addAll("Talk", "Smack", "Pancackes");
        itemsHeight.addListener((obs, oldValue, newValue) -> {
            if (newValue.doubleValue() > 0.0) {
                System.out.println("itemsHeight changed: " + newValue.doubleValue());
                double lvHeight = newValue.doubleValue() * listView.getItems().size();
                listView.setPrefHeight(lvHeight);
                listView.setMaxHeight(lvHeight);
            }
        });

        Region r = new Region();
        Button btn = new Button("ADD ITEM");
        btn.setOnAction(e -> listView.getItems().add("new Item"));

        VBox vbox = new VBox(listView, r, btn);
        VBox.setVgrow(r, Priority.ALWAYS);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        System.out.println("ListViewCellFactory START");
        launch(args);
    }

}
