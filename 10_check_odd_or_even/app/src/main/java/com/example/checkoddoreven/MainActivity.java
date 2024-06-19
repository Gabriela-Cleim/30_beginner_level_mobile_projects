package com.example.checkoddoreven;

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

/*Desenvolva um app que verifica se um número inserido pelo usuário é par ou ímpar.*/

public class MainActivity extends AppCompatActivity {

    EditText editText1;
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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = editText1.getText().toString();

                int num1 = Integer.parseInt(text1);

                if(num1 % 2 == 0){
                    textView.setText("É par");
                }else{
                    textView.setText("É impar");
                }

            }
        });
    }

    public void findId(){
        editText1 = findViewById(R.id.edt1);
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.txt);
    }
}