package com.cmps312.topfans.httpRequests;

import com.cmps312.topfans.models.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UsersClient {

    String BASE_URL = "https://randomuser.me";

    @GET("/api/")
    Call<Result> getUsers(@Query("results") String results ,
                          @Query("format") String format);
}
