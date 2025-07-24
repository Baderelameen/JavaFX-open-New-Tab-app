package bdr.tableviewana;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-view.fxml"));
   //  FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("bdr/tableview/editabletasktable/main-view.fxml"));
       Scene scene = new Scene(fxmlLoader.load(), 1200, 600);
         scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());

        primaryStage.setTitle("Editable Task Table");
        primaryStage.setScene(scene);
        primaryStage.show();
    }catch (Exception e) {
          e.printStackTrace();
        }
        }

    public static void main(String[] args) {
        launch(args);
    }
}
