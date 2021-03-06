package com.test.zzw.zzwapp;

import com.test.zzw.zzwapp.bean.LinkUser;
import com.test.zzw.zzwapp.bean.ResultHttp;
import com.test.zzw.zzwapp.bean.Version;
import com.test.zzw.zzwapp.httpentity.LoginRequest;
import com.test.zzw.zzwapp.httpentity.LoginResponse;
import com.test.zzw.zzwapp.httpentity.RegisterRequest;
import com.test.zzw.zzwapp.httpentity.RegisterResponse;
import com.test.zzw.zzwapp.httpentity.UserBaseInfoRequest;
import com.test.zzw.zzwapp.httpentity.UserBaseInfoResponse;
import com.test.zzw.zzwapp.httpentity.UserExtraInfoRequest;
import com.test.zzw.zzwapp.httpentity.UserExtraInfoResponse;

import org.json.JSONObject;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/6/7.
 */

public interface Api {
    @GET("api/user/checkversion")
    Observable<ResultHttp<Version>> getVersion();

    @POST("api/user/login")
    @FormUrlEncoded
    Observable<ResultHttp<LinkUser>> login(@Field("username") String phoneStr, @Field("password") String passwordStr);

    @GET("/")
    Observable<RegisterResponse> register(@Body RegisterRequest request);

    @GET("/")
    Observable<UserBaseInfoResponse> getUserBaseInfo(@Body UserBaseInfoRequest request);

    @GET("/")
    Observable<UserExtraInfoResponse> getUserExtraInfo(@Body UserExtraInfoRequest request);

    @GET("v2/movie/top250")
    Observable<Response<ResponseBody>> getTop250(@Query("start") int start, @Query("count") int count);
}
