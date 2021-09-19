package com.example.bottomnavi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Player> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<Player> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    public CustomAdapter(ArrayList<Player> arrayList, BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.frag1,parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int pos) {
        Glide.with(holder.itemView)
                .load(arrayList.get(pos).getProfile())
                .into(holder.tv_profile);

        holder.tv_name.setText(arrayList.get(pos).getName());
        holder.tv_age.setText(arrayList.get(pos).getAge());
        holder.tv_country.setText(arrayList.get(pos).getCountry());
        holder.tv_apperances.setText(arrayList.get(pos).getApperances());
        holder.tv_total_goal.setText(arrayList.get(pos).getTotal_goal());
        holder.tv_position.setText(arrayList.get(pos).getPosition());

    }



    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        ImageView tv_profile;
        TextView tv_name;
        TextView tv_age;
        TextView tv_country;
        TextView tv_apperances;
        TextView tv_total_goal;
        TextView tv_position;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tv_profile = itemView.findViewById(R.id.tv_profile);
            this.tv_name = itemView.findViewById(R.id.tv_name);
            this.tv_age = itemView.findViewById(R.id.tv_age);
            this.tv_country = itemView.findViewById(R.id.tv_country);
            this.tv_apperances = itemView.findViewById(R.id.tv_apperances);
            this.tv_total_goal = itemView.findViewById(R.id.tv_total_goal);
            this.tv_position = itemView.findViewById(R.id.tv_position);

        }
    }
}
