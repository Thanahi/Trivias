package edu.galileo.android.triviadeanemias.trivia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.triviadeanemias.R;

/**
 * Created by ihanaht on 16/07/2016.
 */
public class ResultActivity extends Activity {
    @Bind(R.id.textResult)
    TextView textResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);

        Bundle b = getIntent().getExtras();

        int score = b.getInt("puntuación");

        textResult.setText("Tu puntuación es " + " " + score + ". Gracias por jugar mi juego.");

    }

    public void playagain(View o) {

        Intent intent = new Intent(this, Options.class);

        startActivity(intent);
    }

}
