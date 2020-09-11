package com.example.shayriapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayriapp.categories.Attitude;
import com.example.shayriapp.categories.BestWishes;
import com.example.shayriapp.categories.Birthday;
import com.example.shayriapp.categories.Couple;
import com.example.shayriapp.categories.Friendship;
import com.example.shayriapp.categories.Funny;
import com.example.shayriapp.categories.GOD;
import com.example.shayriapp.categories.GoodMorning;
import com.example.shayriapp.categories.GoodNight;
import com.example.shayriapp.categories.Love;
import com.example.shayriapp.categories.Romantic;
import com.example.shayriapp.categories.ValentineDay;

import java.util.ArrayList;

public class MyAdapter  extends RecyclerView.Adapter<MyHolder> {

    private Context c;
    private ArrayList<Model> models;


    public MyAdapter(Context c, ArrayList<Model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_item, null);
        return new MyHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        // create bind view/data
        holder.img.setImageResource(models.get(position).getImage());
        holder.modelTitle.setText(models.get(position).getTitle());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                switch(models.get(pos).getTitle()){
                    case "Good Morning": {
                        Intent intent = new Intent(c, GoodMorning.class);
                        c.startActivity(intent);
                        break;
                    }



                    case "Good Night": {
                        Intent intent = new Intent(c, GoodNight.class);
                        c.startActivity(intent);
                        break;
                    }





                    case "Love": {
                        Intent intent = new Intent(c, Love.class);
                        c.startActivity(intent);
                        break;
                    }




                    case "Romantics": {
                        Intent intent = new Intent(c, Romantic.class);
                        c.startActivity(intent);
                        break;
                    }



                    case "Couple": {
                        Intent intent = new Intent(c, Couple.class);
                        c.startActivity(intent);
                        break;
                    }



                    case "Valentine Day": {
                        Intent intent = new Intent(c, ValentineDay.class);
                        c.startActivity(intent);
                        break;
                    }



                    case "Friendship": {
                        Intent intent = new Intent(c, Friendship.class);
                        c.startActivity(intent);
                        break;
                    }


                    case "Birthday": {
                        Intent intent = new Intent(c, Birthday.class);
                        c.startActivity(intent);
                        break;
                    }


                    case "Funny": {
                        Intent intent = new Intent(c, Funny.class);
                        c.startActivity(intent);
                        break;
                    }


                    case "Best Wishes": {
                        Intent intent = new Intent(c, BestWishes.class);
                        c.startActivity(intent);
                        break;
                    }


                    case "GOD": {
                        Intent intent = new Intent(c, GOD.class);
                        c.startActivity(intent);
                        break;
                    }

                    case "Attitude": {
                        Intent intent = new Intent(c, Attitude.class);
                        c.startActivity(intent);
                        break;
                    }





                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
