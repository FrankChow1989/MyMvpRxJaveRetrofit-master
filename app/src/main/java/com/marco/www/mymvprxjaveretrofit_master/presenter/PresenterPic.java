package com.marco.www.mymvprxjaveretrofit_master.presenter;

import com.marco.www.mymvprxjaveretrofit_master.ui.view.MvpView;

/**
 * Created by pc on 2016/8/4.
 */
public interface PresenterPic<V extends MvpView>
{
    void attachView(V mvpView);

    void detachView();

    void startGetPicList(int page);
}
