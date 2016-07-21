package edu.galileo.android.triviadeanemias.chat.events;


import edu.galileo.android.triviadeanemias.entities.ChatMessage;

/**
 * Created by ihanaht on 20/06/2016.
 */
public class ChatEvent {
    ChatMessage msg;

    public ChatEvent(ChatMessage msg){
        this.msg = msg;
    }

    public ChatMessage getMessage() {
        return msg;
    }
}
