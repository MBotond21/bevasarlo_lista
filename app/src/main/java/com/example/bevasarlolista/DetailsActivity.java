package com.example.bevasarlolista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailsActivity extends AppCompatActivity {

    private TextView item_name;
    private TextView quantity;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
        Bundle bundle = getIntent().getExtras();
        String in = bundle.getString("in");
        String q = bundle.getString("q");

        item_name.setText(in);
        quantity.setText(q);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ujIntent = new Intent(DetailsActivity.this, MainActivity.class);

                startActivity(ujIntent);

                finish();
            }
        });

    }

    private void init() {
        this.item_name = findViewById(R.id.item_name_detail);
        this.quantity = findViewById(R.id.item_quantity_detail);
        this.back = findViewById(R.id.back);
    }
}