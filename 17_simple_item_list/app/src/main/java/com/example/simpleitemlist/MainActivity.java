package com.example.simpleitemlist;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*Desenvolva um app que exibe uma lista simples de itens (ex: frutas) usando ListView.*/

public class MainActivity extends AppCompatActivity {

    private ListView listView;

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

        String[] fruits = {"Banana", "Apple", "Mango", "Banana", "Apple", "Mango", "Banana",
                "Apple", "Mango", "Banana", "Apple", "Mango", "Banana", "Apple", "Mango",
                "Banana", "Apple", "Mango", "Banana", "Apple", "Mango", "Banana", "Apple", "Mango",
                "Banana", "Apple", "Mango", "Banana", "Apple", "Mango", "Apple", "Mango", "Banana",
                "Apple", "Mango", "Banana", "Apple", "Mango", "Banana", "Apple", "Mango",
                "Banana", "Apple", "Mango", "Banana", "Apple", "Mango", "Banana", "Apple", "Mango",
                "Banana", "Apple", "Mango", "Banana", "Apple", "Mango", "Apple", "Mango", "Banana",
                "Apple", "Mango", "Banana", "Apple", "Mango", "Banana", "Apple", "Mango",
                "Banana", "Apple", "Mango", "Banana", "Apple", "Mango", "Banana", "Apple", "Mango",
                "Banana", "Apple", "Mango", "Banana", "Apple", "Mango"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fruits);

        listView.setAdapter(adapter);
    }

    private void findId(){
        listView = findViewById(R.id.list_item);
    }
}