package com.example.color.change.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.color.change.Adapter.RecyclerAdapter;
import com.example.color.change.Classes.ClsClickGetSet;
import com.example.color.change.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    List<ClsClickGetSet> lstClsClickGetSets = new ArrayList<>();
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        value = getIntent().getStringExtra("value");

        Random r=new Random();
        int randomNum = r.nextInt(Integer.parseInt(value)  + 1);

        for (int i = 1; i <= Integer.parseInt(value); i++) {
            if (randomNum == i) {
                lstClsClickGetSets.add(new ClsClickGetSet(false, true));
            } else {
                lstClsClickGetSets.add(new ClsClickGetSet(false, false));
            }
        }

        adapter = new RecyclerAdapter(lstClsClickGetSets, this);
        recyclerView.setAdapter(adapter);

        adapter.SetOnClickListener((obj, position) -> {
            if (obj.getColorValue().equalsIgnoreCase("gray")) {
                obj.setColorValue("green");
                adapter.notifyDataSetChanged();
            } else if (obj.getColorValue().equalsIgnoreCase("red")) {
                for (int i = 0; i < lstClsClickGetSets.size(); i++) {
                    if (lstClsClickGetSets.get(i).getColorValue().equalsIgnoreCase("gray")) {
                        obj.setColorValue("green");
                        lstClsClickGetSets.get(i).setColorValue("red");
                        adapter.notifyDataSetChanged();
                        return;
                    }
                }
            }else {
                Toast.makeText(this, "The Game is over...!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}