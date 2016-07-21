package edu.galileo.android.triviadeanemias.chat;

/**
 * Created by ihanaht on 20/06/2016.
 */
public interface ChatInteractor {
    void SendMessage(String msg);
    void setRecipient(String recipient);

    void destroyChatListener();
    void subscribeForChatUpdates();
    void unsubscribeForChatUpdates();
}
