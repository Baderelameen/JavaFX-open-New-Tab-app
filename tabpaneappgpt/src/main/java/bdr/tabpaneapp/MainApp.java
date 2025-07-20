package bdr.tabpaneapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


    public class MainApp extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/bdr/tabpaneapp/view/main_view.fxml"));
            Scene scene = new Scene(loader.load(), 800, 600);
            primaryStage.setTitle("Dynamic TabPane Example");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }