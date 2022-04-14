package com.finalproject.application;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class WordleController {
    private static Label[] currentRowLabels = new Label[5];
    private static Rectangle[] currentRowBoxes = new Rectangle[5];
    private static Scene scene;
    //private static int currentRow = 0;
    private static String currentBox = "r0c0";
    private Map<String, Map.Entry<Label, Rectangle>> gridMap = new HashMap<String, Map.Entry<Label, Rectangle>>();
    //private static Game newGame = Wordle.getNewGame();


    // if there are better ways to do this, update me. there was no efficient way to initialize the variables
    // with the names of the labels in the UI in a better way other than this.
    // I attempted to do so inside the 2d array, but it failed as well. you cannot create a new label instance,
    // it needs to be the name of the FX:ID.
    @FXML
    Label r0c0Label, r0c1Label, r0c2Label, r0c3Label, r0c4Label,
                    r1c0Label, r1c1Label, r1c2Label, r1c3Label, r1c4Label,
                    r2c0Label, r2c1Label, r2c2Label, r2c3Label, r2c4Label,
                    r3c0Label, r3c1Label, r3c2Label, r3c3Label, r3c4Label,
                    r4c0Label, r4c1Label, r4c2Label, r4c3Label, r4c4Label,
                    r5c0Label, r5c1Label, r5c2Label, r5c3Label, r5c4Label;


    @FXML
    Rectangle r0c0Box, r0c1Box, r0c2Box, r0c3Box, r0c4Box,
                        r1c0Box, r1c1Box, r1c2Box, r1c3Box, r1c4Box,
                        r2c0Box, r2c1Box, r2c2Box, r2c3Box, r2c4Box,
                        r3c0Box, r3c1Box, r3c2Box, r3c3Box, r3c4Box,
                        r4c0Box, r4c1Box, r4c2Box, r4c3Box, r4c4Box,
                        r5c0Box, r5c1Box, r5c2Box, r5c3Box, r5c4Box;


    @FXML
    public void initialize(){
        load();
        //gridMap.get(currentBox).getKey().setText("A");


    }







    //tie the label and box together in a map for easier referencing
    @FXML
    private void load(){
        gridMap.put("r0c0", new AbstractMap.SimpleEntry(r0c0Label, r0c0Box));
        gridMap.put("r0c1", new AbstractMap.SimpleEntry(r0c1Label, r0c1Box));
        gridMap.put("r0c2", new AbstractMap.SimpleEntry(r0c2Label, r0c2Box));
        gridMap.put("r0c3", new AbstractMap.SimpleEntry(r0c3Label, r0c3Box));
        gridMap.put("r0c4", new AbstractMap.SimpleEntry(r0c4Label, r0c4Box));

        gridMap.put("r1c0", new AbstractMap.SimpleEntry(r1c0Label, r1c0Box));
        gridMap.put("r1c1", new AbstractMap.SimpleEntry(r1c1Label, r1c1Box));
        gridMap.put("r1c2", new AbstractMap.SimpleEntry(r1c2Label, r1c2Box));
        gridMap.put("r1c3", new AbstractMap.SimpleEntry(r1c3Label, r1c3Box));
        gridMap.put("r1c4", new AbstractMap.SimpleEntry(r1c4Label, r1c4Box));

        gridMap.put("r2c0", new AbstractMap.SimpleEntry(r2c0Label, r2c0Box));
        gridMap.put("r2c1", new AbstractMap.SimpleEntry(r2c1Label, r2c1Box));
        gridMap.put("r2c2", new AbstractMap.SimpleEntry(r2c2Label, r2c2Box));
        gridMap.put("r2c3", new AbstractMap.SimpleEntry(r2c3Label, r2c3Box));
        gridMap.put("r2c4", new AbstractMap.SimpleEntry(r2c4Label, r2c4Box));

        gridMap.put("r3c0", new AbstractMap.SimpleEntry(r3c0Label, r3c0Box));
        gridMap.put("r3c1", new AbstractMap.SimpleEntry(r3c1Label, r3c1Box));
        gridMap.put("r3c2", new AbstractMap.SimpleEntry(r3c2Label, r3c2Box));
        gridMap.put("r3c3", new AbstractMap.SimpleEntry(r3c3Label, r3c3Box));
        gridMap.put("r3c4", new AbstractMap.SimpleEntry(r3c4Label, r3c4Box));

        gridMap.put("r4c0", new AbstractMap.SimpleEntry(r4c0Label, r4c0Box));
        gridMap.put("r4c1", new AbstractMap.SimpleEntry(r4c1Label, r4c1Box));
        gridMap.put("r4c2", new AbstractMap.SimpleEntry(r4c2Label, r4c2Box));
        gridMap.put("r4c3", new AbstractMap.SimpleEntry(r4c3Label, r4c3Box));
        gridMap.put("r4c4", new AbstractMap.SimpleEntry(r4c4Label, r4c4Box));

        gridMap.put("r5c0", new AbstractMap.SimpleEntry(r5c0Label, r5c0Box));
        gridMap.put("r5c1", new AbstractMap.SimpleEntry(r5c1Label, r5c1Box));
        gridMap.put("r5c2", new AbstractMap.SimpleEntry(r5c2Label, r5c2Box));
        gridMap.put("r5c3", new AbstractMap.SimpleEntry(r5c3Label, r5c3Box));
        gridMap.put("r5c4", new AbstractMap.SimpleEntry(r5c4Label, r5c4Box));
    }

    @FXML
    protected void onQuitButtonClick() {
        Platform.exit();
    }


    @FXML
    protected void testForLabelMatrix(){
        // make function with input for each square in a row, manually center. I dont know why javafx refuses to center the text
        r1c1Label.setText("G");
        r1c1Label.setAlignment(Pos.CENTER);
        letterContains(r1c1Box);

        gridMap.get(currentBox).getKey().setText("A");

        //load();

        //Wordle.getNewGame();
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
        scene = new Scene(fxmlLoader.load(), 700, 825);
        Wordle.sceneLoader(scene);

        /*scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                //letterFill(keyEvent.getCode());
                gridMap.get(currentBox).getKey().setText("a");
                //r0c0Label.setText("a");
            }
        });*/
    }

    @FXML
    protected void menuSceneLoader() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Wordle.class.getResource("menu.fxml"));
        scene = new Scene(fxmlLoader.load(), 300, 400);
        Wordle.sceneLoader(scene);
    }


    public void onKeyTyped(){
        gridMap.get(currentBox).getKey().setText("A");
        gridMap.get(currentBox).getKey().setAlignment(Pos.CENTER);
    }




    public void letterFill(KeyCode k){
        if(!Character.isLetter(k.getChar().charAt(0))){
            return;
        }else if(k == KeyCode.BACK_SPACE){
            int c = Integer.parseInt(currentBox.substring((3)));
            if(c != 0){
                c--;
            }
            currentBox = currentBox.substring(0,3) + c;

            gridMap.get(currentBox).getKey().setText("");

            return;
        }

        gridMap.get(currentBox).getKey().setText(k.getChar());
        gridUpdate();

        //currentBox;
    }

    public void gridUpdate(){
        int r = Integer.parseInt(currentBox.substring(1,1));
        int c = Integer.parseInt(currentBox.substring(3));

        if(c == 4){
            if(r == 5){
                //end game
            }else{
                c = 0;
                r++;
            }
        }else{
            c++;
        }

        currentBox = "r" + r + "c" + c;
    }



    //implement scanners directly from here, and send info from the methods in this file
    //every "enter" input triggers "Game.java" class for check method?

    //System.in.read(new byte[0x0A]); //check for enter key specifically. must be running when all 5 letters are input, but cant stop the program
    //once 5 letters are input, only provide enter and delete inputs. have a trigger? method?

}