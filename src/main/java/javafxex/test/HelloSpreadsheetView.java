package javafxex.test;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.controlsfx.ControlsFXSample;
import org.controlsfx.control.spreadsheet.GridBase;
import org.controlsfx.control.spreadsheet.SpreadsheetCell;
import org.controlsfx.control.spreadsheet.SpreadsheetCellBase;
import org.controlsfx.control.spreadsheet.SpreadsheetCellType;
import org.controlsfx.control.spreadsheet.SpreadsheetView;
//import org.controlsfx.dialog.Dialogs;
import org.controlsfx.samples.HelloDecorator;
import org.controlsfx.samples.Utils;

public class HelloSpreadsheetView extends ControlsFXSample {

    public static void main(String[] args) {
        launch(args);
    }

    private SpreadsheetView spreadSheetView;
    private StackPane centerPane;
    private final CheckBox rowHeader = new CheckBox();
    private final CheckBox columnHeader = new CheckBox();
    private final CheckBox editable = new CheckBox();

    /**
     * List for custom cells
     */
    private final List<String> companiesList = Arrays.asList("", "ControlsFX", "Aperture Science",
            "Rapture", "Ammu-Nation", "Nuka-Cola", "Pay'N'Spray", "Umbrella Corporation");

    private final List<String> countryList = Arrays.asList("China", "France", "New Zealand",
            "United States", "Germany", "Canada");

    private final List<String> logoList = Arrays.asList("", "ControlsFX.png", "apertureLogo.png",
            "raptureLogo.png", "ammunationLogo.JPG", "nukaColaLogo.png", "paynsprayLogo.jpg", "umbrellacorporation.png");

    private final List<String> webSiteList = Arrays.asList("", "http://fxexperience.com/controlsfx/",
            "http://aperturescience.com/", "", "http://fr.gta.wikia.com/wiki/Ammu-Nation",
            "http://e-shop.nuka-cola.eu/", "http://fr.gta.wikia.com/wiki/Pay_%27n%27_Spray",
            "http://www.umbrellacorporation.net/");

    @Override
    public String getSampleName() {
        return "SpreadsheetView";
    }

    @Override
    public String getSampleDescription() {
        return "The SpreadsheetView is a control similar to the JavaFX TableView control "
                + "but with different functionalities and use cases. The aim is to have a "
                + "powerful grid where data can be written and retrieved.\n\n"
                + "Here you have an example where some information about fictive "
                + "companies are displayed. They have different type and format.\n\n"
                + "After that, some random generated cells are displayed with some span.\n\n"
                + "Don't forget to right-click on headers and cells to discover some features.";
    }

    @Override
    public Node getPanel(Stage stage) {
        centerPane = new StackPane();

        int rowCount = 31; //Will be re-calculated after if incorrect.
        int columnCount = 8;

        GridBase grid = new GridBase(rowCount, columnCount);
        grid.setRowHeightCallback(new GridBase.MapBasedRowHeightFactory(generateRowHeight()));
        buildGrid(grid);

        spreadSheetView = new SpreadsheetView(grid);
        spreadSheetView.setShowRowHeader(rowHeader.isSelected());
        spreadSheetView.setShowColumnHeader(columnHeader.isSelected());
        spreadSheetView.setEditable(editable.isSelected());

        generatePickers();

        spreadSheetView.getFixedRows().add(0);
        spreadSheetView.getColumns().get(0).setFixed(true);
        spreadSheetView.getColumns().get(1).setPrefWidth(250);
        centerPane.getChildren().setAll(spreadSheetView);

        spreadSheetView.getStylesheets().add(HelloDecorator.class.getResource("spreadsheetSample.css").toExternalForm());
        return centerPane;
    }

    @Override
    public Node getControlPanel() {
        return buildCommonControlGrid();
    }

    @Override
    public String getJavaDocURL() {
        return Utils.JAVADOC_BASE + "org/controlsfx/control/spreadsheet/SpreadsheetView.html";
    }

    /**
     * Add some pickers into the SpreadsheetView in order to give some
     * information.
     */
    private void generatePickers() {
        //spreadSheetView.getRowPickers().addAll(0, 1, 2, 3, 4, 5, 6);
        /*
        spreadSheetView.setRowPickerCallback(new Callback<Integer, Void>() {

            @Override
            public Void call(Integer p) {
                String message;
                switch (p) {
                    case 0:
                        message = "This row contains several fictive companies. "
                                + "The cells are not editable.\n"
                                + "A custom tooltip is applied for the first cell.";
                        break;
                    case 1:
                        message = "This row contains cells that can only show a list.";
                        break;
                    case 2:
                        message = "This row contains cells that display some dates.";
                        break;
                    case 3:
                        message = "This row contains some Images displaying logos of the companies.";
                        break;
                    case 4:
                        message = "This row contains Double editable cells. "
                                + "Except for ControlsFX compagny where it's a String.";
                        break;
                    case 5:
                        message = "This row contains Double editable cells with "
                                + "a special format (%). Some cells also have "
                                + "a little icon next to their value.";
                        break;

                    case 6:
                        message = "This row contains Integer editable cells.";
                        break;
                    default:
                        message = "You clicked on row " + (p + 1);
                }

                Dialogs.create()
                        .title("You clicked on row " + (p + 1))
                        .message(message)
                        .showInformation();
                return null;
            }
        });
        */
        /*
        spreadSheetView.getColumnPickers().addAll(0);
        spreadSheetView.setColumnPickerCallback(new Callback<Integer, Void>() {

            @Override
            public Void call(Integer p) {
                String message;
                switch (p) {
                    case 0:
                        message = "Each cell of this column (except for the "
                                + "separator in the middle) has a particular css "
                                + "class for changing its color.\n";
                        break;
                    default:
                        message = "You clicked on column " + (p + 1);
                }

                Dialogs.create()
                        .title("You clicked on column " + (p + 1))
                        .message(message)
                        .showInformation();
                return null;
            }
        });
        */
    }

    /**
     * Specify a custom row height.
     *
     * @return
     */
    private Map<Integer, Double> generateRowHeight() {
        Map<Integer, Double> rowHeight = new HashMap<>();
        rowHeight.put(3, 100.0);
        return rowHeight;
    }

    /**
     * Randomly generate a {@link SpreadsheetCell}.
     */
    private SpreadsheetCell generateCell(int row, int column, int rowSpan, int colSpan) {
        SpreadsheetCell cell;
        List<String> cityList = Arrays.asList("Shanghai", "Paris", "New York City", "Bangkok",
                "Singapore", "Johannesburg", "Berlin", "Wellington", "London", "Montreal");
        final double random = Math.random();
        if (random < 0.25) {
            cell = SpreadsheetCellType.LIST(countryList).createCell(row, column, rowSpan, colSpan,
                    countryList.get((int) (Math.random() * 6)));
        } else if (random >= 0.25 && random < 0.5) {
            cell = SpreadsheetCellType.STRING.createCell(row, column, rowSpan, colSpan,
                    cityList.get((int) (Math.random() * 10)));
        } else if (random >= 0.5 && random < 0.75) {
            cell = generateNumberCell(row, column, rowSpan, colSpan);
        } else {
            cell = generateDateCell(row, column, rowSpan, colSpan);
        }

        // Styling for preview
        if (row % 5 == 0) {
            cell.getStyleClass().add("five_rows");
        }
        return cell;
    }

    /**
     * Generate a Date Cell with a random format.
     *
     * @param row
     * @param column
     * @param rowSpan
     * @param colSpan
     * @return
     */
    private SpreadsheetCell generateDateCell(int row, int column, int rowSpan, int colSpan) {
        SpreadsheetCell cell = SpreadsheetCellType.DATE.createCell(row, column, rowSpan, colSpan, LocalDate.now()
                .plusDays((int) (Math.random() * 10)));
        final double random = Math.random();
        if (random < 0.25) {
            cell.setFormat("EEEE d");
        } else if (random < 0.5) {
            cell.setFormat("dd/MM :YY");
        } else {
            cell.setFormat("dd/MM/YYYY");
        }
        return cell;
    }

    /**
     * Generate a Number Cell with a random format.
     *
     * @param row
     * @param column
     * @param rowSpan
     * @param colSpan
     * @return
     */
    private SpreadsheetCell generateNumberCell(int row, int column, int rowSpan, int colSpan) {
        final double random = Math.random();
        SpreadsheetCell cell;
        if (random < 0.3) {
            cell = SpreadsheetCellType.INTEGER.createCell(row, column, rowSpan, colSpan,
                    Math.round((float) Math.random() * 100));
        } else {
            cell = SpreadsheetCellType.DOUBLE.createCell(row, column, rowSpan, colSpan,
                    (double) Math.round((Math.random() * 100) * 100) / 100);
            final double randomFormat = Math.random();
            if (randomFormat < 0.25) {
                cell.setFormat("#,##0.00" + "\u20AC");
            } else if (randomFormat < 0.5) {
                cell.setFormat("0.###E0 km/h");
            } else {
                cell.setFormat("0.###E0");
            }
        }
        return cell;
    }

    /**
     * Generate a Double Cell
     *
     * @param row
     * @param column
     * @param rowSpan
     * @param colSpan
     * @return
     */
    private SpreadsheetCell generateDoubleCell(int row, int column, int rowSpan, int colSpan) {
        final double random = Math.random();
        SpreadsheetCell cell;
        cell = SpreadsheetCellType.DOUBLE.createCell(row, column, rowSpan, colSpan,
                (double) Math.round((random * 100) * 100) / 100);
        return cell;
    }

    /**
     * Return a List of SpreadsheetCell displaying the companies.
     *
     * @param grid
     * @param row
     * @return
     */
    private ObservableList<SpreadsheetCell> getCompanies(GridBase grid, int row) {

        final ObservableList<SpreadsheetCell> companies = FXCollections.observableArrayList();

        SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(row, 0, 1, 1, "Company : ");
        ((SpreadsheetCellBase) cell).setTooltip("This cell displays a custom toolTip.");
        cell.setEditable(false);
        companies.add(cell);

        for (int column = 1; column < grid.getColumnCount(); ++column) {
            cell = SpreadsheetCellType.STRING.createCell(row, column, 1, 1,
                    companiesList.get(column));
            cell.setEditable(false);
            cell.getStyleClass().add("compagny");
            companies.add(cell);
        }

        return companies;
    }

    /**
     * Return a row with some countries.
     *
     * @param grid
     * @param row
     * @return
     */
    private ObservableList<SpreadsheetCell> getCountries(GridBase grid, int row) {

        final ObservableList<SpreadsheetCell> countries = FXCollections.observableArrayList();

        SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(row, 0, 1, 1, "Countries");
        cell.setEditable(false);
        cell.getStyleClass().add("first-cell");
        countries.add(cell);

        for (int column = 1; column < grid.getColumnCount(); ++column) {
            cell = SpreadsheetCellType.LIST(countryList).createCell(row, column, 1, 1,
                    countryList.get((int) (Math.random() * 6)));
            countries.add(cell);
        }
        return countries;
    }

    /**
     * Return a row with some dates.
     *
     * @param grid
     * @param row
     * @return
     */
    private ObservableList<SpreadsheetCell> getStartDate(GridBase grid, int row) {

        final ObservableList<SpreadsheetCell> startDate = FXCollections.observableArrayList();

        SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(row, 0, 1, 1, "Start day");
        cell.setEditable(false);
        cell.getStyleClass().add("first-cell");
        startDate.add(cell);

        for (int column = 1; column < grid.getColumnCount(); ++column) {
            startDate.add(generateDateCell(row, column, 1, 1));
        }
        return startDate;
    }

    /**
     * Return a row with some Images.
     *
     * @param grid
     * @param row
     * @return
     */
    private ObservableList<SpreadsheetCell> getLogos(GridBase grid, int row) {

        final ObservableList<SpreadsheetCell> logos = FXCollections.observableArrayList();

        SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(row, 0, 1, 1, "Logo");
        cell.setEditable(false);
        cell.getStyleClass().add("first-cell");
        logos.add(cell);

        for (int column = 1; column < grid.getColumnCount(); ++column) {
            cell = SpreadsheetCellType.STRING.createCell(row, column, 1, 1, null);
            cell.setGraphic(new ImageView(new Image(getClass().getResourceAsStream(logoList.get(column)))));
            cell.getStyleClass().add("logo");
            cell.setEditable(false);
            logos.add(cell);
        }
        return logos;
    }

    /**
     * Return a row with Double.
     *
     * @param grid
     * @param row
     * @return
     */
    private ObservableList<SpreadsheetCell> getIncome(GridBase grid, int row) {

        final ObservableList<SpreadsheetCell> incomes = FXCollections.observableArrayList();

        SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(row, 0, 1, 1, "Income");
        cell.setEditable(false);
        cell.getStyleClass().add("first-cell");
        incomes.add(cell);

        SpreadsheetCell cell2 = SpreadsheetCellType.STRING.createCell(row, 1, 1, 1, "It's over 9000!");
        incomes.add(cell2);

        for (int column = 2; column < grid.getColumnCount(); ++column) {
            cell = generateDoubleCell(row, column, 1, 1);
            cell.setFormat("#,##0.00" + "\u20AC");

            incomes.add(cell);
        }
        return incomes;
    }

    /**
     * Return a row with Double.
     *
     * @param grid
     * @param row
     * @return
     */
    private ObservableList<SpreadsheetCell> getIncrease(GridBase grid, int row) {

        final ObservableList<SpreadsheetCell> increase = FXCollections.observableArrayList();

        SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(row, 0, 1, 1, "Increase");
        cell.setEditable(false);
        cell.getStyleClass().add("first-cell");
        increase.add(cell);

        for (int column = 1; column < grid.getColumnCount(); ++column) {
            cell = SpreadsheetCellType.DOUBLE.createCell(row, column, 1, 1, (double) Math.random());
            if (column % 2 == 1) {
                cell.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("exclamation.png"))));
            }
            cell.setFormat("#" + "%");
            increase.add(cell);
        }
        return increase;
    }

    /**
     * Return a List with Integer.
     *
     * @param grid
     * @param row
     * @return
     */
    private ObservableList<SpreadsheetCell> getEmployees(GridBase grid, int row) {

        final ObservableList<SpreadsheetCell> employees = FXCollections.observableArrayList();

        SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(row, 0, 1, 1, "Number of employees");
        cell.setEditable(false);
        cell.getStyleClass().add("first-cell");
        employees.add(cell);

        for (int column = 1; column < grid.getColumnCount(); ++column) {
            cell = SpreadsheetCellType.INTEGER.createCell(row, column, 1, 1,
                    Math.round((float) Math.random() * 10));
            employees.add(cell);
        }
        return employees;
    }

    /**
     * Return a row with some URL.
     *
     * @param grid
     * @param row
     * @return
     */
    private ObservableList<SpreadsheetCell> getWebSite(GridBase grid, int row) {

        final ObservableList<SpreadsheetCell> employees = FXCollections.observableArrayList();

        SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(row, 0, 1, 1, "WebSite ");
        cell.setEditable(false);
        cell.getStyleClass().add("first-cell");
        employees.add(cell);

        for (int column = 1; column < grid.getColumnCount(); ++column) {
            cell = SpreadsheetCellType.STRING.createCell(row, column, 1, 1, null);
            Hyperlink link = new Hyperlink(webSiteList.get(column));
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            URI uri;
            try {
                uri = new URI(link.getText());
                if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                    link.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent t) {
                            try {
                                desktop.browse(uri);
                            } catch (IOException ex) {
                            }
                        }
                    });
                }
            } catch (URISyntaxException ex) {
            }
            cell.setGraphic(link);
            cell.setEditable(false);
            employees.add(cell);
        }
        return employees;
    }

    /**
     * Return a row with blank non editable cell.
     *
     * @param grid
     * @param row
     * @return
     */
    private ObservableList<SpreadsheetCell> getSeparator(GridBase grid, int row) {

        final ObservableList<SpreadsheetCell> separator = FXCollections.observableArrayList();

        for (int column = 0; column < grid.getColumnCount(); ++column) {
            SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(row, column, 1, 1, "");
            cell.setEditable(false);
            cell.getStyleClass().add("separator");
            separator.add(cell);
        }
        return separator;
    }

    /**
     * Build the grid.
     *
     * @param grid
     */
    private void buildGrid(GridBase grid) {
        ArrayList<ObservableList<SpreadsheetCell>> rows = new ArrayList<>(grid.getRowCount());

        int rowIndex = 0;
        rows.add(getCompanies(grid, rowIndex++));
        rows.add(getCountries(grid, rowIndex++));
        rows.add(getStartDate(grid, rowIndex++));
        rows.add(getLogos(grid, rowIndex++));
        rows.add(getIncome(grid, rowIndex++));
        rows.add(getIncrease(grid, rowIndex++));
        rows.add(getEmployees(grid, rowIndex++));
        rows.add(getWebSite(grid, rowIndex++));

        //Separators
        rows.add(getSeparator(grid, rowIndex++));
        rows.add(getSeparator(grid, rowIndex++));
        rows.add(getSeparator(grid, rowIndex++));

        for (int i = rowIndex; i < rowIndex + 20; ++i) {
            final ObservableList<SpreadsheetCell> randomRow = FXCollections.observableArrayList();

            SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(i, 0, 1, 1, "Random " + (i + 1));
            cell.getStyleClass().add("first-cell");
            randomRow.add(cell);

            for (int column = 1; column < grid.getColumnCount(); column++) {
                randomRow.add(generateCell(i, column, 1, 1));
            }
            rows.add(randomRow);
        }
        grid.setRows(rows);

        grid.getRows().get(15).get(1).getStyleClass().add("span");
        grid.spanRow(2, 15, 1);
        grid.spanColumn(2, 15, 1);

        grid.getRows().get(18).get(1).getStyleClass().add("span");
        grid.spanColumn(4, 18, 1);

        grid.getRows().get(19).get(1).getStyleClass().add("span");
        grid.spanRow(3, 19, 1);
    }

    /**
     * Build a common control Grid with some options on the left to control the
     * SpreadsheetViewInternal
     *
     * @param gridType
     *
     * @param spreadsheetView
     * @return
     */
    private GridPane buildCommonControlGrid() {
        final GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(5, 5, 5, 5));

        int row = 0;

        // row header
        Label rowHeaderLabel = new Label("Row header: ");
        rowHeaderLabel.getStyleClass().add("property");
        grid.add(rowHeaderLabel, 0, row);
        rowHeader.setSelected(true);
        spreadSheetView.setShowRowHeader(true);
        grid.add(rowHeader, 1, row++);
        rowHeader.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
                spreadSheetView.setShowRowHeader(arg2);
            }
        });

        // column header
        Label columnHeaderLabel = new Label("Column header: ");
        columnHeaderLabel.getStyleClass().add("property");
        grid.add(columnHeaderLabel, 0, row);
        columnHeader.setSelected(true);
        spreadSheetView.setShowColumnHeader(true);
        grid.add(columnHeader, 1, row++);
        columnHeader.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
                spreadSheetView.setShowColumnHeader(arg2);
            }
        });

        // editable
        Label editableLabel = new Label("Editable: ");
        editableLabel.getStyleClass().add("property");
        grid.add(editableLabel, 0, row);
        editable.setSelected(true);
        spreadSheetView.setEditable(true);
        grid.add(editable, 1, row++);
        spreadSheetView.editableProperty().bind(editable.selectedProperty());
        
        //Row Header width
        Label rowHeaderWidth = new Label("Row header width: ");
        rowHeaderWidth.getStyleClass().add("property");
        grid.add(rowHeaderWidth, 0, row);
        Slider slider = new Slider(15, 100, 30);
        spreadSheetView.rowHeaderWidthProperty().bind(slider.valueProperty());
        grid.add(slider, 1, row++);
        
        return grid;
    }
}
