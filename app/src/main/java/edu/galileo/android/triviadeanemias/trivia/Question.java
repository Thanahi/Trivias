package edu.galileo.android.triviadeanemias.trivia;

import android.app.Activity;

/**
 * Created by ihanaht on 19/07/2016.
 */
public class Question  extends Activity {
    private int ID;
    private String Pregunta;
    private String OptA;
    private String OptB;
    private String OptC;
    private String Respuesta;

    public Question()
    {
        ID=0;
        Pregunta ="";
        OptA ="";
        OptB ="";
        OptC ="";
        Respuesta ="";
    }
    public Question(String pregunta, String optA, String optB, String optC,
                    String respuesta) {

        Pregunta = pregunta;
        OptA = optA;
        OptB = optB;
        OptC = optC;
        Respuesta = respuesta;
    }
    public int getID()
    {
        return ID;
    }
    public String getPregunta() {
        return Pregunta;
    }
    public String getOptA() {
        return OptA;
    }
    public String getOptB() {
        return OptB;
    }
    public String getOptC() {
        return OptC;
    }
    public String getRespuesta() {
        return Respuesta;
    }
    public void setID(int id)
    {
        ID=id;
    }
    public void setPregunta(String pregunta) {
        Pregunta = pregunta;
    }
    public void setOptA(String optA) {
        OptA = optA;
    }
    public void setOptB(String optB) {
        OptB = optB;
    }
    public void setOptC(String optC) {
        OptC = optC;
    }
    public void setRespuesta(String respuesta) {
        Respuesta = respuesta;
    }
}
