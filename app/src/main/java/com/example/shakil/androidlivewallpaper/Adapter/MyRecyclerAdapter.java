package com.example.shakil.androidlivewallpaper.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shakil.androidlivewallpaper.Common.Common;
import com.example.shakil.androidlivewallpaper.Database.Recents;
import com.example.shakil.androidlivewallpaper.Interface.ItemClickListener;
import com.example.shakil.androidlivewallpaper.ListWallpaper;
import com.example.shakil.androidlivewallpaper.Model.WallpaperItem;
import com.example.shakil.androidlivewallpaper.R;
import com.example.shakil.androidlivewallpaper.ViewHolder.ListWallpaperViewHolder;
import com.example.shakil.androidlivewallpaper.ViewWallpaper;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Shakil on 3/20/2018.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<ListWallpaperViewHolder> {

    private Context context;
    private List<Recents> recents;

    public MyRecyclerAdapter(Context context, List<Recents> recents) {
        this.context = context;
        this.recents = recents;
    }

    @NonNull
    @Override
    public ListWallpaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_wallpaper_item, parent, false);

        int height = parent.getMeasuredHeight()/2;
        itemView.setMinimumHeight(height);
        return new ListWallpaperViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListWallpaperViewHolder holder, final int position) {
        Picasso.with(context).load(recents.get(position).getImageUrl()).networkPolicy(NetworkPolicy.OFFLINE)
                .into(holder.wallpaper, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        Picasso.with(context).load(recents.get(position).getImageUrl()).error(R.drawable.ic_terrain_black_24dp)
                                .into(holder.wallpaper, new Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError() {
                                        Log.e("ERROR", "Couldn't fetch image");
                                    }
                                });
                    }
                });

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(context, ViewWallpaper.class);
                WallpaperItem wallpaperItem = new WallpaperItem();
                wallpaperItem.setCategoryId(recents.get(position).getCategoryId());
                wallpaperItem.setImageUrl(recents.get(position).getImageUrl());
                Common.select_background = wallpaperItem;
                Common.select_background_key = recents.get(position).getKey();
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recents.size();
    }
}
