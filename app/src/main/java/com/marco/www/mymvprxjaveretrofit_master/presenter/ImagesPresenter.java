package com.marco.www.mymvprxjaveretrofit_master.presenter;

import com.marco.www.mymvprxjaveretrofit_master.domain.Images;
import com.marco.www.mymvprxjaveretrofit_master.model.ImageListModel;
import com.marco.www.mymvprxjaveretrofit_master.model.ImageListModelImpl;
import com.marco.www.mymvprxjaveretrofit_master.ui.view.ImagesView;

import java.util.List;

/**
 * Created by pc on 2016/6/23.
 */
public class ImagesPresenter implements PresenterImage<ImagesView>, ImageListModelImpl.GetImageListenter
{

    private ImagesView imagesView;
    private ImageListModel imageListModel;

    public ImagesPresenter(ImagesView imagesView)
    {
        this.imagesView = imagesView;
        this.imageListModel = new ImageListModelImpl();
    }

    @Override
    public void startGetImageList(String page)
    {
        imagesView.showLoading("请稍后...");
        imageListModel.GetImageList(page, this);
    }

    @Override
    public void onSuccess(List<Images> imageList)
    {
        imagesView.receiveImageList(imageList);
        imagesView.hideLoading();
    }

    @Override
    public void OnError(Exception e)
    {
    }

    @Override
    public void attachView(ImagesView mvpView)
    {

    }

    @Override
    public void detachView()
    {

    }
}
