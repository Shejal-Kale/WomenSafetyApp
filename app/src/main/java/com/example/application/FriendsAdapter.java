package com.example.application;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import static android.content.ContentValues.TAG;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder>
{
    Context context;
    List<FriendsData> data;

    public FriendsAdapter(Context context, List data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.friends_items,parent,false);
        FriendsAdapter.ViewHolder viewHolder=new FriendsAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        final FriendsData list= data.get(position);
        holder.name.setText(list.getContactName());
        holder.no.setText(list.getContactNo());
        holder.image.setImageResource(list.getIcon());
        holder.delete.setImageResource(list.getDel());
        holder.send.setImageResource(list.getSend());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String str=holder.name.getText().toString();
                delete(str);
            }
        });
        holder.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String no=holder.no.getText().toString();
                String msg = "I am in trouble. Please contact me..";
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(no, null, msg, null, null);
                Toast.makeText(context,"Message Sent",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    public void delete(String str)
    {
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference data=FirebaseDatabase.getInstance().getReference("Contacts").child(user.getUid());
        Query q=data.orderByChild("ContactName").equalTo(str);
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                for (DataSnapshot s: dataSnapshot.getChildren())
                {
                    s.getRef().setValue(null);
                    Toast.makeText(context,"Deleted..",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        TextView no;
        ImageView image;
        ImageView delete;
        ImageView send;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.Cname);
            no=itemView.findViewById(R.id.Cno);
            image=itemView.findViewById(R.id.image);
            delete=itemView.findViewById(R.id.delete);
            send=itemView.findViewById(R.id.send);
        }
    }
}
