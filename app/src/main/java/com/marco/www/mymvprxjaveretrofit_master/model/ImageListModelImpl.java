package com.marco.www.mymvprxjaveretrofit_master.model;

import com.marco.www.mymvprxjaveretrofit_master.api.RxService;
import com.marco.www.mymvprxjaveretrofit_master.domain.Images;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * ============================================================
 * 项目名称：Girls
 * 包名称：com.flyou.girls.ui.ImageList.domain
 * 文件名：ImageListModelImpl
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2016/4/19 15:45
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 **/
public class ImageListModelImpl implements ImageListModel
{

    @Override
    public void GetImageList(final String type, final GetImageListenter listener)
    {
        RxService
                .getImgApi().getImage(type)
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
                        listener.OnError((Exception) e);
                    }

                    @Override
                    public void onNext(List<Images> images)
                    {
                        listener.onSuccess(images);
                    }
                });
    }

    public interface GetImageListenter
    {
        void onSuccess(List<Images> imageList);

        void OnError(Exception e);
    }
}
