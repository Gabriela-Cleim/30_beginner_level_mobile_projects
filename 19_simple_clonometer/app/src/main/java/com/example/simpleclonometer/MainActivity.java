package com.example.simpleclonometer;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*Faça um app com um botão que inicia um cronômetro e outro que para e reseta o cronômetro.*/

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button btnStart, btnStop;
    int elapsedTime = 0;

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

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // Lógica a ser executada periodicamente
                // Por exemplo, atualização de uma TextView com o tempo decorrido

                elapsedTime++;
                textView.setText(String.valueOf(elapsedTime));

                // Repetir a execução do Runnable após um intervalo de tempo
                handler.postDelayed(this, 1000); // 1000 milissegundos = 1 segundo
            }
        };


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.post(runnable);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(runnable);
                textView.setText("0");
            }
        });
    }

    private void findId(){
        textView = findViewById(R.id.txt);
        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);
    }
}