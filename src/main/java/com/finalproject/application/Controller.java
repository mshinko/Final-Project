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
    private boolean rowComplete = false;
    //currentBox is set on the position on the grid that is to be filled when a key is pressed, not the one after. insertion position
    private static String currentBox = "r0c0";
    private final Map<String, Map.Entry<Label, Rectangle>> gridMap = new HashMap<>();

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { load(); }

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
                //gridMap.get(currentBox).getKey().setText("a");
                //r0c0Label.setText("a");
            }
        });
    }


    //System.in.read(new byte[0x0A]); //check for enter key specifically. must be running when all 5 letters are input, but cant stop the program
    //once 5 letters are input, only provide enter and delete inputs. have a trigger? method?


    public void letterFill(KeyCode k){
        int r = Integer.parseInt(currentBox.substring(1,2));
        int c = Integer.parseInt(currentBox.substring(3));

        //check for if row is ready for analysis
        if(c == 0 && r != 0){
            if(rowComplete){
                rowComplete = false;
                //current line checked, color associated
            }else{
                return;
            }
        }


        if(k == KeyCode.BACK_SPACE){
            if(c == 0 && r != 0){
                c = 4;
                r--;
            } else if(c != 0){
                c--;
            }
            currentBox = currentBox.substring(0,3) + c;

            gridMap.get(currentBox).getKey().setText("");
            return;
        }else if(k == KeyCode.ENTER){
            if(r != 0){
                if(!gridMap.get(currentBox.substring(0,3) + "4").getKey().getText().equals("")){
                    rowComplete = true;
                }
            }
        }else if(!Character.isLetter(k.getChar().charAt(0))){
            return;
        }else {
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
        }

        gridMap.get(currentBox).getKey().setText(k.getChar());
        currentBox = "r" + r + "c" + c;


        //currentBox;
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
    }
}