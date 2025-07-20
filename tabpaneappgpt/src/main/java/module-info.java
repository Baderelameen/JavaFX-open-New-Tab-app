module bdr.tabpaneapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens bdr.tabpaneapp to javafx.fxml;
    exports bdr.tabpaneapp;
    exports bdr.tabpaneapp.controller;
    opens bdr.tabpaneapp.controller to javafx.fxml;
}