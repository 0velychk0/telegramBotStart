import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class OvelychkoTestBot extends TelegramLongPollingBot {

    private static final Logger logger = LoggerFactory.getLogger(TelegramBotStart.class);
    private static final String TOKEN = "2016087363:AAHDyBO8a-r9Av4jt4_X7DTVLu-nEeMWnFc";
    private static final String USER_NAME = "ovelychkoTestBot";

    public String getBotUsername() {
        return USER_NAME;
    }

    public String getBotToken() {
        return TOKEN;
    }

    public void onRegister() {
        logger.info("registered");
        super.onRegister();
    }

    public void onUpdateReceived(Update update) {
        logger.info("onUpdateReceived");
        if (update.hasMessage() && update.getMessage().hasText()) {

            logger.info("onUpdateReceived from user {} the text message: {}",
                    update.getMessage().getFrom().getFirstName(),
                    update.getMessage().getText());
            String userName = update.getMessage().getFrom().getFirstName();
            long chat_id = update.getMessage().getChatId();
            try {
                execute(new SendMessage(String.valueOf(chat_id), "Hi " + userName + " - new user!"));
            } catch (Exception e) {
                System.out.println("Exception happened: {}" + e.getMessage());
            }
        }
    }
}
