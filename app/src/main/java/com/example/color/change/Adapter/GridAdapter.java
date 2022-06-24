package com.example.color.change.Adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;

import com.example.color.change.Classes.ClsClickGetSet;
import com.example.color.change.Classes.OnClickListenerSetting;
import com.example.color.change.R;

import java.util.ArrayList;
import java.util.List;


public class GridAdapter extends ArrayAdapter<ClsClickGetSet> {

    Context mContext;
    List<ClsClickGetSet> lst = new ArrayList<>();
    private OnClickListenerSetting mOnClick;

    public GridAdapter(Context mContext) {
        super(mContext, 0);
        this.mContext = mContext;
    }

    public void SetOnClickListener(OnClickListenerSetting mOnClick) {
        this.mOnClick = mOnClick;
    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void addItemList(List<ClsClickGetSet> updateList) {
        lst = updateList;
        notifyDataSetChanged();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(mContext).inflate(R.layout.row_item, parent, false);
        }
        ClsClickGetSet obj = lst.get(position);
        Button button = listitemView.findViewById(R.id.button);

        if(obj.getColorValue().equalsIgnoreCase("red")){
            button.setBackgroundColor(mContext.getColor(R.color.red));
        }else if(obj.getColorValue().equalsIgnoreCase("green")){
            button.setBackgroundColor(mContext.getColor(R.color.green));
        }else {
            button.setBackgroundColor(mContext.getColor(R.color.bg));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindClick(obj, mOnClick, position);
            }
        });
        return listitemView;
    }

    void bindClick(ClsClickGetSet clsClickGetSet,
                   OnClickListenerSetting OnClickListenerSetting, int position) {
        OnClickListenerSetting.OnItemClick(clsClickGetSet, position);
    }
}
