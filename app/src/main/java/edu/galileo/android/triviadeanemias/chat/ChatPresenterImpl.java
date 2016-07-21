package edu.galileo.android.triviadeanemias.chat;

import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.triviadeanemias.chat.events.ChatEvent;
import edu.galileo.android.triviadeanemias.chat.ui.ChatView;
import edu.galileo.android.triviadeanemias.entities.ChatMessage;
import edu.galileo.android.triviadeanemias.entities.User;
import edu.galileo.android.triviadeanemias.lib.EventBus;
import edu.galileo.android.triviadeanemias.lib.GreenRobotEventBus;


/**
 * Created by ihanaht on 20/06/2016.
 */
public class ChatPresenterImpl implements ChatPresenter {
    EventBus eventBus;
    ChatView chatView;
    ChatInteractor chatInteractor;
    ChatSessionInteractor chatSessionInteractor;

    public ChatPresenterImpl(ChatView chatView) {
        this.chatView = chatView;
        this.eventBus = GreenRobotEventBus.getInstance();

        this.chatInteractor = new ChatInteractorImpl();
        this.chatSessionInteractor = new ChatSessionInteractorImpl();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onResume() {
        chatInteractor.subscribeForChatUpdates();
        chatSessionInteractor.changeConnectionStatus(User.ONLINE);
    }

    @Override
    public void onPause() {
        chatInteractor.unsubscribeForChatUpdates();
        chatSessionInteractor.changeConnectionStatus(User.OFFLINE);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        chatInteractor.destroyChatListener();
        chatView = null;
    }

    @Override
    public void setChatRecipient(String recipient) {
        this.chatInteractor.setRecipient(recipient);
    }

    @Override
    public void sendMessage(String msg) {
        chatInteractor.SendMessage(msg);
    }

    @Override
    @Subscribe
    public void onEventMainThread(ChatEvent event) {
        if (chatView != null){
            ChatMessage msg = event.getMessage();
            chatView.onMessageReceived(msg);
        }
    }
}
