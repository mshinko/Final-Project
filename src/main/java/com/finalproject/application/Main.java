package com.finalproject.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    //private static Game newGame;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("menu.fxml"));
        Parent root = loader.load();
        //Controller controller = loader.getController();
        Scene scene = new Scene(root, 300, 400);

        stage.setTitle("Wordle");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    public static void main(String[] args) {
        launch();
    }
    /*public static Game getNewGame(){
        return newGame;
    }*/
}