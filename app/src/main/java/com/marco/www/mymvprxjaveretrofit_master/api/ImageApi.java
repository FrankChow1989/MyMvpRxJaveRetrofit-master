package com.marco.www.mymvprxjaveretrofit_master.api;


import com.marco.www.mymvprxjaveretrofit_master.domain.Images;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by pc on 2016/6/23.
 */
public interface ImageApi
{
    @GET("search")
    Observable<List<Images>> getImage(@Query("q") String query);
}
