package com.example.opennewscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*Crie um app com um botão que abre uma nova tela (Activity) com uma mensagem.*/

public class MainActivity extends AppCompatActivity {

    private Button button;

    //02
    final Context context = this;

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

        /*Se voce "this" no intent e colocar dentro do botão, o "this" vai
         *fazer referencia ao OnClick e não a Activity e com isso podemos vamos ter um erro. Tem algumas
         * formas de resolver isso.
         * 1. Usar o nome da sua activity + o this (MainActivity.this)
         * 2. Usar uma variavel final para definir o contexto ou
         * 3. Usar o intent fora do botao (não recomendado)
         */

        //03
        //Intent intent = new Intent(this, MainActivity2.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //01
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

            }
        });
    }

    private void findId(){
        button = findViewById(R.id.button);
    }
}