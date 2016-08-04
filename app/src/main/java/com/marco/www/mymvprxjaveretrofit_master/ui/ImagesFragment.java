package com.marco.www.mymvprxjaveretrofit_master.ui;

import android.os.Bundle;
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
import com.marco.www.mymvprxjaveretrofit_master.domain.Images;
import com.marco.www.mymvprxjaveretrofit_master.presenter.ImagesPresenter;
import com.marco.www.mymvprxjaveretrofit_master.ui.adapter.ImagesAdapter;
import com.marco.www.mymvprxjaveretrofit_master.ui.view.ImagesView;

import java.util.ArrayList;
import java.util.List;

public class ImagesFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, ImagesView, AutoLoadRecylerView.loadMoreListener
{

    SwipeRefreshLayout swipeRe;
    AutoLoadRecylerView relativeLayout;
    private ImagesPresenter imgsPresenter;
    private LinearLayoutManager layoutManager;
    private String page = "装逼";
    private List<Images> imagesList;
    private ImagesAdapter imagesAdapter;
    private RelativeLayout commonError;
    private Button bt_retry;

    @Override
    protected int getLayoutResource()
    {
        return R.layout.fragment_images;
    }

    @Override
    protected void initData()
    {
        imagesList = new ArrayList<>();
        imgsPresenter = new ImagesPresenter(this);
        imgsPresenter.attachView(this);
        imgsPresenter.startGetImageList(page);
    }

    @Override
    protected void initView()
    {
        swipeRe = (SwipeRefreshLayout) context.findViewById(R.id.swipe_refreshlayout_img);
        relativeLayout = (AutoLoadRecylerView) context.findViewById(R.id.recycler_view_img);
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

    }

    @Override
    public void hideLoading()
    {
    }

    @Override
    public void onRefresh()
    {
        page = "装逼";
        imgsPresenter.startGetImageList(page);
    }

    @Override
    public void onLoadMore()
    {
        imgsPresenter.startGetImageList(page);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        imgsPresenter.detachView();
    }

    @Override
    public void receiveImageList(List<Images> imageListDomains)
    {
        if (null == imageListDomains || imageListDomains.size() == 0) {
            Toast.makeText(context, "没有发现更多数据", Toast.LENGTH_SHORT).show();
            return;
        }
        imagesList = imageListDomains;
        layoutManager = new GridLayoutManager(context, 2);
        relativeLayout.setLayoutManager(layoutManager);
        relativeLayout.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST));
        relativeLayout.setLoadMoreListener(this);
        imagesAdapter = new ImagesAdapter(context, imagesList);
        relativeLayout.setAdapter(imagesAdapter);
    }
}
