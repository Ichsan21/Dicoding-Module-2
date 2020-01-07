package com.rizky92.latihanmylocalization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvHello = findViewById(R.id.tv_hello);
        TextView tvPlural = findViewById(R.id.tv_plural);
        TextView tvXliff = findViewById(R.id.tv_xliff);

        int poke = 21;
        String hello = String.format(getResources().getString(R.string.hello), "Muhammad Rizky Rizaldi", poke, "seseorang");
        tvHello.setText(hello);

        int song = 1;
        String plural = getResources().getQuantityString(R.plurals.song_num, song, song);
        tvPlural.setText(plural);

        tvXliff.setText(getResources().getString(R.string.url));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
