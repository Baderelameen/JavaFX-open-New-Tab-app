package bdr.tableviewana.controller;

import bdr.tableviewana.model.Task;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.LocalDateStringConverter;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TaskTableController {

    @FXML private TableView<Task> taskTable;
    @FXML private TableColumn<Task, Number> colNo;
    @FXML private TableColumn<Task, String> colId;
    @FXML private TableColumn<Task, String> colName;
    @FXML private TableColumn<Task, String> colDesc;
    @FXML private TableColumn<Task, java.time.LocalDate> colStart;
    @FXML private TableColumn<Task, java.time.LocalDate> colFinish;
    @FXML private TableColumn<Task, Number> colDuration;
    @FXML private TableColumn<Task, String> colUnit;
    @FXML private TableColumn<Task, Double> colQty;
    @FXML private TableColumn<Task, Double> colPrice;
    @FXML private TableColumn<Task, Double> colAmount;
    @FXML private TableColumn<Task, String> colComments;

    public TableView<Task> getTaskTable() {
        return taskTable;
    }

    @FXML
    public void initialize() {
        taskTable.setEditable(true);

        colNo.setCellValueFactory(data -> data.getValue().noProperty());
        colId.setCellValueFactory(data -> data.getValue().idProperty());
        colName.setCellValueFactory(data -> data.getValue().nameProperty());
        colName.setCellFactory(TextFieldTableCell.forTableColumn());

        colDesc.setCellValueFactory(data -> data.getValue().descriptionProperty());
        colDesc.setCellFactory(TextFieldTableCell.forTableColumn());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        colStart.setCellValueFactory(data -> data.getValue().startDateProperty());
        colStart.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter(formatter, null)));

        colFinish.setCellValueFactory(data -> data.getValue().finishDateProperty());
        colFinish.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter(formatter, null)));

        colDuration.setCellValueFactory(data -> Bindings.createLongBinding(
                () -> data.getValue().getDuration(), data.getValue().startDateProperty(), data.getValue().finishDateProperty()));

        colUnit.setCellValueFactory(data -> data.getValue().unitProperty());
        colUnit.setCellFactory(TextFieldTableCell.forTableColumn());

        colQty.setCellValueFactory(data -> data.getValue().quantityProperty().asObject());
        colQty.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        colPrice.setCellValueFactory(data -> data.getValue().unitPriceProperty().asObject());
        colPrice.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        colAmount.setCellValueFactory(data -> Bindings.createDoubleBinding(
                () -> data.getValue().getAmount(), data.getValue().quantityProperty(), data.getValue().unitPriceProperty()).asObject());

        colComments.setCellValueFactory(data -> data.getValue().commentsProperty());
        colComments.setCellFactory(TextFieldTableCell.forTableColumn());

        // Sample data
        taskTable.getItems().addAll(
                new Task(1, "T001"),
                new Task(2, "T002")
        );
    }
}
