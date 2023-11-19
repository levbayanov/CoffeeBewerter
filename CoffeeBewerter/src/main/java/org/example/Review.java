package org.example;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Review implements Serializable {
    private String nameCoffee;
    public int[] grades;
    public String average;

    Review(String nameCoffee, int grade){
        this.nameCoffee = nameCoffee;
        this.grades = new int[5];
        setGrade(grade);
    }

    private void setGrade(int grade)
    {
        grades[grade - 1] += 1;
    }

    public void saveState(){
        try {
            FileOutputStream fileOut = new FileOutputStream(nameCoffee + ".txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.flush();
            out.close();

            System.out.println("Одзыв сохранен");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Review loadState(String nameCoffee){
        try {
            FileInputStream fileIn = new FileInputStream(nameCoffee+".txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Review review = (Review) in.readObject();
            System.out.println("Одзыв востановлен");
            return review;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
