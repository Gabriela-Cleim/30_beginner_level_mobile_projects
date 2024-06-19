package com.example.celsiustofahrenheitconverter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

/*Desenvolva um app que converta uma temperatura de Celsius para Fahrenheit.*/

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;

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

        button.setOnClickListener(v ->{
            String celsius = editText.getText().toString();

            int convert = Integer.parseInt(celsius);

            double result = (convert * 1.8) + 32;

            String numForma = String.format(Locale.US, "%.2f", result);

            textView.setText(numForma);
        });


    }

    public void findId(){
        editText = findViewById(R.id.edt1);
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.txt);
    }
}