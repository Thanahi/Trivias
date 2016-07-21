package edu.galileo.android.triviadeanemias.chat;


import edu.galileo.android.triviadeanemias.chat.events.ChatEvent;

/**
 * Created by ihanaht on 20/06/2016.
 */
public interface ChatPresenter {
    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void setChatRecipient(String recipient);

    void sendMessage(String msg);
    void onEventMainThread(ChatEvent event);
}
