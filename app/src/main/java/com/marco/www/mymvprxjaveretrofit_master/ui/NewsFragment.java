package com.marco.www.mymvprxjaveretrofit_master.ui;

import android.app.Dialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.marco.www.mymvprxjaveretrofit_master.BaseFragment;
import com.marco.www.mymvprxjaveretrofit_master.R;
import com.marco.www.mymvprxjaveretrofit_master.common.AutoLoadRecylerView;
import com.marco.www.mymvprxjaveretrofit_master.common.DividerItemDecoration;
import com.marco.www.mymvprxjaveretrofit_master.domain.ContentlistEntity;
import com.marco.www.mymvprxjaveretrofit_master.presenter.JokePresenter;
import com.marco.www.mymvprxjaveretrofit_master.ui.adapter.JokeAdapter;
import com.marco.www.mymvprxjaveretrofit_master.ui.view.PicView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2016/6/22.
 */
public class NewsFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, PicView, AutoLoadRecylerView.loadMoreListener
{

    SwipeRefreshLayout swipeRe;
    AutoLoadRecylerView relativeLayout;

    private JokePresenter jokePresenter;
    private LinearLayoutManager layoutManager;
    private int page = 1;
    private List<ContentlistEntity> jokeList;
    private JokeAdapter jokeAdapter;
    private RelativeLayout commonError;
    private Button bt_retry;

    Dialog mDialog;

    @Override
    protected int getLayoutResource()
    {
        return R.layout.news_fragment;
    }

    @Override
    protected void initData()
    {
        jokeList = new ArrayList<>();
        jokePresenter = new JokePresenter(this);
        jokePresenter.attachView(this);
        jokePresenter.startGetPicList(page);
    }

    @Override
    protected void initView()
    {
        swipeRe = (SwipeRefreshLayout) context.findViewById(R.id.swipe_refreshlayout);
        relativeLayout = (AutoLoadRecylerView) context.findViewById(R.id.recycler_view);
        commonError = (RelativeLayout) context.findViewById(R.id.common_error);
        bt_retry = (Button) context.findViewById(R.id.retry_btn);
        bt_retry.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onRefresh();
            }
        });
        swipeRe.setOnRefreshListener(this);
    }

    @Override
    public void showLoading(String msg)
    {
//        mDialog = new Dialog(context);
//        mDialog.setContentView(R.layout.loading);
//        mDialog.show();
    }

    @Override
    public void hideLoading()
    {
        //mDialog.dismiss();
    }

    @Override
    public void onRefresh()
    {
        page = 1;
        jokePresenter.startGetPicList(page);
    }

    @Override
    public void onLoadMore()
    {
        jokePresenter.startGetPicList(page);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        jokePresenter.detachView();
    }

    @Override
    public void receivePicList(List<ContentlistEntity> imageListDomains)
    {
        if (null == imageListDomains || imageListDomains.size() == 0) {
            Toast.makeText(context, "没有发现更多数据", Toast.LENGTH_SHORT).show();
            return;
        }
        jokeList = imageListDomains;
        layoutManager = new LinearLayoutManager(context);
        relativeLayout.setLayoutManager(layoutManager);
        relativeLayout.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST));
        relativeLayout.setLoadMoreListener(this);
        jokeAdapter = new JokeAdapter(jokeList);
        relativeLayout.setAdapter(jokeAdapter);
    }
}
