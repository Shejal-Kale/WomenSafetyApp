package com.example.application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class defenceAdapter extends RecyclerView.Adapter<defenceAdapter.ViewHolder>
{
    defenceData[] data;
    Context context;
    public defenceAdapter(defenceData[] data, Context context)
    {
        this.data=data;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.defence_items,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        final defenceData list=data[position];
        holder.icon.setImageResource(list.getIcon());
        holder.text.setText(list.getText());
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        pl.droidsonroids.gif.GifImageView icon;
        TextView text;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            icon=itemView.findViewById(R.id.image);
            text=itemView.findViewById(R.id.title);
        }
    }
}
