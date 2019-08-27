package com.andalus.youseftasks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.edu.weatherapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText city_name = findViewById(R.id.city_name);
        Button go_button = findViewById(R.id.go_button);
        final UserClient userClient = Client.getService();
        final String cityName = city_name.getText().toString();
        go_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("VVVVVVVVVVVVV","IIIIIIIIIIIIIIIIIIII");
                userClient.getWeather(cityName,R.string.key).enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Call<Weather> call, Response<Weather> response) {
                        TextView name = findViewById(R.id.name);
                        TextView temp = findViewById(R.id.temp);
                        TextView country = findViewById(R.id.country);
                        if (response.body() != null) {
                            Log.d("XXXXXXXX",response.body().getName());
                            name.setText(String.valueOf(response.body().getName()));
                            temp.setText(String.valueOf(response.body().getMain().getTemp()));
                            country.setText(String.valueOf(response.body().getSys().getCountry()));
                        }
                        else
                        { Log.d("KKKKKKKKKKKKKKK","KKKKKKKKKKKKK"); }
                    }
                    @Override
                    public void onFailure(Call<Weather> call, Throwable t) {
                        Log.d("CCCCCCCCCCCCC","MMMMMMMMMMMMMMMMMMMMMMM"); }
                });
            }
        });
    }
}
