package com.example.radiobuttons;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*Desenvolva um app com um grupo de botões de rádio para escolher entre algumas opções e exibir a escolha do usuário.*/

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageButton imageBack, imagePlay, imageNext;

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

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Previous song");
            }
        });

        imagePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Playing: Demi Lovato - Sorry not Sorry");

                imagePlay.setBackgroundResource(R.drawable.baseline_pause_24);
            }
        });

        imageNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Next song");
            }
        });
    }

    private void findId(){

        textView = findViewById(R.id.txt);
        imageBack = findViewById(R.id.previous);
        imagePlay = findViewById(R.id.play);
        imageNext = findViewById(R.id.next);
    }
}