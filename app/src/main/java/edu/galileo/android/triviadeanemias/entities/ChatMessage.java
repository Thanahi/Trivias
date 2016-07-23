package edu.galileo.android.triviadeanemias.entities;

import com.google.firebase.database.Exclude;

/**
 * Created by ihanaht on 20/06/2016.
 */

public class ChatMessage {
    String msg;
    String sender;
    @Exclude
    boolean sentByMe;

    public ChatMessage() {}

    public ChatMessage(String sender, String msg) {
        this.msg = msg;
        this.sender = sender;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public boolean isSentByMe() {
        return sentByMe;
    }

    public void setSentByMe(boolean sentByMe) {
        this.sentByMe = sentByMe;
    }
}
