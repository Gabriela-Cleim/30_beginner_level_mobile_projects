package com.example.sumcalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*Crie um aplicativo que permite ao usuário inserir dois números e exibe a soma deles.*/

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
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
            String edt1 = editText1.getText().toString();
            String edt2 = editText2.getText().toString();

            int num1 = Integer.parseInt(edt1);
            int num2 = Integer.parseInt(edt2);

            int result = num1 + num2;

            String finalResult = String.valueOf(result);

            textView.setText(finalResult);
        });


    }

    public void findId(){
        editText1 = findViewById(R.id.edt1);
        editText2 = findViewById(R.id.edt2);
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.txt);
    }
}