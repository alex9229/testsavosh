package almik.testsavosh.utill;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alex on 07.12.16.
 */

public class restUtill {
    public void retro(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://assistant-service.herokuapp.com/api-full/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        APIService apiService =
                retrofit.create(APIService.class);
        Call<bug> call = apiService.getBug();
        call.enqueue(new Callback<bug>() {
            @Override
            public void onResponse(Call<bug> call, Response<bug> response) {
                if (response.body()!=null){
                    Log.d("test1",call.toString());

                Log.d("test1",response.body().toString());}
            }

            @Override
            public void onFailure(Call<bug> call, Throwable t) {
                Log.d("test1",t.toString());

            }
        });
    }
}
