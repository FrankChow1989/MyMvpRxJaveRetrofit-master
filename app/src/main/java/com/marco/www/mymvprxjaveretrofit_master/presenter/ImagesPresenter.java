package com.marco.www.mymvprxjaveretrofit_master.presenter;

import com.marco.www.mymvprxjaveretrofit_master.api.RxService;
import com.marco.www.mymvprxjaveretrofit_master.domain.Images;
import com.marco.www.mymvprxjaveretrofit_master.ui.view.ImagesView;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pc on 2016/6/23.
 */
public class ImagesPresenter extends BasePresenter<ImagesView>
{
    @Override
    public void attachView(ImagesView mvpView)
    {
        super.attachView(mvpView);
    }

    @Override
    public void detachView()
    {
        super.detachView();
    }

    public void loadImage(final String page)
    {
        RxService
                .getImgApi().getImage(page)
                .subscribeOn(Schedulers.io())//在非UI线程中获取数据
                .observeOn(AndroidSchedulers.mainThread())//在UI线程中执行更新UI
                .subscribe(new Observer<List<Images>>()
                {
                    @Override
                    public void onCompleted()
                    {

                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        getMvpView().showError(null, null);
                    }

                    @Override
                    public void onNext(List<Images> images)
                    {

//                        for (int i = 0; i < images.size(); i++)
//                        {
//                            System.out.println(images.get(i).image);
//                        }
                        if (images != null)
                        {
                            getMvpView().refresh(images);
                        } else
                        {
                            getMvpView().loadMore(images);
                        }
                    }
                });
    }

}
