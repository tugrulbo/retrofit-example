package com.tugrulbo.retrofitexample.RestApi;


import com.tugrulbo.retrofitexample.Models.Posts;
import com.tugrulbo.retrofitexample.RestApi.BaseManager;
import retrofit2.Call;

import java.util.List;

public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance(){
        return ourInstance;
    }

    public Call<List<Posts>> getAllInfo(){
        Call<List<Posts>> call = getRestApiClient().callPosts();
        return call;

    }
}
