package com.example.retrofit.http;

import com.example.retrofit.transfer.Personne;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service {

    @GET("exos/long/double/{nombre}")
    Call<String> dbl(@Path("nombre") String nombre);
    @GET("exos/truc/complexe")
    Call<Personne> complexe(@Query("name") String nom);

    @GET("exos/long/list")
    Call<List<Long>> longList();

    @GET("exos/truc/list")
    Call<List<Personne>> personneList();

}
