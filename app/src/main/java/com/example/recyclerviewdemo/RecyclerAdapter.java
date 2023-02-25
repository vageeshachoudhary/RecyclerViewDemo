package com.example.recyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] titles = {"Chapter One","Chapter Two","Chapter Three",
                               "Chapter Four","Chapter Five","Chapter Six",
                               "Chapter Seven","Chapter Eight"};

    private String[] details = {"Item one Details","Item two Details","Item three Details",
                                "Item four Details","Item five Details","Item six Details",
                                "Item seven Details","Item eight Details"};

    private int[] images = { R.drawable.android_image_1,R.drawable.android_image_2,R.drawable.android_image_3,
                             R.drawable.android_image_4,R.drawable.android_image_5,R.drawable.android_image_6,
                             R.drawable.android_image_7,R.drawable.android_image_8,};
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemImage.setImageResource(images[i]);
        viewHolder.itemDetail.setText(details[i]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView itemImage;
        TextView itemTitle;
        TextView itemDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Snackbar.make(v,"Click detected on item " + position,Snackbar.LENGTH_LONG)
                            .setAction("Action",null).show();
                }
            });
        }
    }
}
