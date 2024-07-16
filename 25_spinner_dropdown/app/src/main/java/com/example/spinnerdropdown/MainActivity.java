package com.example.spinnerdropdown;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*Desenvolva um app com um Spinner (dropdown) que permite ao usuário selecionar uma opção e exibe a seleção.*/

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
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

        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.txt);

        //Array de string para o spinner
        String[] items = {"Opção 1", "Opção 2", "Opção 3", "Opção 4"};

        // Criar um ArrayAdapter usando o array de strings e um layout padrão do Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        // Aplicar o adaptador ao Spinner
        spinner.setAdapter(adapter);

        // Configurar um listener para quando uma seleção é feita no Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obter o item selecionado
                String selectedItem = parent.getItemAtPosition(position).toString();
                // Exibir o item selecionado no TextView
                textView.setText("Selecionado: " + selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}