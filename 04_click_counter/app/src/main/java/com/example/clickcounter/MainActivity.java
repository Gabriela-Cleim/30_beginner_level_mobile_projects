package com.example.clickcounter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*Faça um app que conte quantas vezes um botão foi clicado e exiba o número na tela.*/

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    private int count = 0;

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
            count++;

            String result = String.valueOf(count);
            textView.setText(result);
        });

    }

    public void findId(){
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.txt);
    }
}