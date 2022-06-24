package com.example.color.change.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.example.color.change.Classes.ClsClickGetSet;
import com.example.color.change.Classes.OnClickListenerSetting;
import com.example.color.change.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<ClsClickGetSet> lst = new ArrayList<>();
    Context mContext;
    private OnClickListenerSetting mOnClick;

    public RecyclerAdapter(List<ClsClickGetSet> lst, Context mContext) {
        this.lst = lst;
        this.mContext = mContext;
    }

    public void SetOnClickListener(OnClickListenerSetting mOnClick) {
        this.mOnClick = mOnClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @SuppressLint({"RecyclerView", "NewApi"})
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ClsClickGetSet myListData = lst.get(position);

        if(myListData.getColorValue().equalsIgnoreCase("red")){
            holder.buttons.setBackgroundColor(mContext.getColor(R.color.red));
        }else if(myListData.getColorValue().equalsIgnoreCase("green")){
            holder.buttons.setBackgroundColor(mContext.getColor(R.color.green));
        }else {
            holder.buttons.setBackgroundColor(mContext.getColor(R.color.bg));
        }
        holder.Bind(myListData, mOnClick, position);
    }

    @Override
    public int getItemCount() {
        return lst.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Button buttons;

        public ViewHolder(View itemView) {
            super(itemView);
            buttons = (Button) itemView.findViewById(R.id.button);
        }

        void Bind(ClsClickGetSet clsClickGetSet,
                  OnClickListenerSetting OnClickListenerSetting, int position) {
            buttons.setOnClickListener(v ->
                    OnClickListenerSetting.OnItemClick(clsClickGetSet, position));
        }
    }
}