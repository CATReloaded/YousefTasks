package com.andalus.youseftasks;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Item[] data;
    private LayoutInflater layoutInflater;

    public interface OnItemClickListener {
        void onItemClick(Item item);
    }

    private final OnItemClickListener listener;

    MyAdapter(Context context, Item[] data, OnItemClickListener listener) {
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.item_cell, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(data[i]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_image) ImageView image;
        @BindView(R.id.item_text) TextView text;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind (final Item item){
            text.setText(item.getText());
            image.setImageResource(item.getImage());
            itemView.setOnClickListener(view -> listener.onItemClick(item));
        }

    }

}
