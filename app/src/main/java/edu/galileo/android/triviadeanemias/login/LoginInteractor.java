package edu.galileo.android.triviadeanemias.login;

/**
 * Created by ihanaht on 11/06/2016.
 */
public interface LoginInteractor {
    void checkAlreadyAuthenticated();
    void doSignUp(String email, String password);
    void doSignIn(String email, String password);
}
