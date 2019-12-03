package com.example.dependencyinjection.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {



    public NetworkManager(){

    }


    public Retrofit provideRetrofit(String url){
        return new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(provideRxJavaCallAdaptor())
                .addConverterFactory(provideConverterFactory())
                .client(provideHttpClient())
                .build();
    }

    private OkHttpClient provideHttpClient(){

        return new OkHttpClient.Builder()
                .addInterceptor(provideHttpInterceptor())
                .build();
    }

    private HttpLoggingInterceptor provideHttpInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        return interceptor ;
    }

    private GsonConverterFactory provideConverterFactory(){
        return GsonConverterFactory.create();
    }

    private RxJava2CallAdapterFactory provideRxJavaCallAdaptor(){
        return RxJava2CallAdapterFactory.create();
    }


}
