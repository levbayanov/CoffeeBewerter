package CoffeeBewerter;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class GradeAction implements Action{
    public GradeAction(String action) {
    }

    @Override
    public BotApiMethod handle(Update update) {
        var message = update.getMessage();
        var chatId = message.getChatId().toString();
        String text = "Название кафе и ваша оценка от 1 до 5";
        return new SendMessage(chatId,text);
    }

    @Override
    public BotApiMethod callback(Update update) {
        var message = update.getMessage();
        var chatId = message.getChatId().toString();
        //работа с бд
        String text = "Спасибо за отзыв";
        return new SendMessage(chatId, text);
    }
}
