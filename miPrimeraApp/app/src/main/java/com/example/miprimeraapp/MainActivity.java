package com.example.miprimeraapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tempVal;
    RadioGroup radioGroup;
    Button btn;

    RadioButton opt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnCalcular);
        btn.setOnClickListener(v->calcular());
    }
    private void calcular(){
        tempVal = findViewById(R.id.txtNum1);
        Double num1 = Double.parseDouble(tempVal.getText().toString());

        tempVal = findViewById(R.id.txtNum2);
        Double num2 = Double.parseDouble(tempVal.getText().toString());

        double respuesta = 0;

        radioGroup = findViewById(R.id.optOpciones);
        if(radioGroup.getCheckedRadioButtonId()==R.id.optSuma) {
            respuesta = num1 + num2;
        }
        if(radioGroup.getCheckedRadioButtonId()==R.id.optResta) {
            respuesta = num1 - num2;
        }
        if(radioGroup.getCheckedRadioButtonId()==R.id.optMultiplicación) {
            respuesta = num1 * num2;
        }

        if(radioGroup.getCheckedRadioButtonId()==R.id.optDividir) {
            respuesta = num1 / num2;
        }

        if(radioGroup.getCheckedRadioButtonId()==R.id.optFactorial) {
            respuesta = 1;

            for (int i = 1; i <= num1; i++) {
                respuesta *= i;
            }
        }

        if(radioGroup.getCheckedRadioButtonId()==R.id.optPorcentaje) {
            respuesta = (num1 * num2) / 100;
        }

        if(radioGroup.getCheckedRadioButtonId()==R.id.optExponenciacion) {
            respuesta = Math.pow(num1, num2);
        }

        if(radioGroup.getCheckedRadioButtonId()==R.id.optRaiz) {
            respuesta = Math.sqrt(num1);
        }

        tempVal = findViewById(R.id.lblRespuesta);
        tempVal.setText("Respuesta: "+ respuesta);
    }

}