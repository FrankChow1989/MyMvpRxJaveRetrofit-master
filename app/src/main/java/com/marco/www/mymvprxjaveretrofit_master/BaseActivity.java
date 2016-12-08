package com.marco.www.mymvprxjaveretrofit_master;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.marco.www.mymvprxjaveretrofit_master.ui.view.MvpView;

/**
 * Created by pc on 2016/8/4.
 */
public abstract class BaseActivity extends AppCompatActivity implements MvpView
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setContentView(getLayoutResource());
        initView();
        initData();
        super.onCreate(savedInstanceState);
    }

    protected abstract int getLayoutResource();
    protected abstract void initData();
    protected abstract void initView();

    @Override
    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
    }

    public void onPause()
    {
        super.onPause();
    }


    @Override
    public void showLoading(String msg)
    {

    }

    @Override
    public void hideLoading()
    {

    }

    @Override
    public void showError(String msg, View.OnClickListener onClickListener)
    {

    }

    @Override
    public void showEmpty(String msg, View.OnClickListener onClickListener)
    {

    }

    @Override
    public void showEmpty(String msg, View.OnClickListener onClickListener, int imageId)
    {

    }

    @Override
    public void showNetError(View.OnClickListener onClickListener)
    {

    }
}
