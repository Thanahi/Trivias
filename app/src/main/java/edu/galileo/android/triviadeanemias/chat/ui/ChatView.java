package edu.galileo.android.triviadeanemias.chat.ui;


import edu.galileo.android.triviadeanemias.entities.ChatMessage;

/**
 * Created by ihanaht on 20/06/2016.
 */
public interface ChatView {
    void sendMessage();
    void onMessageReceived(ChatMessage msg);
}
