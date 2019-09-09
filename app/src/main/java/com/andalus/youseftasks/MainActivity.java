package com.andalus.youseftasks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.andalus.youseftasks.weather.WeatherResponse;
import com.edu.weatherapp.R;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText city_name = findViewById(R.id.city_name);
        Button go_button = findViewById(R.id.go_button);

        final UserClient userClient = Client.getService();
        go_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("VVVVVVVVVVVVV", "IIIIIIIIIIIIIIIIIIII");
                String cityName = city_name.getText().toString();
                userClient.getWeather(cityName, getString(R.string.key)).enqueue(new Callback<WeatherResponse>() {
                    TextView name = findViewById(R.id.name);
                    TextView temp = findViewById(R.id.temp);
                    TextView country = findViewById(R.id.country);

                    @Override
                    public void onResponse(@NotNull Call<WeatherResponse> call, @NotNull Response<WeatherResponse> response) {
                        if (response.body() != null) {
                            Log.d("XXXXXXXX", response.body().getName());
                            name.setText(String.valueOf(response.body().getName()));
                            temp.setText(String.valueOf(response.body().getMain().getTemp()));
                            country.setText(String.valueOf(response.body().getSys().getCountry()));
                        } else {
                            Log.d("KKKKKKKKKKKKKKK", "KKKKKKKKKKKKK");
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherResponse> call, Throwable t) {
                        Log.d("CCCCCCCCCCCCC", "MMMMMMMMMMMMMMMMMMMMMMM");
                    }
                });
            }
        });
    }
}
