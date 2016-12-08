package com.marco.www.mymvprxjaveretrofit_master.presenter;

import android.util.Log;
import android.view.View;

import com.marco.www.mymvprxjaveretrofit_master.api.JokeApi;
import com.marco.www.mymvprxjaveretrofit_master.api.RxService;
import com.marco.www.mymvprxjaveretrofit_master.domain.ContentlistEntity;
import com.marco.www.mymvprxjaveretrofit_master.domain.Images;
import com.marco.www.mymvprxjaveretrofit_master.domain.JokeEntity;
import com.marco.www.mymvprxjaveretrofit_master.model.ImageListModelImpl;
import com.marco.www.mymvprxjaveretrofit_master.model.PicListModel;
import com.marco.www.mymvprxjaveretrofit_master.model.PicListModelImpl;
import com.marco.www.mymvprxjaveretrofit_master.ui.view.ImagesView;
import com.marco.www.mymvprxjaveretrofit_master.ui.view.PicView;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by JDD on 2016/4/21 0021.
 */
public class JokePresenter implements PresenterPic<PicView>, PicListModelImpl.GetPicListenter
{

    PicView picView;
    PicListModel picListModel;

    public JokePresenter(PicView picView)
    {
        this.picView = picView;
        this.picListModel = new PicListModelImpl();
    }


    @Override
    public void startGetPicList(int page)
    {
        picView.showLoading("请稍后...");
        picListModel.GetPicList(page, this);
    }

    @Override
    public void onSuccess(List<ContentlistEntity> picList)
    {
        picView.receivePicList(picList);
        picView.hideLoading();
    }

    @Override
    public void OnError(Exception e)
    {

    }

    @Override
    public void attachView(PicView mvpView)
    {

    }

    @Override
    public void detachView()
    {

    }
}
