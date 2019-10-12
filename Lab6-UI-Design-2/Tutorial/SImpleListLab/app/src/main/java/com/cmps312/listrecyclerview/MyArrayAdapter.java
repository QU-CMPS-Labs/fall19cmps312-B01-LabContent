package com.cmps312.listrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

class MyArrayAdapter extends ArrayAdapter<Country> {

    public MyArrayAdapter(@NonNull Context context, @NonNull ArrayList<Country> countries) {
        super(context, 0, countries);
    }

    public static class ViewHolder{
        TextView nameTv;
        ImageView flagTv;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder ;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false);

            holder = new ViewHolder();

            holder.nameTv = convertView.findViewById(R.id.name_tv);
            holder.flagTv = convertView.findViewById(R.id.flag_img);

            convertView.setTag(holder);

        }

        else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.nameTv.setText(getItem(position).getName());
        holder.flagTv.setImageResource(getItem(position).getFlag());

        holder.flagTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Country country = getItem(position);
                Intent intent = new Intent(getContext(), CountryDetails.class);

                intent.putExtra("country", country);
                getContext().startActivity(intent);
            }
        });

        return convertView;
    }
}
