package com.example.dependencyinjection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.dependencyinjection.data.RandomService;
import com.example.dependencyinjection.di.Injector;
import com.example.dependencyinjection.model.RandomUser;

public class MainActivity extends AppCompatActivity implements RandomService.Callback {

    private RandomService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



 manual-injection
        service = Injector.provideService();
        service.RandomUser(this);


    }

    @Override
    public void onRandomUser(RandomUser user) {
        Log.d("SOL_BAD", "onRandomUser: " + user);
    }

    @Override
    public void onError(String error) {
        Log.d("SOL_BAD", "Bad news jack: " + error);


    }
}
