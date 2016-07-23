package edu.galileo.android.triviadeanemias.trivia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import edu.galileo.android.triviadeanemias.R;
import edu.galileo.android.triviadeanemias.login.ui.LoginActivity;


public class TriviaActivity extends Activity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {startActivity(new Intent(TriviaActivity.this, Options.class));
            }
        }, SPLASH_TIME_OUT);
    }

}
