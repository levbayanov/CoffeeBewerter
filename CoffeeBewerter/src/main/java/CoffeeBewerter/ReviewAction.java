package CoffeeBewerter;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ReviewAction implements Action {
    public ReviewAction(String action) {
    }

    @Override
    public BotApiMethod handle(Update update) {
        var message = update.getMessage();
        var chatId = message.getChatId().toString();
        var text = "Название кафе";
        return new SendMessage(chatId,text);
    }

    @Override
    public BotApiMethod callback(Update update) {
        return null;
    }
}
