package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.retrofit.http.RetrofitUtil;
import com.example.retrofit.http.Service;
import com.example.retrofit.transfer.Personne;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvSimple = findViewById(R.id.tvSimple);
        TextView tvComplexe = findViewById(R.id.tvComplexe);

        Service service = RetrofitUtil.get();
        service.dbl("4").enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    String resultat = response.body();
                    tvSimple.setText("resultat double = " + resultat);
                } else {
                    Log.i("RETROFIT", response.code()+"");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("RETROFIT", t.getMessage());
            }
        });

        service.complexe("francois").enqueue(new Callback<Personne>() {
            @Override
            public void onResponse(Call<Personne> call, Response<Personne> response) {
                if(response.isSuccessful()){
                    Personne resultat = response.body();
                    tvComplexe.setText("a = " + resultat.a.toString() + "; b = " + resultat.b + "; c = " + resultat.c.toString());
                } else {
                    Log.i("RETROFIT", response.code()+"");
                }
            }

            @Override
            public void onFailure(Call<Personne> call, Throwable t) {
                Log.i("RETROFIT", t.getMessage());
            }
        });

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ExerciceListes.class);
                startActivity(i);
            }
        });
    }
}