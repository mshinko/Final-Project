package com.finalproject.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class WordleController {
    /*buttonPlay.setOnAction
    @FXML
    protected void onPlayButtonClick(ActionEvent event) {
        System.out.println("test");
    }*/

    //need to grab file from home computer; forgot the exact way of attaching methods to UI elements

    @FXML
    private Button buttonPlay;

    @FXML
    private void initialize() {
        buttonPlay.setText("Click me");

        buttonPlay.setOnAction((event) -> {
            System.out.println("Button Action");
        });
    }


}