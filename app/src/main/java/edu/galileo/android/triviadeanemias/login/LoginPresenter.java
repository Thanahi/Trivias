package edu.galileo.android.triviadeanemias.login;


import edu.galileo.android.triviadeanemias.login.ui.events.LoginEvent;

/**
 * Created by ihanaht on 11/06/2016.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void onResume();
    void onPause();
    void checkForAuthenticatedUser();
    void onEventMainThread(LoginEvent event);
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
}
