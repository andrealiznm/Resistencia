package com.andrealiznm.resistencia;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Half;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Spinner sBanda1, sBanda2, sBanda3, sBanda4;
    TextView eDisplay;
    String[] datosB1 = {"Banda 1","Marron", "Rojo", "Naranja", "Amarillo", "Verde", "Azul", "Purpura", "Gris", "Blanco"};
    String[] datosB2 = {"Banda 2","Negro" ,"Marron", "Rojo", "Naranja", "Amarillo", "Verde", "Azul", "Purpura", "Gris", "Blanco"};
    String[] datosB3 = {"Banda 3","Negro ","Marron", "Rojo", "Naranja", "Amarillo", "Verde", "Azul", "Dorado", "Plateado"};
    String[] datosB4 = {"Banda 4","Marron", "Rojo", "Dorado", "Plateado"};
    String[] valorB1 = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String[] valorB2 = {"","0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String[] valorB3 = {"","1", "0", "00", "000", "0000", "00000", "000000", "10", "100"};
    String[] valorB4 = {"","1", "2", "5", "10"};
    String banda1, banda2, banda3, banda4, b1, b2, b3, b4;
    show result = new show();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sBanda1 = findViewById(R.id.sBanda1);
        sBanda2 = findViewById(R.id.sBanda2);
        sBanda3 = findViewById(R.id.sBanda3);
        sBanda4 = findViewById(R.id.sBanda4);
        eDisplay = findViewById(R.id.eDisplay);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datosB1);
        sBanda1.setAdapter(adaptador);
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datosB2);
        sBanda2.setAdapter(adaptador2);
        ArrayAdapter<String> adaptador3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datosB3);
        sBanda3.setAdapter(adaptador3);
        ArrayAdapter<String> adaptador4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datosB4);
        sBanda4.setAdapter(adaptador4);


        sBanda1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                banda1 = valorB1[i];
                result.main();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sBanda2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                banda2 = valorB2[i];
                result.main();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sBanda3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                banda3 = valorB3[i];
                result.main();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(), "Falta un campo", Toast.LENGTH_SHORT).show();
            }
        });

        sBanda4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                banda4 = valorB4[i];
                result.main();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public class show {
        //banda3 en pos 2 es vacio -> solucionar .
        public void main (){
            if(banda1.isEmpty() || banda2.isEmpty() || banda3.isEmpty() || banda4.isEmpty()){
                eDisplay.setText("");
                //Toast.makeText(getApplicationContext(), "Falta un campo", Toast.LENGTH_SHORT).show();
            }else if(banda3 == "10"){
                eDisplay.setText(banda1+"."+banda2+" ohm "+banda4+"%");
            }else if (banda3 == "100"){
                eDisplay.setText("0."+banda1+banda2+" ohm "+banda4+"%");
            }else if (banda3 == "0"){
                eDisplay.setText(banda1+banda2+banda3+" ohm "+banda4+"%");
            }else if (banda3 == "00"){
                eDisplay.setText(banda1+"."+banda2+"K ohm "+banda4+"%");
            }else if (banda3 == "000"){
                eDisplay.setText(banda1+banda2+"K ohm "+banda4+"%");
            }else if (banda3 == "0000"){
                eDisplay.setText(banda1+banda2+"0K ohm "+banda4+"%");
            }else if(banda3 == "00000"){
                eDisplay.setText(banda1+"."+banda2+"M ohm "+banda4+"%");
            }else if (banda3 == "000000"){
                eDisplay.setText(banda1+banda2+"M ohm "+banda4+"%");
            }else if (banda3 == "1"){
                eDisplay.setText(banda1+banda2+" ohm "+banda4+"%");
            }
        }
    }
}
