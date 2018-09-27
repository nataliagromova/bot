/**
 * Created by NATA on 26.09.2018.
 */

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update)  {
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chat_id)
                    .setText(message_text);
            try {
                execute( message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


    public String getBotUsername() {
        return "my_bot";
    }
    public String getBotToken() {
        return "672281225:AAGSKrKFwCYEQUTGbGVIvhTAsk8EOnDIY7M";
    }
}


