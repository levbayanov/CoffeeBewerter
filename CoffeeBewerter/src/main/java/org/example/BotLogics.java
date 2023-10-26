package org.example;

public class BotLogics {

    public String readeMessage(String textMessage)
    {
        String answer;

        if ("/start".equals(textMessage))
        {
            answer = "Привет! я бот оценщик кафе";
        }
        else if("/grade".equals(textMessage))
        {
            answer = "Напиши название кафе\n и его оценку";
        }
        else
        {
            answer = "Я не понял";
        }
        return answer;
    }
}
