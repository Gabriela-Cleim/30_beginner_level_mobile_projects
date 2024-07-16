package com.example.randombackgroundimage;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

/*Faça um app que, ao clicar em um botão, muda a imagem de fundo para uma de várias imagens pré-definidas aleatoriamente.*/

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Button button;
    private Random random;

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

        linearLayout = findViewById(R.id.main);
        button = findViewById(R.id.btn);
        random = new Random();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int[] images = {R.drawable.one, R.drawable.two, R.drawable.tree};

                // Selecionar uma imagem aleatoriamente
                int randomIndex = random.nextInt(images.length);
                int selectedImage = images[randomIndex];

                // Definir a imagem selecionada como fundo
                Drawable drawable = ContextCompat.getDrawable(MainActivity.this, selectedImage);
                linearLayout.setBackground(drawable);
            }
        });


    }
}