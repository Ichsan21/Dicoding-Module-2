package com.rizky92.latihanviewmodelmade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.rizky92.latihanviewmodelmade.adapters.WeatherAdapter;
import com.rizky92.latihanviewmodelmade.models.Weathers;
import com.rizky92.latihanviewmodelmade.viewModels.MainViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtCity;
    ProgressBar progressBar;
    Button btnCity;
    WeatherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCity = findViewById(R.id.edt_city);
        progressBar = findViewById(R.id.progress_bar);
        btnCity = findViewById(R.id.btnCity);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WeatherAdapter();
        adapter.notifyDataSetChanged();

        recyclerView.setAdapter(adapter);

        final MainViewModel mainViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MainViewModel.class);

        btnCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = edtCity.getText().toString();

                if (TextUtils.isEmpty(city)) return;

                mainViewModel.setListWeathers(city);
                showLoading(true);
            }
        });

        mainViewModel.getListWeathers().observe(this, new Observer<ArrayList<Weathers>>() {
            @Override
            public void onChanged(ArrayList<Weathers> weathers) {
                if (weathers != null) {
                    adapter.setList(weathers);
                    showLoading(false);
                }
            }
        });
    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
