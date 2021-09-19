//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class TelegramBotStart {
//
//    public static void main(String[] args) {
//        SpringApplication.run(TelegramBotStart.class, args);
//    }
//}

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

public class TelegramBotStart {
    private static final Map<String, String> getenv = System.getenv();

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new OvelychkoTestBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
