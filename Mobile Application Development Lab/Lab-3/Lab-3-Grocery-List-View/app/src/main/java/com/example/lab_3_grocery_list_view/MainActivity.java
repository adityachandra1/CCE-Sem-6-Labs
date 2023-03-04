package com.example.lab_3_grocery_list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView groceryListView;
    private String[] groceryItems = {"Apples", "Bananas", "Bread", "Butter", "Milk", "Carrot", "Honey"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        groceryListView = findViewById(R.id.grocery_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, groceryItems);

        groceryListView.setAdapter(adapter);

        groceryListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = (String) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_SHORT).show();
            System.out.println(selectedItem);
        });
    }
}
