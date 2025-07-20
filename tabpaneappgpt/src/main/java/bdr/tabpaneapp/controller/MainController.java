package bdr.tabpaneapp.controller;

import bdr.tabpaneapp.model.TabItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;

public class MainController {

    @FXML
    private TabPane tabPane;

    @FXML
    private AnchorPane tabArea;

    private int tabCounter = 1;
    private Tab plusTab;

    @FXML
    public void initialize() {
        setupContextMenu();
        setupPlusTab();

        tabPane.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
            if (newTab == plusTab) {
                handleNewTab(null);
            }
        });
    }

    private void setupContextMenu() {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem newTabItem = new MenuItem("Open New Tab");
        newTabItem.setOnAction(this::handleNewTab);
        contextMenu.getItems().add(newTabItem);

        tabArea.setOnContextMenuRequested((ContextMenuEvent event) -> {
            contextMenu.show(tabArea, event.getScreenX(), event.getScreenY());
        });
    }

    private void setupPlusTab() {
        plusTab = new Tab("+");
        plusTab.setClosable(false);
        tabPane.getTabs().add(plusTab);
    }

    @FXML
    public void handleNewTab(ActionEvent event) {
        TabItem tabItem = new TabItem("Tab " + tabCounter, "This is content for Tab " + tabCounter);
        Tab tab = new Tab(tabItem.getTitle(), new Label(tabItem.getContent()));
        tabPane.getTabs().add(tabPane.getTabs().size() - 1, tab); // before "+" tab
        tabPane.getSelectionModel().select(tab);
        tabCounter++;
    }
}
