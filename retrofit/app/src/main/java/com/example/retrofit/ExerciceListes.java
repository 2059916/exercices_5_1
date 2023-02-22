package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofit.http.RetrofitUtil;
import com.example.retrofit.http.Service;
import com.example.retrofit.transfer.Personne;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExerciceListes extends AppCompatActivity {

    private ListAdapter listAdapter;
    private ListAdapter listAdapterPersonne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_listes);

        this.initRecycler();
        this.remplirRecycler();
    }

    private void initRecycler(){
        RecyclerView recyclerViewLong = findViewById(R.id.rvLong);
        recyclerViewLong.setHasFixedSize(true);

        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerViewLong.setLayoutManager(layoutManager);

        listAdapter = new ListAdapter();
        recyclerViewLong.setAdapter(listAdapter);

        RecyclerView recyclerViewPersonne = findViewById(R.id.rvLong);
        recyclerViewPersonne.setHasFixedSize(true);
        recyclerViewPersonne.setLayoutManager(layoutManager);
        listAdapterPersonne = new ListAdapter();
        recyclerViewPersonne.setAdapter(listAdapterPersonne);

    }

    private void remplirRecycler(){
        listAdapter.list.clear();
        Service service = RetrofitUtil.get();
        service.longList().enqueue(new Callback<List<Long>>() {
            @Override
            public void onResponse(Call<List<Long>> call, Response<List<Long>> response) {
                if(response.isSuccessful()){
                    List<Long> resultat = response.body();
                    listAdapter.list = Collections.singletonList(resultat);
                } else {
                    Log.i("RETROFIT", response.code()+"");
                }
            }

            @Override
            public void onFailure(Call<List<Long>> call, Throwable t) {
                Log.i("RETROFIT", t.getMessage());
            }
        });

        service.personneList().enqueue(new Callback<List<Personne>>() {
            @Override
            public void onResponse(Call<List<Personne>> call, Response<List<Personne>> response) {
                if(response.isSuccessful()){
                    List<Personne> resultat = response.body();
                    listAdapterPersonne.list = Collections.singletonList(resultat);
                } else {
                    Log.i("RETROFIT", response.code()+"");
                }
            }

            @Override
            public void onFailure(Call<List<Personne>> call, Throwable t) {
                Log.i("RETROFIT", t.getMessage());
            }
        });
    }
}