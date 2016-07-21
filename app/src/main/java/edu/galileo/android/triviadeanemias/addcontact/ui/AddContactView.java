package edu.galileo.android.triviadeanemias.addcontact.ui;

/**
 * Created by ihanaht on 12/06/2016.
 */
public interface AddContactView {
    void showInput();
    void hideInput();
    void showProgress();
    void hideProgress();

    void contactAdded();
    void contactNotAdded();
}
