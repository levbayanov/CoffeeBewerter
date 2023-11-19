package org.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataBase {

    public void writeReview(String NameCoffee, Review review){
        FileOutputStream writeFile;
        try {
            writeFile = new FileOutputStream("123");
            writeFile.write(10);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
