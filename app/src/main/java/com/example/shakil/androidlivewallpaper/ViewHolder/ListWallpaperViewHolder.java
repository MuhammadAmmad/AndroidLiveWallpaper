package com.example.shakil.androidlivewallpaper.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.shakil.androidlivewallpaper.Interface.ItemClickListener;
import com.example.shakil.androidlivewallpaper.R;

/**
 * Created by Shakil on 3/19/2018.
 */

public class ListWallpaperViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView wallpaper;

    ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public ListWallpaperViewHolder(View itemView) {
        super(itemView);
        wallpaper = itemView.findViewById(R.id.image);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition());
    }
}
