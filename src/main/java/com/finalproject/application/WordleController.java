package com.finalproject.application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class WordleController {
    //need to grab file from home computer; forgot the exact way of attaching methods to UI elements

    @FXML
    protected void onQuitButtonClick(){
        Platform.exit();
    }

    @FXML
    protected void gameSceneLoader() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Wordle.class.getResource("game.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        Wordle.sceneLoader(scene);
    }



}