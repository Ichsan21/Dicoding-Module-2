package com.example.inirecyclerviewv2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.inirecyclerviewv2.R;
import com.example.inirecyclerviewv2.model.Pahlawan;

import java.util.ArrayList;

public class GridPahlawanAdapter extends RecyclerView.Adapter<GridPahlawanAdapter.GridViewHolder> {
    private ArrayList<Pahlawan> listPahlawan;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public GridPahlawanAdapter(ArrayList<Pahlawan> list) {
        this.listPahlawan = list;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_pahlawan, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listPahlawan.get(position).getFoto())
                .apply(new RequestOptions().override(350,350))
                .into(holder.imgFoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onItemClickCallback.OnItemClicked(listPahlawan.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPahlawan.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoto;

        GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.img_item_photo);
        }
    }

    public interface OnItemClickCallback {
        void OnItemClicked(Pahlawan data);
    }
}
