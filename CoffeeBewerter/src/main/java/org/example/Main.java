package org.example;

import org.glassfish.jersey.jaxb.internal.XmlRootObjectJaxbProvider;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(telegramBot);
        }catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}