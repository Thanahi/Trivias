package edu.galileo.android.triviadeanemias.chat;

/**
 * Created by ihanaht on 20/06/2016.
 */
public interface ChatRepository {
    void sendMessage(String msg);
    void setReceiver(String receiver);

    void destroyChatListener();
    void subscribeForChatUpdates();
    void unsubscribeForChatUpdates();


    void changeUserConnectionStatus(boolean online);
}
