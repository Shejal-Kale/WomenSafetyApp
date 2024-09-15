package com.example.application;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.core.content.ContextCompat.startActivity;

public class EmergencyNumbersAdapter extends RecyclerView.Adapter<EmergencyNumbersAdapter.ViewHolder>
{
    EmergencyNumbersData[] data;
    Context context;
    public EmergencyNumbersAdapter(EmergencyNumbersData[] data,EmergencyNumbersActivity activity)
    {
        this.data=data;
        this.context=activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.emergency_numbers_items,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final EmergencyNumbersData list=data[position];
        holder.name.setText(list.getText());
        holder.no.setText(list.getNo());
        holder.icon.setImageResource(list.getIcon());
        holder.no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                CallFunction call=new CallFunction(context);
                call.callMethod(list.getNo());
            }

        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView icon;
        TextView name;
        Button no;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            icon=itemView.findViewById(R.id.image);
            name=itemView.findViewById(R.id.text);
            no=itemView.findViewById(R.id.no);

        }
    }

}
