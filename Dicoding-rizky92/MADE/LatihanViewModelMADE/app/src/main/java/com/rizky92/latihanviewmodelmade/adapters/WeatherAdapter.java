package com.rizky92.latihanviewmodelmade.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rizky92.latihanviewmodelmade.R;
import com.rizky92.latihanviewmodelmade.models.Weathers;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private ArrayList<Weathers> list = new ArrayList<>();

    public void setList(ArrayList<Weathers> items) {
        list.clear();
        list.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvCity, tvTemp, tvDesc;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCity = itemView.findViewById(R.id.tv_city);
            tvTemp = itemView.findViewById(R.id.tv_temp);
            tvDesc = itemView.findViewById(R.id.tv_desc);
        }

        void bind(Weathers weathers) {
            tvCity.setText(weathers.getName());
            tvTemp.setText(weathers.getTemp());
            tvDesc.setText(weathers.getDesc());
        }
    }
}
