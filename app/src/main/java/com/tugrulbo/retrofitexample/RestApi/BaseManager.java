package com.tugrulbo.retrofitexample.RestApi;

public class BaseManager {
    protected RestApi getRestApiClient(){
        RestAPIClient restAPIClient = new RestAPIClient(BaseURL.site_URL);
        return restAPIClient.getRestApi();
    }
}
