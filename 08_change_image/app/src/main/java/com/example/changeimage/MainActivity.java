package com.example.changeimage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*Faça um app com duas imagens e um botão que alterna entre elas.*/


public class MainActivity extends AppCompatActivity {


    //Criando a instancia do imageView e do Button
    ImageView imageView;
    Button button;



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

        //Declara o metodo que tem os ids dos atributos
        findId();

        //Array com os IDs das imagens
        int[] images = {R.drawable.image1, R.drawable.image2};




        button.setOnClickListener(new View.OnClickListener() {
            int index = 0;

            @Override
            public void onClick(View v) {
                // Alterna entre as imagens
                index = (index + 1) % images.length;
                imageView.setImageResource(images[index]);
            }
        });
    }

    public void findId(){
        imageView = findViewById(R.id.image);
        button = findViewById(R.id.btn);
    }
}