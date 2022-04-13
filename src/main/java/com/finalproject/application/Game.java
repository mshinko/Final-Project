package com.finalproject.application;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Game{
    //file for game mechanics. I am unsure if specific labels and rectangles can be pulled from the controller class due to being unable to set the variables to static

    //dictionary implementation; word check; update squares
    private int currentRow = 0;

    //Linked list will be faster at this size
    private LinkedList dictionary = new LinkedList();
    private LinkedList completed = new LinkedList();
    private String selectedWord;
    private static Scanner dictionaryInput;
    private static Scanner completedInput;

    FileWriter fileWriter;
    PrintWriter printWriter;


    public Game() throws IOException {
        fileWriter = new FileWriter("completed.txt");
        printWriter = new PrintWriter(fileWriter);
        dictionaryInput = new Scanner(new File("dictionary.txt"));
        completedInput = new Scanner(new File("completed.txt"));
        dictionaryLoad();
        completedLoad();
        filter();
    }

    private void dictionaryLoad(){
        while(dictionaryInput.hasNext()){
            String line = dictionaryInput.nextLine();
            if(line.length() == 5){
                dictionary.addLast(line);
            }
        }
    }

    private void completedLoad(){
        while(completedInput.hasNext()){
            completed.addLast(completedInput.nextLine());
        }
    }

    private void filter(){
        for(int i = 0; i < completed.size(); i++){
            dictionary.remove(dictionary.indexOf(completed.get(i)));
        }
    }

    private void wordSelect(){

    }

    public void addCompleted(){
        completed.add(selectedWord);
        for(int i = 0; i < completed.size(); i++){
            printWriter.print(completed.get(i));
        }
        printWriter.close();
    }

    public String getSelectedWord() {
        return selectedWord;
    }
}