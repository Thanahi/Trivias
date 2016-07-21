package edu.galileo.android.triviadeanemias.contactlist;

/**
 * Created by ihanaht on 12/06/2016.
 */
public interface ContactListSessionInteractor {
    void signOff();
    String getCurrentUserEmail();
    void changeConnectionStatus(boolean online);
}
