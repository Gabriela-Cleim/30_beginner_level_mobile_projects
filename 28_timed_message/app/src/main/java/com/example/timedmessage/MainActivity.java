package com.example.timedmessage;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*Desenvolva um app que exibe uma mensagem na tela por alguns segundos e depois a esconde.*/

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private static final int DISPLAY_TIME = 3000; // Tempo em milissegundos (3000 ms = 3 segundos)

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

        textView = findViewById(R.id.txt);

        // Exibir a mensagem
        textView.setVisibility(View.VISIBLE);

        // Esconder a mensagem após alguns segundos
        new Handler().postDelayed(() -> textView.setVisibility(View.GONE), DISPLAY_TIME);
    }
}