package com.cmps312.listrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    private Context context;
    private  ArrayList<Country> countries;

    public MyRecyclerAdapter(Context context, ArrayList<Country> countries) {
        this.context = context;
        this.countries = countries;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(context)
                .inflate(R.layout.list_item, parent, false);

        return new ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {


        holder.nameTv.setText(countries.get(position).getName());
        holder.flagTv.setImageResource(countries.get(position).getFlag());

        holder.flagTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Country country = countries.get(position);
                Intent intent = new Intent(context, CountryDetails.class);

                intent.putExtra("country", country);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTv;
        ImageView flagTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            flagTv = itemView.findViewById(R.id.flag_img);
            nameTv = itemView.findViewById(R.id.name_tv);
        }
    }
}
