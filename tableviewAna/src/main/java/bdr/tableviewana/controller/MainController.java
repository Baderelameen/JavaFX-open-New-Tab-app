package bdr.tableviewana.controller;

import bdr.tableviewana.model.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class MainController {

    // Reference to the included controller
    @FXML
    private TaskTableController taskTableController;

    @FXML
    public void handleAddTask() {
        TableView<Task> table = taskTableController.getTaskTable();
        int nextNo = table.getItems().size() + 1;
        table.getItems().add(new Task(nextNo, "T00" + nextNo));
    }
}
