package com.example;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if(update.getMessage().getLeftChatMember()!=null || update.getMessage().getNewChatMembers()!=null){
            DeleteMessage initDeleteMEssage = new org.telegram.telegrambots.api.methods.updatingmessages.DeleteMessage();
            initDeleteMEssage.setChatId(update.getMessage().getChatId().toString());
            initDeleteMEssage.setMessageId(update.getMessage().getMessageId());
            try{
                deleteMessage(initDeleteMEssage);
            }catch(TelegramApiException ex){

            }
        }
    }
//some text
    @Override
    public String getBotUsername() {
        return "@NotificationRemover_bot";
    }

    @Override
    public String getBotToken() {
        return "557298333:AAGqw-RWv_jcTsRi6OJAHq7aZMBPiI-8X3Q";
    }

    public static void main (String[] args) {
        System.out.println("OK");
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new org.telegram.telegrambots.TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
