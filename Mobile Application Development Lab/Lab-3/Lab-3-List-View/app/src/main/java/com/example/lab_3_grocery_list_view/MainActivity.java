package com.example.lab_3_grocery_list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView dogsListView;
    private String[] dogBreeds = {"Labrador Retriever", "German Shepherd", "Bulldog", "Golden Retriever",
            "French Bulldog", "Beagle", "Poodle", "Rottweiler", "Dachshund",
            "Siberian Husky", "Boxer", "Doberman Pinscher"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dogsListView = findViewById(R.id.grocery_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, dogBreeds);

        dogsListView.setAdapter(adapter);

        dogsListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = (String) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_SHORT).show();
            System.out.println(selectedItem);
        });
    }
}
