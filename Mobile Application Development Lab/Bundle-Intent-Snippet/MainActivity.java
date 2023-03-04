import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    ListView l;
    String[] food = {"abc","abc","abc","abc","abc","abc"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l=findViewById(R.id.lst);
        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,food);
        l.setAdapter(adp);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String clickedItem = "akshay";
                Toast.makeText(MainActivity.this,clickedItem,Toast.LENGTH_LONG).show();
                Intent in = new Intent(MainActivity.this,MainActivity2.class);
                Bundle b = new Bundle();
                b.putString("name",clickedItem);
                in.putExtras(b);
                startActivity(in);
            }
        });

    }
}
