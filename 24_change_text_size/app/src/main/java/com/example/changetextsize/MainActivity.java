package com.example.changetextsize;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*Faça um app com um botão que aumenta e outro que diminui o tamanho do texto de um TextView.*/

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button, button1;

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
        button = findViewById(R.id.btn);
        button1 = findViewById(R.id.btn2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float textSize = textView.getTextSize() / getResources().getDisplayMetrics().scaledDensity;
                textSize++;
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float textSize = textView.getTextSize() / getResources().getDisplayMetrics().scaledDensity;
                textSize--;
                if (textSize < 12) { // Evitar que o tamanho do texto fique muito pequeno
                    textSize = 12;
                }
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
            }
        });


    }
}