package CoffeeBewerter;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){

        var actions = Map.of(
                "/start", new InfoAction(
                        List.of(
                                "/start - Команды бота",
                                "/grade - оставить оценку",
                                "/review - Получить отзыв")
                ),
                "/grade", new GradeAction("/grade"),
                "/review", new ReviewAction("/review")

        );

        BotMenu tg = new BotMenu(actions);
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(tg);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}