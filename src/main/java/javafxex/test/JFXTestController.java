package javafxex.test;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.cofii2.components.javafx.popup.PopupAutoC;

import org.controlsfx.control.ToggleSwitch;
import org.controlsfx.control.spreadsheet.Grid;
import org.controlsfx.control.spreadsheet.GridBase;
import org.controlsfx.control.spreadsheet.SpreadsheetCell;
import org.controlsfx.control.spreadsheet.SpreadsheetCellType;
import org.controlsfx.control.spreadsheet.SpreadsheetView;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import impl.org.controlsfx.*;

//import impl.org.controlsfx.spreadsheet.;

public class JFXTestController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private HBox hbox;

    @FXML
    private Label lbTest;
    @FXML
    private Button btnTest;
    @FXML
    private TextField tfTest;

    private final String[] items = new String[] { "Launch", "Java", "View", "Git", "LP", "Void" };
    private final ListView<String> lv = new ListView<>();
    private final TextField tf = new TextField();
    private final PopupAutoC tfPopup = new PopupAutoC(tf);

    private final ToggleButton btnSwitch = new ToggleButton("Popup");

    private SpreadsheetView ssheetView;

    //private DoubleProperty scale = new DoubleProperty(1.0);
    private ZoomingPane zp;
    private final SimpleDoubleProperty scale = new SimpleDoubleProperty(1.0);
        // -----------------------------------
    private void btnSwitchAction(ActionEvent e) {
        if (!btnSwitch.isSelected()) {
            btnSwitch.setText("Popup");
            tfPopup.setTfParent(tf);
        } else {
            btnSwitch.setText("LV");
            tfPopup.setTfParent(null);

        }
    }

    private void btnTestAction(ActionEvent e){
        double newValue = scale.getValue().doubleValue();
        newValue += 0.05;
        scale.setValue(newValue);

        System.out.println("###### Info #### (" + newValue + ")");
        System.out.println("bp Size: " + borderPane.getWidth() + " - " + borderPane.getHeight());
        System.out.println("zp Size: " + zp.getWidth() + " - " + zp.getHeight());

    }

    private int count = 1;
    private void lvPopupSelectedItemProperty(String oldValue, String newValue) {
        System.out.println("\n############## " + count++);
        System.out.println("oldValue: " + oldValue);
        System.out.println("newValue: " + newValue);
    }

    // -----------------------------------
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TEST 1--------------------------------------
        tfPopup.addAllItems(items);
        tf.setAlignment(Pos.TOP_CENTER);
        tfPopup.getLv().getSelectionModel().selectedItemProperty()
                .addListener((obs, oldValue, newValue) -> lvPopupSelectedItemProperty(oldValue, newValue));

        lv.getItems().addAll(items);

        btnTest.setOnAction(this::btnTestAction);
        btnSwitch.setOnAction(this::btnSwitchAction);
        // ------------------------------------
        hbox.scaleXProperty().bind(scale);
        hbox.scaleYProperty().bind(scale);
        // TEST 2 ------------------------------------------------
        //WAY 1---------------------------
        /*
        int rowCount = 0;     
        int columnCount = 0; 
        GridBase grid = new GridBase(rowCount, columnCount);
        
        ObservableList<ObservableList<SpreadsheetCell>> rows = FXCollections.observableArrayList();     
        for (int row = 0; row < grid.getRowCount(); ++row) {  
            final ObservableList<SpreadsheetCell> cellList = FXCollections.observableArrayList();         
            for (int column = 0; column < grid.getColumnCount(); ++column) {          
                cellList.add(SpreadsheetCellType.STRING.createCell(row, column, 1, 1,"value"));         
            }
            rows.add(cellList);     
        }
        grid.setRows(rows);
        ssheetView = new SpreadsheetView(grid);
        */
        //----------------------------------------
        ToggleSwitch toggleSwitch = new ToggleSwitch("SWITCH");
        AutoCompletionBinding<String> autoCompletionBinding = TextFields.bindAutoCompletion(tfTest, "What", "Ok", "Fine", "Fullmetal", "Winter", "Once");
        autoCompletionBinding.setDelay(0);
        autoCompletionBinding.setOnAutoCompleted(v -> tfTest.setText(v.getCompletion() + "--------------"));
        // ------------------------------------
        hbox.setSpacing(2.0);

        //hbox.getChildren().addAll(lv, tf);
        borderPane.setCenter(new HBox(toggleSwitch, tfTest));
        borderPane.setBottom(btnSwitch);

    }
    // -----------------------------------

    public SimpleDoubleProperty getScale() {
        return scale;
    }

    public ZoomingPane getZp() {
        return zp;
    }

    public void setZp(ZoomingPane zp) {
        this.zp = zp;
    }

}
