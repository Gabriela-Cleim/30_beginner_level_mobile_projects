package com.example.displaynameandage;

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

/*Crie um app onde o usuário insere seu nome e idade e, ao clicar em um botão, exibe essas informações formatadas.*/

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextAge;
    private TextView textView;
    private Button button;

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

        editTextName = findViewById(R.id.edt_name);
        editTextAge = findViewById(R.id.edt_age);
        textView = findViewById(R.id.txt);
        button = findViewById(R.id.btn);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                textView.setText("Seu nome é: " + editTextName.getText() + " e sua idade é: " + editTextAge.getText());
            }
        });

    }
}