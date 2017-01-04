package com.web.sangsang.rest;

import java.util.List;

import com.web.sangsang.cmm.entity.BaseEntity;
import com.web.sangsang.cmm.entity.PageEntity;
import com.web.sangsang.cmm.entity.SsLogging;
import com.web.sangsang.cmm.entity.SsUser;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by pig on 2016. 12. 27..
 */

public interface RestService {
    @POST("/api/user/update")
    Call<SsUser> updateUser(@Body SsUser user);

    @GET("/api/user/find")
    Call<SsUser> findUser(@Query("sourceType") String sourceType, @Query("sourceId") String sourceId);

    @GET("/api/cmm/{tableName}/find")
    Call<BaseEntity> find(@Path("tableName") String tableName, @Query("id") Long id);

    @POST("/api/cmm/{tableName}/list")
    Call<List<BaseEntity>> list(@Path("tableName") String tableName, @Body PageEntity page);

    @POST("/api/history/push")
    Call<BaseEntity> pushHistory(@Body List<SsLogging> loggings);
}
