package com.marco.www.mymvprxjaveretrofit_master.ui;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

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
        initDatas();
        loadData();
    }

    private void loadData()
    {
        imgsPresenter.loadImage(page);
    }

    private void initDatas()
    {
        imagesList = new ArrayList<>();
        imagesAdapter = new ImagesAdapter(context, imagesList);
        relativeLayout.setAdapter(imagesAdapter);
        imgsPresenter = new ImagesPresenter();
        imgsPresenter.attachView(this);
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
        layoutManager = new GridLayoutManager(context, 2);
        relativeLayout.setLayoutManager(layoutManager);
        relativeLayout.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST));
        relativeLayout.setLoadMoreListener(this);
    }

    @Override
    public void refresh(List<Images> data)
    {
        commonError.setVisibility(View.GONE);
        imagesList.clear();
        imagesList.addAll(data);
        imagesAdapter.notifyDataSetChanged();
        swipeRe.setRefreshing(false);
    }

    @Override
    public void loadMore(List<Images> data)
    {
        commonError.setVisibility(View.GONE);
        imagesList.addAll(data);
        imagesAdapter.notifyDataSetChanged();
        relativeLayout.setLoading(false);
    }

    @Override
    public void onRefresh()
    {
        page = "装逼";
        loadData();
    }

    @Override
    public void onLoadMore()
    {
        loadData();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        imgsPresenter.detachView();
    }
}
