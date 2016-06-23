package com.marco.www.mymvprxjaveretrofit_master.api;

import com.marco.www.mymvprxjaveretrofit_master.util.Constants;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SkyEyesStion on 2016/2/26.
 */
public class RxService
{
    private static final String BASETESTURL = "http://apis.baidu.com/showapi_open_bus/";
    private static final String BASETESTURL_IMGS = "http://zhuangbi.info/";
    //private static OkHttpClient okHttpClient = new OkHttpClient();
//    private static Retrofit retrofit = new Retrofit.Builder().baseUrl(BASETESTURL).client(okHttpClient)
//            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava适配器
//            .addConverterFactory(GsonConverterFactory.create())//Gson转换器
//            .build();

//    private static Retrofit retrofit_imgs = new Retrofit.Builder().baseUrl(BASETESTURL_IMGS).client(okHttpClient)
//            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava适配器
//            .addConverterFactory(GsonConverterFactory.create())//Gson转换器
//            .build();

//    public static <T> T createApi(Class<T> clazz)
//    {
//        return retrofit.create(clazz);
//    }

//    public static <T> T createApi_img(Class<T> clazz)
//    {
//        return retrofit_imgs.create(clazz);
//    }

    private static JokeApi mJokeApi;
    private static ImageApi mImageApi;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();


    public static JokeApi getJokeApi()
    {
        if (mJokeApi == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASETESTURL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            mJokeApi = retrofit.create(JokeApi.class);
        }
        return mJokeApi;
    }

    public static ImageApi getImgApi()
    {
        if (mImageApi == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASETESTURL_IMGS)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            mImageApi = retrofit.create(ImageApi.class);
        }
        return mImageApi;
    }

}
