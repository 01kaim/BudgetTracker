package com.nkdev.budgettracker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.nkdev.budgettracker.R;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyHolder>{
    public AppCompatActivity context;

    ArrayList<String> data;
    int []images;
    public ItemAdapter(AppCompatActivity context,ArrayList<String>data,  int []images) {
        this.context=context;
        this.data=data;
        this.images=images;

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.new_item_list,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.textView.setText(data.get(position));
        holder.imageView.setImageResource(images[position]);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class  MyHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.id_txt_test);
            imageView=itemView.findViewById(R.id.id_image);
        }
    }
}
