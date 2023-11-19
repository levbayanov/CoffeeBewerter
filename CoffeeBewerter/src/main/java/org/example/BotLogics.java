package org.example;

import java.io.File;
import java.util.Arrays;

public class BotLogics {

    int flag = 0;

    public String ProcessingMessage(String textMessage) {
        String answer;
        if ("/start".equals(textMessage)) {
            flag = 0;
            answer = startBot();
        } else if ("/grade".equals(textMessage) || flag == 1) {
            answer = saveGrade(textMessage);
        } else if ("/review".equals(textMessage) || flag == 2){
            answer = getReview(textMessage);
        }
        else {
            answer = "введите команду /grade или /review";
        }
        return answer;
    }
    private String startBot()
    {
        return "Привет! я бот CoffeeBewerter, оценщик кофейн, /grade: оставить отзыв , /review";

    }

    private String saveGrade(String textMessage)
    {
        if(flag != 1)
        {
            flag = 1;
            return "Напиши название кофейни и оценку от 1 до 5";
        }
        String[] strings = textMessage.split(" ");
        String nameCoffee = strings[0];
        String grade = strings[1];
        int gradeInt = Integer.parseInt(grade);

        if(findFile(nameCoffee))
        {
            System.out.println("тут");
            Review review = Review.loadState(nameCoffee);
            review.grades[gradeInt-1] += 1;
            review.saveState();
        }
        else {
            System.out.println("тут2");
            Review review = new Review(nameCoffee, gradeInt);
            review.saveState();
        }

        flag = 0;
        return "Ваш одзыв сохранен";
    }
    private String getReview(String textMessage)
    {
        if (flag != 2)
        {
            flag = 2;
            return "напиши название кофейни";
        }
        Review review = Review.loadState(textMessage);
        flag = 0;
        return Arrays.toString(review.grades);
    }

    private boolean findFile(String nameFile)
    {
        File f = new File(nameFile+".txt");
        return f.exists();
    }

}
