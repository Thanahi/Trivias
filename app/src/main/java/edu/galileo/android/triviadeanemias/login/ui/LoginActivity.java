package edu.galileo.android.triviadeanemias.login.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.galileo.android.triviadeanemias.R;
import edu.galileo.android.triviadeanemias.contactlist.ui.ContactListActivity;
import edu.galileo.android.triviadeanemias.login.LoginPresenter;
import edu.galileo.android.triviadeanemias.login.LoginPresenterImpl;
import edu.galileo.android.triviadeanemias.signup.SignUpActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @Bind(R.id.editTxtEmail)
    EditText Email;
    @Bind(R.id.editTxtPassword)
    EditText Password;
    @Bind(R.id.btnSignin)
    Button btnSignIn;
    @Bind(R.id.btnSignup)
    Button btnSignUp;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.LayoutContainer)
    RelativeLayout LayoutContainer;

    private LoginPresenter loginPresentador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresentador = new LoginPresenterImpl(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        loginPresentador.onResume();
        loginPresentador.checkForAuthenticatedUser();
    }

    @Override
    protected void onPause() {
        loginPresentador.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        loginPresentador.onDestroy();
        super.onDestroy();
    }

    @Override
    @OnClick(R.id.btnSignup)
    public void handleSignUp() {
        startActivity(new Intent(this, SignUpActivity.class));
    }

    @Override
    @OnClick(R.id.btnSignin)
    public void handleSignIn() {
        loginPresentador.validateLogin(Email.getText().toString(),
                Password.getText().toString());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void disableInputs() {
        setInputs(false);
    }

    @Override
    public void enableInputs() {
        setInputs(true);
    }

    @Override
    public void loginError(String error) {
        Password.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signin), error);
        Password.setError(msgError);
    }

    @Override
    public void navigateToMainScreen() {
        Intent intent = new Intent(this, ContactListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void newUserError(String error) {
        throw new UnsupportedOperationException("Operation is not valid in LoginActivity");
    }

    @Override
    public void newUserSuccess() {
        throw new UnsupportedOperationException("Operation is not valid in LoginActivity");
    }

    private void setInputs(boolean enabled){
        btnSignIn.setEnabled(enabled);
        btnSignUp.setEnabled(enabled);
        Email.setEnabled(enabled);
        Password.setEnabled(enabled);
    }

}
