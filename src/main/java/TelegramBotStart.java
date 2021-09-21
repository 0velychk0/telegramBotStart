import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TelegramBotStart {
    private static final Logger logger = LoggerFactory.getLogger(TelegramBotStart.class);

    public static void main(String[] args) {
        logger.info("TelegramBotStart.Main() is called");
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new OvelychkoTestBot());
        } catch (TelegramApiException e) {
            logger.debug("TelegramBotStart.Main() exception happened: {}", e.getMessage());
            e.printStackTrace();
        }
    }
}
