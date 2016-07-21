package edu.galileo.android.triviadeanemias.contactlist;


import edu.galileo.android.triviadeanemias.contactlist.events.ContactListEvent;

/**
 * Created by ihanaht on 12/06/2016.
 */
public interface ContactListPresenter {
    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void onEventMainThread(ContactListEvent event);
}
