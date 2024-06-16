package com.example.simplecalculator;

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

/*Crie uma calculadora básica com operações de adição, subtração, multiplicação e divisão.*/

public class MainActivity extends AppCompatActivity {

    TextView edtResult;
    EditText editText1, editText2;
    Button buttonPlus, buttonMinus, buttonPorce, buttonMult;


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



        findIds();

        if(buttonPlus.isClickable()){
            buttonPlus.setOnClickListener(v -> {
                String edt1 = editText1.getText().toString();
                String edt2 = editText1.getText().toString();

                int edt1Final = Integer.parseInt(edt1);
                int edt2Final = Integer.parseInt(edt2);

                int result = edt1Final + edt2Final;

                String finalResult = String.valueOf(result);

                edtResult.setText(finalResult);
            });
        }else if(buttonPorce.isClickable()){
            buttonPlus.setOnClickListener(v -> {
                String edt1 = editText1.getText().toString();
                String edt2 = editText1.getText().toString();

                int edt1Final = Integer.parseInt(edt1);
                int edt2Final = Integer.parseInt(edt2);

                int result = edt1Final / edt2Final;

                String finalResult = String.valueOf(result);

                edtResult.setText(finalResult);
            });
        } else if (buttonMult.isClickable()) {
            buttonPlus.setOnClickListener(v -> {
                String edt1 = editText1.getText().toString();
                String edt2 = editText1.getText().toString();

                int edt1Final = Integer.parseInt(edt1);
                int edt2Final = Integer.parseInt(edt2);

                int result = edt1Final * edt2Final;

                String finalResult = String.valueOf(result);

                edtResult.setText(finalResult);
            });
        }else if(buttonMinus.isClickable()){
            buttonPlus.setOnClickListener(v -> {
                String edt1 = editText1.getText().toString();
                String edt2 = editText1.getText().toString();

                int edt1Final = Integer.parseInt(edt1);
                int edt2Final = Integer.parseInt(edt2);

                int result = edt1Final - edt2Final;

                String finalResult = String.valueOf(result);

                edtResult.setText(finalResult);
            });
        }


    }

    public void findIds(){
        editText1 = findViewById(R.id.edt_primeiro);
        editText2 = findViewById(R.id.edt_segundo);
        edtResult = findViewById(R.id.edt_result);
        buttonMinus = findViewById(R.id.menos);
        buttonMult = findViewById(R.id.vezes);
        buttonPlus = findViewById(R.id.mais);
        buttonPorce = findViewById(R.id.porcentagem);
    }
}