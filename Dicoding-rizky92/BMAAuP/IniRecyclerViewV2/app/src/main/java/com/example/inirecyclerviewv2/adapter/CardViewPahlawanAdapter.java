package com.example.inirecyclerviewv2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.inirecyclerviewv2.R;
import com.example.inirecyclerviewv2.model.Pahlawan;

import java.util.ArrayList;

public class CardViewPahlawanAdapter extends RecyclerView.Adapter<CardViewPahlawanAdapter.CardViewHolder> {
    private ArrayList<Pahlawan> listPahlawan;

    public CardViewPahlawanAdapter(ArrayList<Pahlawan> list) { this.listPahlawan = list; }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_pahlawan, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, int position) {
        Pahlawan pahlawan = listPahlawan.get(position);

        Glide.with(holder.itemView.getContext())
                .load(pahlawan.getFoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgFoto);

        holder.tvNama.setText(pahlawan.getNama());
        holder.tvDetail.setText(pahlawan.getDetail());

        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(holder.itemView.getContext(), "Favorite = " + listPahlawan.get(holder.getAdapterPosition()).getNama(), Toast.LENGTH_SHORT).show();
           }
        });

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), "Share = " + listPahlawan.get(holder.getAdapterPosition()).getNama(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), "Kamu memilih: " +listPahlawan.get(holder.getAdapterPosition()).getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPahlawan.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoto;
        TextView tvNama, tvDetail;
        Button btnFavorite, btnShare;

        CardViewHolder(View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.img_item_photo);
            tvNama = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}
