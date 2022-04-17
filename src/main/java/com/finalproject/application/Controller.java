package com.finalproject.application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private int currentRow = 0;
    private Game game = new Game();
    private String word;
    private String letters = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
    private boolean end = false;

    //currentBox is set on the position on the grid that is to be filled when a key is pressed, not the one after. insertion position
    private static String currentBox = "r0c0";
    private final Map<String, Map.Entry<Label, Rectangle>> gridMap = new HashMap<>();

    @FXML
    Label r0c0Label, r0c1Label, r0c2Label, r0c3Label, r0c4Label,
            r1c0Label, r1c1Label, r1c2Label, r1c3Label, r1c4Label,
            r2c0Label, r2c1Label, r2c2Label, r2c3Label, r2c4Label,
            r3c0Label, r3c1Label, r3c2Label, r3c3Label, r3c4Label,
            r4c0Label, r4c1Label, r4c2Label, r4c3Label, r4c4Label,
            r5c0Label, r5c1Label, r5c2Label, r5c3Label, r5c4Label,
            keyLabel;

    @FXML
    Rectangle r0c0Box, r0c1Box, r0c2Box, r0c3Box, r0c4Box,
            r1c0Box, r1c1Box, r1c2Box, r1c3Box, r1c4Box,
            r2c0Box, r2c1Box, r2c2Box, r2c3Box, r2c4Box,
            r3c0Box, r3c1Box, r3c2Box, r3c3Box, r3c4Box,
            r4c0Box, r4c1Box, r4c2Box, r4c3Box, r4c4Box,
            r5c0Box, r5c1Box, r5c2Box, r5c3Box, r5c4Box;

    @FXML
    Button exitButton;

    public Controller() throws IOException {
        word = game.getSelectedWord().toUpperCase();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        load();
    }

    @FXML
    private void load(){
        gridMap.put("r0c0", new AbstractMap.SimpleEntry<>(r0c0Label, r0c0Box));
        gridMap.put("r0c1", new AbstractMap.SimpleEntry<>(r0c1Label, r0c1Box));
        gridMap.put("r0c2", new AbstractMap.SimpleEntry<>(r0c2Label, r0c2Box));
        gridMap.put("r0c3", new AbstractMap.SimpleEntry<>(r0c3Label, r0c3Box));
        gridMap.put("r0c4", new AbstractMap.SimpleEntry<>(r0c4Label, r0c4Box));

        gridMap.put("r1c0", new AbstractMap.SimpleEntry<>(r1c0Label, r1c0Box));
        gridMap.put("r1c1", new AbstractMap.SimpleEntry<>(r1c1Label, r1c1Box));
        gridMap.put("r1c2", new AbstractMap.SimpleEntry<>(r1c2Label, r1c2Box));
        gridMap.put("r1c3", new AbstractMap.SimpleEntry<>(r1c3Label, r1c3Box));
        gridMap.put("r1c4", new AbstractMap.SimpleEntry<>(r1c4Label, r1c4Box));

        gridMap.put("r2c0", new AbstractMap.SimpleEntry<>(r2c0Label, r2c0Box));
        gridMap.put("r2c1", new AbstractMap.SimpleEntry<>(r2c1Label, r2c1Box));
        gridMap.put("r2c2", new AbstractMap.SimpleEntry<>(r2c2Label, r2c2Box));
        gridMap.put("r2c3", new AbstractMap.SimpleEntry<>(r2c3Label, r2c3Box));
        gridMap.put("r2c4", new AbstractMap.SimpleEntry<>(r2c4Label, r2c4Box));

        gridMap.put("r3c0", new AbstractMap.SimpleEntry<>(r3c0Label, r3c0Box));
        gridMap.put("r3c1", new AbstractMap.SimpleEntry<>(r3c1Label, r3c1Box));
        gridMap.put("r3c2", new AbstractMap.SimpleEntry<>(r3c2Label, r3c2Box));
        gridMap.put("r3c3", new AbstractMap.SimpleEntry<>(r3c3Label, r3c3Box));
        gridMap.put("r3c4", new AbstractMap.SimpleEntry<>(r3c4Label, r3c4Box));

        gridMap.put("r4c0", new AbstractMap.SimpleEntry<>(r4c0Label, r4c0Box));
        gridMap.put("r4c1", new AbstractMap.SimpleEntry<>(r4c1Label, r4c1Box));
        gridMap.put("r4c2", new AbstractMap.SimpleEntry<>(r4c2Label, r4c2Box));
        gridMap.put("r4c3", new AbstractMap.SimpleEntry<>(r4c3Label, r4c3Box));
        gridMap.put("r4c4", new AbstractMap.SimpleEntry<>(r4c4Label, r4c4Box));

        gridMap.put("r5c0", new AbstractMap.SimpleEntry<>(r5c0Label, r5c0Box));
        gridMap.put("r5c1", new AbstractMap.SimpleEntry<>(r5c1Label, r5c1Box));
        gridMap.put("r5c2", new AbstractMap.SimpleEntry<>(r5c2Label, r5c2Box));
        gridMap.put("r5c3", new AbstractMap.SimpleEntry<>(r5c3Label, r5c3Box));
        gridMap.put("r5c4", new AbstractMap.SimpleEntry<>(r5c4Label, r5c4Box));


    }

    public void initKeyActions(Scene scene){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                letterFill(keyEvent.getCode());
            }
        });
    }


    public void letterFill(KeyCode k){
        int r = Integer.parseInt(currentBox.substring(1,2));
        int c = Integer.parseInt(currentBox.substring(3));
        if(end){ return; }
        if(k == KeyCode.BACK_SPACE){
            if(c == 0 && r == currentRow){

            }else if(c == 0 && r != 0){
                c = 4;
                r--;
            } else if(c != 0){
                c--;
            }
            currentBox = "r" + r + "c" + c;
            gridMap.get(currentBox).getKey().setText("");
            return;
        }else if(k == KeyCode.ENTER){
            //Bug - when hitting enter multiple, prevents keys from being input
            if(c == 0 && r != 0){
                int numCorrect = 0;
                for(int i = 0; i < 5; i++){
                    String letter = gridMap.get("r" + currentRow + "c" + i).getKey().getText();
                    Rectangle rect = gridMap.get("r" + currentRow + "c" + i).getValue();
                    if(word.charAt(i) == letter.charAt(0)){
                        letterPosition(rect);
                        numCorrect++;
                    }else if(word.contains(letter)){
                        letterContains(rect);
                    }else{
                        letterIncorrect(rect);
                    }

                    if(letters.contains(letter)){
                        int index = letters.indexOf(letter);
                        if(index != letters.length()-1){
                            letters = letters.substring(0, index) + letters.substring(index+2);
                        }else{
                            letters = letters.substring(0,index-1);
                        }
                    }
                    keyLabel.setText("Available Letters\n" + letters);
                }
                currentRow++;
                if(numCorrect == 5){
                    endGame();
                    keyLabel.setText("");
                    return;
                }else if(currentRow == 6){
                    endGame();
                    keyLabel.setText(word);
                    return;
                }
                System.out.println("Complete");
            }
        }else if(!Character.isLetter(k.getChar().charAt(0))){
            return;
        }else {
            if(c == 4){
                c = 0;
                r++;
            }else{
                if(r == currentRow){
                    c++;
                }else if(r != currentRow){
                    return;
                }
            }
        }
        gridMap.get(currentBox).getKey().setText(k.getChar());
        currentBox = "r" + r + "c" + c;
    }

    private void endGame(){
        end = true;
        exitButton.setDisable(false);
        exitButton.setVisible(true);
        System.out.println("End");
    }

    //Box color setting
    //if letter is not in word
    public void letterIncorrect(Rectangle r){
        r.setFill(Color.RED);
    }
    //if letter is in word but not correct
    public void letterContains(Rectangle r){
        r.setFill(Color.YELLOW);
    }
    //if letter is in word and is correct in position
    public void letterPosition(Rectangle r){
        r.setFill(Color.GREEN);
    }



    //Buttons
    @FXML
    protected void onQuitButtonClick() {
        Platform.exit();
    }


    //Scene switching
    public void switchToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Controller.class.getResource("menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        currentRow = 0;
        letters = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
        currentBox = "r0c0";
        end = false;
    }

    public void switchToGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("game.fxml"));
        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        Controller controller = loader.getController();

        controller.initKeyActions(scene);

        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }
}