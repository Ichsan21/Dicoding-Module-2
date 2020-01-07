package com.rizky92.dicodingsubmissionv2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rizky92.dicodingsubmissionv2.model.Hape;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class RowAdapter extends RecyclerView.Adapter<RowAdapter.CardViewHolder> {
    private ArrayList<Hape> listHape;
    RowAdapter(ArrayList<Hape> list) { this.listHape = list; }

    @NonNull
    @Override
    public RowAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_xiaomi, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RowAdapter.CardViewHolder holder, int position) {
        final Hape hape = listHape.get(position);

        Glide.with(holder.itemView.getContext())
                .load(hape.getFoto())
                .apply(new RequestOptions()
                .override(60, 60))
                .into(holder.img);

        holder.tvNama.setText(hape.getNama());

        holder.tvPrice.setText(hape.getPrice());

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);

                Bitmap bmp = BitmapFactory.decodeResource(view.getResources(), hape.getFoto());
                ByteArrayOutputStream str = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.JPEG, 90, str);
                byte[] bArr = str.toByteArray();

                intent.putExtra(DetailActivity.EXTRA_IMG, bArr);

                intent.putExtra(DetailActivity.EXTRA_NAMA, hape.getNama());
                intent.putExtra(DetailActivity.EXTRA_PRICE, hape.getPrice());

                intent.putExtra(DetailActivity.EXTRA_ANNOUNCED, hape.getAnnounced());
                intent.putExtra(DetailActivity.EXTRA_STATUS, hape.getStatus());

                intent.putExtra(DetailActivity.EXTRA_DIMENSIONS, hape.getDimensions());
                intent.putExtra(DetailActivity.EXTRA_WEIGHT, hape.getWeight());
                intent.putExtra(DetailActivity.EXTRA_BUILD, hape.getBuild());
                intent.putExtra(DetailActivity.EXTRA_SIM, hape.getSim());

                intent.putExtra(DetailActivity.EXTRA_TYPE, hape.getType());
                intent.putExtra(DetailActivity.EXTRA_SIZE, hape.getSize());
                intent.putExtra(DetailActivity.EXTRA_RES, hape.getRes());

                intent.putExtra(DetailActivity.EXTRA_OS, hape.getOs());
                intent.putExtra(DetailActivity.EXTRA_CHIPSET, hape.getChipset());
                intent.putExtra(DetailActivity.EXTRA_CPU, hape.getCpu());
                intent.putExtra(DetailActivity.EXTRA_GPU, hape.getGpu());

                intent.putExtra(DetailActivity.EXTRA_RAM, hape.getRam());
                intent.putExtra(DetailActivity.EXTRA_INTERNAL, hape.getInternal());
                intent.putExtra(DetailActivity.EXTRA_EXTERNAL, hape.getExternal());

                intent.putExtra(DetailActivity.EXTRA_REARCAM, hape.getRearCam());
                intent.putExtra(DetailActivity.EXTRA_REARFEAT, hape.getRearFeat());
                intent.putExtra(DetailActivity.EXTRA_REARVIDEO, hape.getRearVideo());

                intent.putExtra(DetailActivity.EXTRA_FRONTCAM, hape.getFrontCam());
                intent.putExtra(DetailActivity.EXTRA_FRONTFEAT, hape.getFrontFeat());
                intent.putExtra(DetailActivity.EXTRA_FRONTVIDEO, hape.getFrontVideo());

                intent.putExtra(DetailActivity.EXTRA_SPEAKER, hape.getSpeaker());
                intent.putExtra(DetailActivity.EXTRA_JACK, hape.getJack());

                intent.putExtra(DetailActivity.EXTRA_WLAN, hape.getWlan());
                intent.putExtra(DetailActivity.EXTRA_BLUETOOTH, hape.getBluetooth());
                intent.putExtra(DetailActivity.EXTRA_RADIO, hape.getRadio());
                intent.putExtra(DetailActivity.EXTRA_NETWORK, hape.getNetwork());

                intent.putExtra(DetailActivity.EXTRA_USB, hape.getUsb());
                intent.putExtra(DetailActivity.EXTRA_SENSORS, hape.getSensors());
                intent.putExtra(DetailActivity.EXTRA_BATTERY, hape.getBattery());

                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return listHape.size(); }

    class CardViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvPrice;
        ImageView img;
        Button btnDetail;

        CardViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_item_foto);
            tvNama = itemView.findViewById(R.id.tv_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
            btnDetail = itemView.findViewById(R.id.btn_detail);
        }
    }
}
