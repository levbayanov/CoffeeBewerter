package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {

    BotLogics botLogics;
    String bot_token = "6770665703:AAF7XROQ82HGLJSkWC217USXrgp35nUDP2A";
    String bot_name = "CoffeeBewerter";

    public TelegramBot(BotLogics botLogics) {
        this.botLogics = botLogics;
    }

    @Override
    public String getBotUsername() {
        return bot_name;
    }

    @Override
    public String getBotToken() {
        return bot_token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message inMessage = update.getMessage();
        String chatId = inMessage.getChatId().toString();
        String userMessage = inMessage.getText();

        String answer = botLogics.ProcessingMessage(userMessage);
        SendMessage outMessage = new SendMessage();
        outMessage.setChatId(chatId);
        outMessage.setText(answer);

        try {
            execute(outMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
