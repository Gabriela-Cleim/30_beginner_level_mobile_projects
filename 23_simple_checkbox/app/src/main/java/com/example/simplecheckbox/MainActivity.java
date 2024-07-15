package com.example.simplecheckbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

/*Crie um app com alguns checkboxes e um botão que exibe quais opções foram selecionadas.*/

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    private Button button;
    private TextView textView;

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
        getCheckbox();
    }

    private void getCheckbox(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder selectedOptions = new StringBuilder("Opções selecionadas:\n");

                if (checkBox1.isChecked()) {
                    selectedOptions.append("Opção 1\n");
                }
                if (checkBox2.isChecked()) {
                    selectedOptions.append("Opção 2\n");
                }
                if (checkBox3.isChecked()) {
                    selectedOptions.append("Opção 3\n");
                }
                if (checkBox4.isChecked()) {
                    selectedOptions.append("Opção 4\n");
                }

                textView.setText(selectedOptions.toString());
            }
        });

    }

    private void findId(){
        checkBox1 = findViewById(R.id.check01);
        checkBox2 = findViewById(R.id.check02);
        checkBox3 = findViewById(R.id.check03);
        checkBox4 = findViewById(R.id.check04);
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.txt);
    }
}