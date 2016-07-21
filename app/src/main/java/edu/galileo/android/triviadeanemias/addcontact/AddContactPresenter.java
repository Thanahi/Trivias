package edu.galileo.android.triviadeanemias.addcontact;


import edu.galileo.android.triviadeanemias.addcontact.events.AddContactEvent;

/**
 * Created by ihanaht on 12/06/2016.
 */
public interface AddContactPresenter {
    void onShow();
    void onDestroy();

    void addContact(String email);
    void onEventMainThread(AddContactEvent event);
}
