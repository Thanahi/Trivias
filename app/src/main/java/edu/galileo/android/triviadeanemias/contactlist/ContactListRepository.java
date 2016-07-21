package edu.galileo.android.triviadeanemias.contactlist;

/**
 * Created by ihanaht on 12/06/2016.
 */
public interface ContactListRepository {
    void signOff();
    String getCurrentEmail();
    void removeContact(String email);
    void destroyContactListListener();
    void subscribeForContactListUpdates();
    void unsubscribeForContactListUpdates();
    void changeUserConnectionStatus(boolean online);
}
