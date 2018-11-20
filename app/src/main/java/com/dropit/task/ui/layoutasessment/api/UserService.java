package com.dropit.task.ui.layoutasessment.api;

import com.dropit.task.ui.layoutasessment.models.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Priyank Jain on 20-11-2018.
 */
public interface UserService {

    @GET("users")
    Call<Result> getUserData(
            @Query("offset") int offset,
            @Query("limit") int limit
    );

}

