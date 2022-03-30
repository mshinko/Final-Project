package com.finalproject.application;

import eu.hansolo.tilesfx.skins.WorldMapTileSkin;
import javafx.fxml.FXML;

import java.security.Signature;

public class Game {
    private WordleController wc = WordleController.instance();
    //file for game mechanics. I am unsure if specific labels and rectangles can be pulled from the controller class due to being unable to set the variables to static

    //dictionary implementation; word check; update squares
    private int currentRow = 0;

    private String word;

    public Game(){
        word = "tests";
    }

    //TEST METHOD
    public void rowCheck(){
        //pulling the controller object in doesnt seem to work. not sure how to pull what it stores in terms of the WordleController object it contains
    }
}