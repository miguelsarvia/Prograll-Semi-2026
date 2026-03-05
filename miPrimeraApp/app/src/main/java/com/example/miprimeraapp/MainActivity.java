package com.example.miprimeraapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TabHost tbh;
    TextView tempVal;
    Spinner spn;
    Button btn;

    double valores[] = new double[] {
            0.092903, // Pie Cuadrado
            0.6987,   // Vara Cuadrada
            0.836127, // Yarda Cuadrada
            1.0,      // Metro Cuadrado
            436.7,    // Tarea
            6987.0,   // Manzana
            10000.0   // Hectarea
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.tbhConversores);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec("Area")
                .setContent(R.id.tabLongitud)
                .setIndicator("AREA", null));

        tbh.addTab(tbh.newTabSpec("Agua")
                .setContent(R.id.tabporcentageAgua)
                .setIndicator("AGUA", null));



        btn = findViewById(R.id.btnLongitudAConvertir);
        btn.setOnClickListener(v -> convertirArea());
    }

    private void convertirArea(){

        spn = findViewById(R.id.spnLongitudDe);
        int de = spn.getSelectedItemPosition();

        spn = findViewById(R.id.spnlongitudesA);
        int a = spn.getSelectedItemPosition();

        tempVal = findViewById(R.id.txtLongitudCantidad);
        double cantidad = Double.parseDouble(tempVal.getText().toString());

        double respuesta = conversor(de, a, cantidad);

        tempVal = findViewById(R.id.lblMonedasRespuesta);
        tempVal.setText("Respuesta: " + respuesta);
    }

    double conversor(int de, int a, double cantidad){
        return valores[de] / valores[a] * cantidad;
    }

}