package com.finalproject.application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordleController {
    //public static Object controller;
    private static Label[] currentRowLabels = new Label[5];
    private static Rectangle[] currentRowBoxes = new Rectangle[5];

    //make new class object and throw variables into it rather than pulling?


    // if there are better ways to do this, update me. there was no efficient way to initialize the variables
    // with the names of the labels in the UI in a better way other than this.
    // I attempted to do so inside the 2d array, but it failed as well. you cannot create a new label instance,
    // it needs to be the name of the FX:ID.
    @FXML
    private Label r0c0Label, r0c1Label, r0c2Label, r0c3Label, r0c4Label,
            r1c0Label, r1c1Label, r1c2Label, r1c3Label, r1c4Label,
            r2c0Label, r2c1Label, r2c2Label, r2c3Label, r2c4Label,
            r3c0Label, r3c1Label, r3c2Label, r3c3Label, r3c4Label,
            r4c0Label, r4c1Label, r4c2Label, r4c3Label, r4c4Label,
            r5c0Label, r5c1Label, r5c2Label, r5c3Label, r5c4Label;

    // apparently 2d arrays do not work in terms of these FX:ID variables.
    // There is no way to do this where this isnt public now that the 2d array is off the table.

    // all boxes for color changing properties for each to show letter in word and letter in right spot
    @FXML
    private Rectangle r0c0Box, r0c1Box, r0c2Box, r0c3Box, r0c4Box,
            r1c0Box, r1c1Box, r1c2Box, r1c3Box, r1c4Box,
            r2c0Box, r2c1Box, r2c2Box, r2c3Box, r2c4Box,
            r3c0Box, r3c1Box, r3c2Box, r3c3Box, r3c4Box,
            r4c0Box, r4c1Box, r4c2Box, r4c3Box, r4c4Box,
            r5c0Box, r5c1Box, r5c2Box, r5c3Box, r5c4Box;


    //tried to put r0c0 for both rectangle and label into a hashmap to make it a lot easier. doesnt seem efficiently possible at the current moment
    //private Map<Integer, Map<Integer, List<Object>>> test = new HashMap<Integer, Map<Integer, List<Object>>>();
    /*private Map<String, List<Object>> test = new HashMap<String, List<Object>>();

    private void load(){
        test.put("r0c0", new Label[]{r0c0Label, r0c0Box});
    }*/





    @FXML
    protected void onQuitButtonClick() {
        Platform.exit();
    }


    @FXML
    protected void testForLabelMatrix() throws IOException{
        // make function with input for each square in a row, manually center. I dont know why javafx refuses to center the text
        r1c1Label.setText("G");
        r1c1Label.setAlignment(Pos.CENTER);
        letterContains(r1c1Box);

        Wordle.getNewGame();
        // allow users to type in all 5 spaces like normal line, delete and type normally,
        // and take the word when they press enter, then deny if its not a real word
    }


    //Box color setting
    //if letter is in word but not correct
    public static void letterContains(Rectangle r){
        r.setFill(Color.YELLOW);
    }
    //if letter is in word and is correct in position
    public static void letterPosition(Rectangle r){
        r.setFill(Color.GREEN);
    }



    //Scene loaders
    @FXML
    protected void gameSceneLoader() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Wordle.class.getResource("game.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 825);
        Wordle.sceneLoader(scene);
    }

    @FXML
    protected void menuSceneLoader() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Wordle.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 400);
        Wordle.sceneLoader(scene);
    }


    //intended on updating the row list (maps?) with FX:ID variables
    public static void update(){

    }





    //implement scanners directly from here, and send info from the methods in this file
    //every "enter" input triggers "Game.java" class for check method?

    //System.in.read(new byte[0x0A]); //check for enter key specifically. must be running when all 5 letters are input, but cant stop the program
    //once 5 letters are input, only provide enter and delete inputs. have a trigger? method?

}