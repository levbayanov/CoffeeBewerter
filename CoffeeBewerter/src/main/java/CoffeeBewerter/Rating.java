package CoffeeBewerter;

import java.io.*;

public class Rating implements Serializable {
    private String nameCoffee;
    public int[] grades;
    public String average;

    Rating(String nameCoffee, int grade){
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

            System.out.println("Отзыв сохранен");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Rating loadState(String nameCoffee){
        try {
            FileInputStream fileIn = new FileInputStream(nameCoffee+".txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Rating rating = (Rating) in.readObject();
            System.out.println("Отзыв востановлен");
            return rating;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
