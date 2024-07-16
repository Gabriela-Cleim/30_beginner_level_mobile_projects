package com.example.changingimagewithtogglebutton;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*Faça um app com um ToggleButton que alterna entre duas imagens.*/

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private ImageView imageView;

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

        toggleButton = findViewById(R.id.toggle);
        imageView = findViewById(R.id.img);

        // Configurar um listener para quando o estado do ToggleButton é alterado
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                // Mostrar a segunda imagem
                imageView.setImageResource(R.drawable.ic_launcher_foreground);
            }else{
                // Mostrar a primeira imagem
                imageView.setImageResource(R.drawable.ic_launcher_background);
            }
        });
    }
}