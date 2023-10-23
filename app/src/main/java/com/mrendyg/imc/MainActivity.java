package com.mrendyg.imc;

import static android.widget.Toast.*;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.text.*;

public class MainActivity extends AppCompatActivity {

    private EditText edtxt1, edtxt2;
    private TextView tv1, tv2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtxt1 = (EditText) findViewById(R.id.ed_txt_num1);
        edtxt2 = (EditText) findViewById(R.id.ed_txt_num2);
        tv1 = (TextView) findViewById(R.id.tv_resultado);
        tv2 = (TextView) findViewById(R.id.tv_text);

    }

    public void calculo (View view){
        String peso = edtxt1.getText().toString();
        String estatura = edtxt2.getText().toString();
    if (peso.equals("") && estatura.equals(""))
        makeText(this,"Ingresa los datos", LENGTH_LONG).show();
    else {
        float peso1 = Float.parseFloat(peso);
        float estatura1 = Float.parseFloat(estatura);

        float estatura2 = estatura1 * estatura1;
        float imc = peso1 / estatura2;


        NumberFormat sd = new DecimalFormat("#.#");
        float resultado = Float.parseFloat(sd.format(imc));


        if (imc <= 18.5) {
            tv2.setText("Bajo Peso"); //amarillo
            tv2.setBackgroundColor(Color.YELLOW);
        } else if (imc >= 18.5 && imc <= 24.9) {
            tv2.setText("Peso Normal"); //verde
            tv2.setBackgroundColor(Color.GREEN);
        } else if (imc >= 25.0 && imc <= 29.9) {
            tv2.setText("Sobre Peso"); //naranja
            tv2.setBackgroundColor(Color.GRAY);
        } else if (imc >= 30) {
            tv2.setText("Obesidad"); //rojo
            tv2.setBackgroundColor(Color.RED);
        }

        String calculo = String.valueOf(resultado);
        tv1.setText(calculo);
    }
    }

    public void clean(View view){
        edtxt1.setText("");
        edtxt2.setText("");
        tv1.setText(null);
        tv2.setText(null);
    }


}