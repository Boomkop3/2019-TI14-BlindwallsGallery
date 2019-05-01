package com.appsfromholland.blindwallsgallery;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BlindwallsAdapter extends RecyclerView.Adapter<BlindwallsAdapter.BlindwallsViewHolder> {

    private ArrayList<Mural> dataset;

    public BlindwallsAdapter(ArrayList<Mural> dataset) {
        this.dataset = dataset;
    }

    public class BlindwallsViewHolder extends RecyclerView.ViewHolder {

        public TextView author;
        public ImageView imageView;

        public BlindwallsViewHolder(View itemView) {
            super(itemView);
            author = (TextView) itemView.findViewById(R.id.author_id);
            imageView = (ImageView) itemView.findViewById(R.id.mural_id);
        }
    }

    @NonNull
    @Override
    public BlindwallsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.mural_grid_item, parent, false);
        return new BlindwallsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlindwallsViewHolder holder, int position) {
        Mural mural = dataset.get(position);
        holder.author.setText(mural.getAuthor());
        Picasso.get()
                .load(mural.getImageUrl())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
