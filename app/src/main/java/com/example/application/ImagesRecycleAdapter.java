package com.example.application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ImagesRecycleAdapter extends RecyclerView.Adapter<ImagesRecycleAdapter.MyViewHolder>
{
    private List<ImageList> imageList;
    Context context;

    public ImagesRecycleAdapter(List<ImageList> imageList, Context context)
    {
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        Glide.with(context).load(imageList.get(position).getImageURL()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                FirebaseUser firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
                DatabaseReference userReference= FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());
                HashMap<String,Object> hashMap=new HashMap<>();
                hashMap.put("imageUrl",imageList.get(position).getImageURL());
                userReference.updateChildren(hashMap);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder
    {
        CircleImageView imageView;
        MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imageView=itemView.findViewById(R.id.profileImage);
        }
    }
}
