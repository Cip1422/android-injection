package com.example.dependencyinjection.data;

import com.example.dependencyinjection.model.RandomUser;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface RandomAPI {

    @GET("api")
    Single<RandomUser> getRandomUser();

    String BASE_URL = "https://randomuser.me/";
}
