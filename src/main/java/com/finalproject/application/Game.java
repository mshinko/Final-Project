package com.finalproject.application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Game{
    private LinkedList<String> dictionary = new LinkedList();
    private LinkedList<String> completed = new LinkedList();
    private String selectedWord;
    private Scanner dictionaryInput;
    private Scanner completedInput;
    private FileWriter fileWriter;
    private PrintWriter printWriter;

    //Constructor
    public Game() throws IOException {
        dictionaryInput = new Scanner(new File("dictionary.txt"));
        completedInput = new Scanner(new File("completed.txt"));
        dictionaryLoad();
        completedLoad();
        filter();
        wordSelect();
        System.out.println(selectedWord);
    }

    //Loads dictionary and filters out 5 letter words
    private void dictionaryLoad(){
        while(dictionaryInput.hasNext()){
            String line = dictionaryInput.nextLine();
            if(line.length() == 5){
                dictionary.addLast(line);
            }
        }
    }

    //Loads previously completed words
    private void completedLoad(){
        while(completedInput.hasNext()){
            completed.addLast(completedInput.nextLine());
        }
    }

    //Removes completed words from list of options
    private void filter(){
        for(int i = 0; i < completed.size(); i++){
            dictionary.remove(dictionary.indexOf(completed.get(i)));
        }
    }

    //Selects a word at random
    private void wordSelect(){
        int num = (int)(Math.random()*dictionary.size());
        selectedWord = dictionary.get(num);
    }

    //Adds a completed word for future
    public void addCompleted() throws IOException{
        fileWriter = new FileWriter("completed.txt");
        completed.add(selectedWord);
        for(int i = 0; i < completed.size(); i++){
            fileWriter.write(completed.get(i));
            System.out.println(completed.get(i));
        }
        fileWriter.close();
    }

    //returns currently selected word
    public String getSelectedWord() {
        return selectedWord;
    }
}