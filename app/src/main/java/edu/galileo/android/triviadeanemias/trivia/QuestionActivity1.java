package edu.galileo.android.triviadeanemias.trivia;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.triviadeanemias.R;

/**
 * Created by ihanaht on 19/07/2016.
 */
public class QuestionActivity1 extends Activity {
    List<Question> quesList;
    int score = 0;
    int qid = 0;
    Question currentQ;
    @Bind(R.id.score)
    TextView scored;
    @Bind(R.id.timers)
    TextView timers;
    @Bind(R.id.txtQuestion)
    TextView txtQuestion;
    @Bind(R.id.btn0)
    Button btn0;
    @Bind(R.id.btn1)
    Button btn1;
    @Bind(R.id.btn2)
    Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);
        ButterKnife.bind(this);

        QuizHelper db = new QuizHelper(this);
        quesList = db.getAllQuestions();
        currentQ = quesList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        setQuestionView();
        timers.setText("00:02:00");

        CounterClass timer = new CounterClass(60000, 1000);
        timer.start();

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getAnswer(btn0.getText().toString());
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(btn1.getText().toString());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(btn2.getText().toString());
            }
        });
    }

    public void getAnswer(String AnswerString) {
        if (currentQ.getRespuesta().equals(AnswerString)) {

            score++;
            scored.setText("Puntuación : " + score);
        } else {


            Intent intent = new Intent(QuestionActivity1.this,
                    ResultActivity.class);

            Bundle b = new Bundle();
            b.putInt("puntuación", score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
        if (qid < 6) {

            currentQ = quesList.get(qid);
            setQuestionView();
        } else {

            Intent intent = new Intent(QuestionActivity1.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("puntuación", score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }


    }


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }


        @Override
        public void onFinish() {
            timers.setText("Time is up");
        }

        @Override
        public void onTick(long millisUntilFinished) {

            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            timers.setText(hms);
        }


    }

    private void setQuestionView() {

        txtQuestion.setText(currentQ.getPregunta());
        btn0.setText(currentQ.getOptA());
        btn1.setText(currentQ.getOptB());
        btn2.setText(currentQ.getOptC());

        qid++;
    }
}
