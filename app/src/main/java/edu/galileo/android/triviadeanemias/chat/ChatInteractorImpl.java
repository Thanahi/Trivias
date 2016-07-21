package edu.galileo.android.triviadeanemias.chat;

/**
 * Created by ihanaht on 20/06/2016.
 */
public class ChatInteractorImpl implements ChatInteractor {
    ChatRepository chatRepository;

    public ChatInteractorImpl() {
        this.chatRepository = new ChatRepositoryImpl();
    }

    @Override
    public void subscribeForChatUpdates() {
        chatRepository.subscribeForChatUpdates();
    }

    @Override
    public void unsubscribeForChatUpdates() {
        chatRepository.unsubscribeForChatUpdates();
    }

    @Override
    public void destroyChatListener() {
        chatRepository.destroyChatListener();
    }

    @Override
    public void setRecipient(String recipient) {
        chatRepository.setReceiver(recipient);
    }

    @Override
    public void SendMessage(String msg) {
        chatRepository.sendMessage(msg);
    }
}
