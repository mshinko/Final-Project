package com.finalproject.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Wordle extends Application {
    private static Stage s;

    @Override
    public void start(Stage stage) throws IOException {
        s = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Wordle.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 400);
        sceneLoader(scene);
    }

    public static void sceneLoader(Scene scene){
        s.setTitle("Wordle");
        s.setScene(scene);
        s.show();
        s.centerOnScreen();
    }

    public static void main(String[] args) {
        launch();
    }
}