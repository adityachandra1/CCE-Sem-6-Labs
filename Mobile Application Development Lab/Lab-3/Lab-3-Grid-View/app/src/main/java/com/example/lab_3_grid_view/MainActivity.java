package com.example.lab_3_grid_view;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private GridView imageGridView;
    private int[] imageIds = {R.drawable.image1, R.drawable.image2, R.drawable.image3,
            R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7,
            R.drawable.image8, R.drawable.image9, R.drawable.image10, R.drawable.image11, R.drawable.image12, R.drawable.image13, R.drawable.image14, R.drawable.image15, R.drawable.image16};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageGridView = findViewById(R.id.image_gridview);

        ImageAdapter imageAdapter = new ImageAdapter(this, imageIds);

        imageGridView.setAdapter(imageAdapter);

        imageGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                ImageView imageView = view.findViewById(R.id.grid_image);
                // Do something with the selected image
            }
        });
    }
}
