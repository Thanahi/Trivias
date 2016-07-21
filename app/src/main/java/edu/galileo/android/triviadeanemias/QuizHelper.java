package edu.galileo.android.triviadeanemias;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ihanaht on 19/07/2016.
 */
public class QuizHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "trivia2";

    private static final String TABLE_QUEST = "quest";

    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_OPTA = "opta";
    private static final String KEY_OPTB = "optb";
    private static final String KEY_OPTC = "optc";
    private SQLiteDatabase dbase;
    public QuizHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sql);
        addQuestion();
    }
    private void addQuestion() {
        Question q1 = new Question("¿Qué es la Hipertensión?", "Presión Arterial Mayor a la normal", "Presión Arterial Menor a la normal",
                "Presión Arterial normal", "Presión Arterial Mayor a la normal");
        this.addQuestion(q1);
        Question q2 = new Question("Tipos de Hipertensión:", "Hipertensión primaria, Hipertensión secundaria o esencial", "Prehipertensión, Hipertensión",
                "Hipertensión primaria o esencial, Hipertensión secundaria", "Hipertensión primaria o esencial, Hipertensión secundaria");
        this.addQuestion(q2);
        Question q3 = new Question("¿Cuáles son los factores de riesgo de la hipertensión secundaria?", "Sobrepeso, Inactividad fisica, Tabaquismo, Dieta Hiperlipídica,  Síndrome nefrotico",
                "Sexo, Edad, Sobrepeso, Inactividad fisica, Exceso de consumo de sodio, Consumo bajo de potacio", "Edad, Enfermedad cardíaca, Enfisema, Diabetes",
                "Sexo, Edad, Sobrepeso, Inactividad fisica, Exceso de consumo de sodio, Consumo bajo de potacio");
        this.addQuestion(q3);
        Question q4 = new Question("¿Qué quieren decir las iniciales EPOC?", "Enfermedad Pulminar Obstructiva Crónica", "Enfermedad Pulmonar Ocasional Crónica",
                "Enfermedad Pulmonar Obstractiva Clásica", "Enfermedad Pulminar Obstructiva Crónica");
        this.addQuestion(q4);
        Question q5 = new Question("¿Cuáles son los factores de riesgo de EPOC?", "Sobrepeso, Estrés, Consumo excesivo de alcohol, Edad, Sexo", "Tabaquismo pasivo, Ácaros, Cirrosis",
                "Inhalación de humo, Infecciones, Tabaco, Edad, Factores geneticos", "Inhalación de humo, Infecciones, Tabaco, Edad, Factores geneticos");
        this.addQuestion(q5);
        Question q6 = new Question("Respuesta inmonitaria en la que hay una reacción clínicamente anormal que se puede atribuir a la ingesta o contacto de un alimento" +
                "o adictivo", "Alergias Alimentarias", "Asma", "Neumonía", "Alergias Alimentarias");
        this.addQuestion(q6);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);

        onCreate(db);
    }

    public void addQuestion(Question quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getPregunta());
        values.put(KEY_ANSWER, quest.getRespuesta());
        values.put(KEY_OPTA, quest.getOptA());
        values.put(KEY_OPTB, quest.getOptB());
        values.put(KEY_OPTC, quest.getOptC());

        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();

        String selectQuery = "SELECT * FROM " + TABLE_QUEST;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setPregunta(cursor.getString(1));
                quest.setRespuesta(cursor.getString(2));
                quest.setOptA(cursor.getString(3));
                quest.setOptB(cursor.getString(4));
                quest.setOptC(cursor.getString(5));

                quesList.add(quest);
            }
            while (cursor.moveToNext());
        }
        return quesList;
    }
}
