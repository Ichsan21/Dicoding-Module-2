package com.example.inirecyclerviewv2.adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.inirecyclerviewv2.R;
import com.example.inirecyclerviewv2.model.Pahlawan;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListPahlawanAdapter extends RecyclerView.Adapter<ListPahlawanAdapter.ListViewHolder> {
    private ArrayList<Pahlawan> listPahlawan;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListPahlawanAdapter(ArrayList<Pahlawan> list) {
        this.listPahlawan = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_pahlawan, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Pahlawan pahlawan = listPahlawan.get(position);

        Glide.with(holder.itemView.getContext())
                .load(pahlawan.getFoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgFoto);

        holder.tvNama.setText(pahlawan.getNama());
        holder.tvDetail.setText(pahlawan.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                onItemClickCallback.onItemClicked(listPahlawan.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPahlawan.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoto;
        TextView tvNama, tvDetail;

        ListViewHolder(View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.img_item_photo);
            tvNama = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Pahlawan data);
    }
}
