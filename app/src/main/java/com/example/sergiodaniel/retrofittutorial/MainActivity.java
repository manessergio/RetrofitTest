package com.example.sergiodaniel.retrofittutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonGet);
        textView = findViewById(R.id.textViewResponse);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IWeather client = ServiceGenerator.createService(IWeather.class);
                Call<Weather> call = client.call(-62.2833,-38.7167);

                call.enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Call<Weather> call, Response<Weather> response) {
                        textView.setText(response.body().getTimezone()+" "+response.body().getLongitude()+" "+ response.body().getLatitude());

                    }

                    @Override
                    public void onFailure(Call<Weather> call, Throwable t) {
                        textView.setText(t.getMessage());
                    }
                });
            }
        });
    }
}
