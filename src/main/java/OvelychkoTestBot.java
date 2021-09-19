import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class OvelychkoTestBot extends TelegramLongPollingBot {

    private static final String TOKEN = "2016087363:AAHDyBO8a-r9Av4jt4_X7DTVLu-nEeMWnFc";
    private static final String USER_NAME = "ovelychkoTestBot";

    public String getBotUsername() {
        return USER_NAME;
    }

    public String getBotToken() {
        return TOKEN;
    }

    public void onRegister() {
        super.onRegister();
    }

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();
            try {
                execute(new SendMessage(String.valueOf(chat_id), "Hi new user"));
            } catch (Exception e) {
                System.out.println("Exception happened: {}" + e.getMessage());
            }
        }
    }

    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }
}
