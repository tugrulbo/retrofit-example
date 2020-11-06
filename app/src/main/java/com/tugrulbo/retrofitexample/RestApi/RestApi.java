package com.tugrulbo.retrofitexample.RestApi;

import com.tugrulbo.retrofitexample.Models.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {

    @GET("/posts")
    Call<List<Posts>> callPosts();

}
