package CoffeeBewerter;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BotMenu extends TelegramLongPollingBot {

    private final Map<String, String> bindingBy = new ConcurrentHashMap<>();
    private final Map<String, Action> actions;
    private final String username = "CoffeeBewerter";
    private final String token = "6770665703:AAF7XROQ82HGLJSkWC217USXrgp35nUDP2A";

    public BotMenu(Map<String, Action> actions) {
        this.actions = actions;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()){
            var key = update.getMessage().getText();
            var chatId = update.getMessage().getChatId().toString();
            if(actions.containsKey(key)){
                var message = actions.get(key).handle(update);
                bindingBy.put(chatId, key);
                send(message);
            }
            else if (bindingBy.containsKey(chatId)){
                var message = actions.get(bindingBy.get(chatId)).callback(update);
                bindingBy.remove(chatId);
                send(message);
            }
        }
    }
    private void send(BotApiMethod message)
    {
        try {
            execute(message);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
