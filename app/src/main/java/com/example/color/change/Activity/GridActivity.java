package com.example.color.change.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.color.change.Adapter.GridAdapter;
import com.example.color.change.Adapter.RecyclerAdapter;
import com.example.color.change.Classes.ClsClickGetSet;
import com.example.color.change.Classes.OnClickListenerSetting;
import com.example.color.change.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GridActivity extends AppCompatActivity {
    GridView gridView;
    List<ClsClickGetSet> lstClsClickGetSets = new ArrayList<>();
    String value;
    GridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        gridView = findViewById(R.id.gridView);
        value = getIntent().getStringExtra("value");
        adapter = new GridAdapter(GridActivity.this);

        Random r = new Random();
        int randomNum = r.nextInt(Integer.parseInt(value) + 1);
        Log.d("--log--", "randomNum: " + randomNum);

        for (int i = 1; i <= Integer.parseInt(value); i++) {
            if (randomNum == i) {
                lstClsClickGetSets.add(new ClsClickGetSet(false, true));
            } else {
                lstClsClickGetSets.add(new ClsClickGetSet(false, false));
            }
        }
        adapter.addItemList(lstClsClickGetSets);
        gridView.setAdapter(adapter);

        adapter.SetOnClickListener(new OnClickListenerSetting() {
            @Override
            public void OnItemClick(ClsClickGetSet obj, int position) {

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
                }
            }
        });

    }

}