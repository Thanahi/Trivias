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
public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "trivia";

    private static final String TABLE_QUEST = "cuestionario";

    private static final String KEY_ID = "id";
    private static final String KEY_PREG = "pregunta";
    private static final String KEY_RESP = "respuesta";
    private static final String KEY_OPTA= "opta";
    private static final String KEY_OPTB= "optb";
    private static final String KEY_OPTC= "optc";

    private SQLiteDatabase dbase;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_PREG
                    + " TEXT, " + KEY_RESP + " TEXT, " + KEY_OPTA + " TEXT, "
                    + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sql);
        addQuestion();
            // db.close();
    }

    private void addQuestion() {
        Question q1 = new Question("¿Qué anemia tiene los siguientes sintomas: Agotamiento, Taquicardia y Palpitaciones", "Anemia Ferropénica", "Talasemias", "Anemia Aplasica", "Anemia Ferropénica");
        this.addQuestion(q1);
        Question q2 = new Question("¿Cuál es la anemia más común en las personas?", "Aplasia Eritrocitaria", "Anemia Hemolíticas", "Anemia por deficiencia de acido fólico", "Anemia por deficiencia de acido fólico");
        this.addQuestion(q2);
        Question q3 = new Question("¿Tipo de dieta que debe seguir una persona con Anemia por deficiencia de vitamina B12?", "Hierro", "Vitamina B12, Cobre, Ácido Fólico, Hierro", "Ácido Fólico, Vitamina K y Vitamina C", "Vitamina B12, Cobre, Ácido Fólico, Hierro");
        this.addQuestion(q3);
        Question q4 = new Question("¿A que anemia perteneces estos datos de laboratorio Reticulocitosis, Hemoglobina (aumentada) y Hemosiderina en orina?", "Anemia Hemolíticas", "Esferocitosis Hereditaria", "Anemia Siberoblástica", "Anemia Hemolíticas");
        this.addQuestion(q4);
        Question q5 = new Question("¿Sintomas de la Anemia Siberoblástica?", "Cansancio, Taquicardía, Lengua lisa", "Pica, Agotamiento, Taquicardia", "Fatiga, Mareo, Taquicardia", "Fatiga, Mareo, Taquicardia");
        this.addQuestion(q5);
        Question q6 = new Question("¿Cual es la dieta para las personas con Anemia por deficiencia de Hierro?", "Hierro, Vitamina C  e Inhibidores de la absorción", "Hierro", "Vitamina K y Vitamina C", "Hierro, Vitamina C  e Inhibidores de la absorción");
        this.addQuestion(q6);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);

        onCreate(db);
    }

    public void addQuestion(Question quest) {

        ContentValues values = new ContentValues();
        values.put(KEY_PREG, quest.getPregunta());
        values.put(KEY_RESP, quest.getRespuesta());
        values.put(KEY_OPTA, quest.getOptA());
        values.put(KEY_OPTB, quest.getOptB());
        values.put(KEY_OPTC, quest.getOptC());

        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();

        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
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
