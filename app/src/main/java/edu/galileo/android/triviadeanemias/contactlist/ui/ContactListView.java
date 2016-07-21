package edu.galileo.android.triviadeanemias.contactlist.ui;


import edu.galileo.android.triviadeanemias.entities.User;

/**
 * Created by ihanaht on 12/06/2016.
 */
public interface ContactListView {
    void onContactAdded(User user);
    void onContactChanged(User user);
    void onContactRemoved(User user);
}
