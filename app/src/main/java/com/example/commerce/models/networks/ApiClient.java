package com.example.commerce.models.networks;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hamdhanywijaya@gmail.com on 02/02/18.
 */

public class ApiClient {
    public static final String BASE_URL = "http://projects.wision.id/sispet/public/api/";
    private static Retrofit retrofit = null;

    public static final String ASSETS_URL = "http://projects.wision.id/sispet/public/uploads/";



    public static Retrofit getClient() {
        if (retrofit==null) {

            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request.Builder ongoing = chain.request().newBuilder();

//                    UserSession userSession = UserSession.getInstance();
//                    if (userSession.getUserToken() != null) {
//                        ongoing.addHeader("Authorization", "Bearer " + userSession.getUserToken());
//                    }

                    return chain.proceed(ongoing.build());
                }
            }).build();

            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
