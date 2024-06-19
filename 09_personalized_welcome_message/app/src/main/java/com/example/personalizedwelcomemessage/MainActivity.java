package com.example.personalizedwelcomemessage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;

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



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = editText.getText().toString();

                if(result.equals("Gabriela")){
                    String finalResult = "Seja bem vindo(a) ".concat(result).concat(". Sua gostosa!");
                    textView.setText(finalResult);
                }else{
                    String finalResult = "Seja bem vindo(a) ".concat(result);
                    textView.setT


            }
        });
    }

    public void findId(){
        editText = findViewById(R.id.edt);
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.txt);
    }
}