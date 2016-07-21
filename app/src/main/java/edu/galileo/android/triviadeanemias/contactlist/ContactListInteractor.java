package edu.galileo.android.triviadeanemias.contactlist;

/**
 * Created by ihanaht on 12/06/2016.
 */
public interface ContactListInteractor {
    void subscribeForContactEvents();
    void unsubscribeForContactEvents();
    void destroyContactListListener();
    void removeContact(String email);
}
