package com.marco.www.mymvprxjaveretrofit_master.presenter;

import com.marco.www.mymvprxjaveretrofit_master.ui.view.MvpView;

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
