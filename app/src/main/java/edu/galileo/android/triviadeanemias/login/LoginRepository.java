package edu.galileo.android.triviadeanemias.login;

/**
 * Created by ihanaht on 11/06/2016.
 */
public interface LoginRepository {
    void signUp(final String email, final String password);
    void signIn(String email, String password);
    void checkAlreadyAuthenticated();
}
