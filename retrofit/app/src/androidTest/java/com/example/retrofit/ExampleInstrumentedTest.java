package com.example.retrofit;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.retrofit.http.RetrofitUtil;
import com.example.retrofit.http.Service;
import com.example.retrofit.transfer.Personne;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws IOException {
        // Context of the app under test.
        Service service = RetrofitUtil.get();
        Call<String> call = service.dbl("4");
        Response<String> response = call.execute();
        String resultat = response.body();
        Log.i("RETROFIT", resultat);
    }

    @Test
    public void useAppContex() throws IOException {
        // Context of the app under test.
        Service service = RetrofitUtil.get();
        Call<Personne> call = service.complexe("bob");
        Response<Personne> response = call.execute();
        Personne resultat = response.body();
        Log.i("RETROFIT", resultat.b);
    }
}