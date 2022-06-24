package com.example.color.change.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.color.change.R;

public class EnterValueActivity extends AppCompatActivity {

    Button btn_submit,btn_grid;
    EditText edt_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value);

        edt_value = findViewById(R.id.edt_value);
        btn_submit = findViewById(R.id.btn_submit);
        btn_grid = findViewById(R.id.btn_grid);

        btn_submit.setOnClickListener(view -> {
            String value = edt_value.getText().toString().trim();
            startActivity(new Intent(getApplicationContext(), RecyclerActivity.class)
                    .putExtra("value", value));
        });

        btn_grid.setOnClickListener(view -> {
            String value = edt_value.getText().toString().trim();
            startActivity(new Intent(getApplicationContext(), GridActivity.class)
                    .putExtra("value", value));
        });
    }

}
