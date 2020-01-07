package com.rizky92.latihanviewmodelmade.viewModels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.rizky92.latihanviewmodelmade.models.Weathers;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainViewModel extends ViewModel {
    private static final String API_KEY = "4fa6200b8a13bf783af96a104086d454";
    private MutableLiveData<ArrayList<Weathers>> listWeathers = new MutableLiveData<>();

    public LiveData<ArrayList<Weathers>> getListWeathers() {
        return listWeathers;
    }

    public void setListWeathers(final String cities) {
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<Weathers> list = new ArrayList<>();
        String url = "https://api.openweathermap.org/data/2.5/group?id=" + cities + "&units=metric&appid=" + API_KEY;

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject object = new JSONObject(result);
                    JSONArray array = object.getJSONArray("list");

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject weather = array.getJSONObject(i);

                        Weathers weathers = new Weathers();
                        weathers.setId(weather.getInt("id"));
                        weathers.setName(weather.getString("name"));
                        weathers.setCurWeather(weather.getJSONArray("weather").getJSONObject(0).getString("main"));
                        weathers.setDesc(weather.getJSONArray("weather").getJSONObject(0).getString("description"));

                        double tempK = weather.getJSONObject("main").getDouble("temp");
                        double tempC = tempK - 273;
                        weathers.setTemp(new DecimalFormat("##.##").format(tempC));

                        list.add(weathers);
                    }
                    listWeathers.postValue(list);
                } catch (Exception e) {
                    Log.d("Exception: ", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("Failure: ", error.getMessage());
            }
        });
    }
}
