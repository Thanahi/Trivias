package edu.galileo.android.triviadeanemias;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ihanaht on 19/07/2016.
 */
public class Options extends Activity {

    @Bind(R.id.btnanemias)
    Button btnanemias;
    @Bind(R.id.btnpatologias)
    Button btnpatologias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_menu);
        ButterKnife.bind(this);

        btnanemias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this,
                        QuestionActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnpatologias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this,
                        QuestionActivity1.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
