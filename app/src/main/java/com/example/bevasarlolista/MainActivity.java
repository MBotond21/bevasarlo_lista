package com.example.bevasarlolista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> items = new ArrayList<>();
    private List<String> quantitys = new ArrayList<>();
    private CustomAdapter customAdapter;
    private ListView listView;
    private EditText item_name_input;
    private EditText quantity_input;
    private Button add;


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

        init();
        this.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.add(item_name_input.getText().toString());
                quantitys.add(quantity_input.getText().toString());
                customAdapter.notifyDataSetChanged();
            }
        });

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent ujIntent = new Intent(MainActivity.this, DetailsActivity.class);
                ujIntent.putExtra("in", items.get(position));
                ujIntent.putExtra("q", quantitys.get(position));

                startActivity(ujIntent);

                finish();
            }
        });

        this.listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                items.remove(position);
                quantitys.remove(position);
                customAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void init(){
        this.customAdapter = new CustomAdapter(this, items, quantitys);
        this.listView = findViewById(R.id.item_list);
        this.item_name_input = findViewById(R.id.item_name_input);
        this.quantity_input = findViewById(R.id.item_quantity_input);
        this.add = findViewById(R.id.add);
        this.listView.setAdapter(customAdapter);
    }
}