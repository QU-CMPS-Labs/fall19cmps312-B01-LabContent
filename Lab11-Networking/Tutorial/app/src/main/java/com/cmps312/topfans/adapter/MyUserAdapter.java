package com.cmps312.topfans.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cmps312.topfans.R;
import com.cmps312.topfans.models.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyUserAdapter extends RecyclerView.Adapter<MyUserAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<User> users;

    public MyUserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.raw_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameTv.setText(users.get(position).getName().toString());
        holder.emailTv.setText(users.get(position).getEmail());
        holder.gender.setText(users.get(position).getGender());
        Picasso.get()
                .load(users.get(position).getPicture().getLarge())
                .into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    //Step 1: create the view holder
    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTv;
        private TextView emailTv;
        private TextView gender;
        private ImageView userImage;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name_tv);
            gender = itemView.findViewById(R.id.gender_tv);
            emailTv = itemView.findViewById(R.id.email_tv);
            userImage = itemView.findViewById(R.id.user_image);

        }
    }

}
