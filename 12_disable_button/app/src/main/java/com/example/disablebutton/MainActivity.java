package com.example.disablebutton;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*Desenvolva um app onde, após clicar em um botão, ele se desativa por alguns segundos.*/

public class MainActivity extends AppCompatActivity {

    private Button button;
    private boolean buttonEnabled = true;
    private static final long DISABLE_TIME_MS = 5000;

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

        button = findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (buttonEnabled) {
                    buttonEnabled = false;
                    button.setEnabled(false);
                    button.setBackgroundColor(getResources().getColor(R.color.grey));
                    Toast.makeText(getApplicationContext(), "Botão desativado", Toast.LENGTH_LONG).show();

                    // Habilitar o botão novamente após alguns segundos
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            button.setEnabled(true);
                            buttonEnabled = true;
                            button.setBackgroundColor(getResources().getColor(R.color.yellow));

                        }
                    }, DISABLE_TIME_MS);
                }


            }
        });
    }
}