public class Bot extends org.telegram.telegrambots.bots.TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(org.telegram.telegrambots.api.objects.Update update) {
        if(update.getMessage().getLeftChatMember()!=null || update.getMessage().getNewChatMembers()!=null){
            org.telegram.telegrambots.api.methods.updatingmessages.DeleteMessage initDeleteMEssage = new org.telegram.telegrambots.api.methods.updatingmessages.DeleteMessage();
            initDeleteMEssage.setChatId(update.getMessage().getChatId().toString());
            initDeleteMEssage.setMessageId(update.getMessage().getMessageId());
            try{
                deleteMessage(initDeleteMEssage);
            }catch(org.telegram.telegrambots.exceptions.TelegramApiException ex){

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
        org.telegram.telegrambots.ApiContextInitializer.init();
        org.telegram.telegrambots.TelegramBotsApi telegramBotsApi = new org.telegram.telegrambots.TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (org.telegram.telegrambots.exceptions.TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
