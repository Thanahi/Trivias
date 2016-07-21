package edu.galileo.android.triviadeanemias;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.triviadeanemias.login.ui.LoginActivity;

/**
 * Created by ihanaht on 21/07/2016.
 */
public class Option extends Activity  {


    @Bind(R.id.btntri)
    Button btntri;
    @Bind(R.id.btnchat)
    Button btnchat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_menu);
        ButterKnife.bind(this);

        btntri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Option.this,
                        Options.class);
                startActivity(intent);
                finish();
            }
        });
        btnchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Option.this,
                        LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
