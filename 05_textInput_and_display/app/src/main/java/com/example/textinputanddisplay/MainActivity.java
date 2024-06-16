package com.example.textinputanddisplay;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*Desenvolva um app onde o usuário digita um texto em um campo e, ao clicar em um botão, o texto é exibido em outra parte da tela.*/
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

        button.setOnClickListener(v -> {
            String result = String.valueOf(editText.getText());
            textView.setText(result);
        });
    }

    public void findId(){
        editText = findViewById(R.id.edt);
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.txt);
    }
}