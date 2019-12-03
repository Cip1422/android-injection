package com.example.dependencyinjection.di;

import com.example.dependencyinjection.data.RandomAPI;
import com.example.dependencyinjection.data.RandomService;
import com.example.dependencyinjection.network.NetworkManager;

public class Injector {

    public static RandomService provideService(){
        return new RandomService();
    }

    public static RandomAPI provideRandomAPI(){
       return provideNetwork().provideRetrofit(RandomAPI.BASE_URL)
       .create(RandomAPI.class);
    }

    public static NetworkManager provideNetwork(){

        return new NetworkManager();
    }

}
