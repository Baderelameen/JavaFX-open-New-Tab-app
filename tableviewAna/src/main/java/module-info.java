module bdr.tableviewana {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens bdr.tableviewana to javafx.fxml;
    exports bdr.tableviewana;
    exports bdr.tableviewana.controller;
    opens bdr.tableviewana.controller to javafx.fxml;
}