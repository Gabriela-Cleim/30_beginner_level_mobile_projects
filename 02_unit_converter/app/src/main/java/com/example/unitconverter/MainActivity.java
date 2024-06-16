package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*Desenvolva um app que converta unidades
*como metros para quilômetros, gramas para quilogramas, etc.
* */

public class MainActivity extends AppCompatActivity {

    private EditText inputMetros, inputGramas;
    private TextView resultadoKm, resultadoKg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findId();

        Button btnConverter = findViewById(R.id.btnConverter);
        btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                converterUnidades();
            }
        });
    }

    private void converterUnidades() {
        // Converter metros para quilômetros
        if (!inputMetros.getText().toString().isEmpty()) {
            double metros = Double.parseDouble(inputMetros.getText().toString());
            double quilometros = metros / 1000;
            resultadoKm.setText(String.format("%.2f", quilometros) + " km");
        } else {
            resultadoKm.setText("Insira um valor em metros");
        }

        // Converter gramas para quilogramas
        if (!inputGramas.getText().toString().isEmpty()) {
            double gramas = Double.parseDouble(inputGramas.getText().toString());
            double quilogramas = gramas / 1000;
            resultadoKg.setText(String.format("%.2f", quilogramas) + " kg");
        } else {
            resultadoKg.setText("Insira um valor em gramas");
        }
    }



    public void findId(){

        inputMetros = findViewById(R.id.inputMetros);
        inputGramas = findViewById(R.id.inputGramas);
        resultadoKm = findViewById(R.id.resultadoKm);
        resultadoKg = findViewById(R.id.resultadoKg);
    }
}