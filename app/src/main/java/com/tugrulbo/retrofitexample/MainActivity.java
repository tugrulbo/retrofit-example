package com.tugrulbo.retrofitexample;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.tugrulbo.retrofitexample.Models.Posts;
import com.tugrulbo.retrofitexample.RestApi.*;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Posts> postsList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        request();

    }

    public void request(){

        postsList = new ArrayList<>();

        Call<List<Posts>> posts = ManagerAll.getInstance().getAllInfo();
        posts.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
              if ( response.isSuccessful()){
                    postsList = response.body();
                    CustomAdapter customAdapter = new CustomAdapter(postsList,getApplicationContext());
                    listView.setAdapter(customAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}