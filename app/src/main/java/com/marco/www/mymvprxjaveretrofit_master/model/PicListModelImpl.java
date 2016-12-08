package com.marco.www.mymvprxjaveretrofit_master.model;

import android.util.Log;

import com.marco.www.mymvprxjaveretrofit_master.api.RxService;
import com.marco.www.mymvprxjaveretrofit_master.domain.ContentlistEntity;
import com.marco.www.mymvprxjaveretrofit_master.domain.Images;
import com.marco.www.mymvprxjaveretrofit_master.domain.JokeEntity;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
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
public class PicListModelImpl implements PicListModel
{

    @Override
    public void GetPicList(int page, final GetPicListenter listener)
    {
        RxService.getJokeApi().getJoke(page)
                .subscribeOn(Schedulers.io())//在非UI线程中获取数据
                .map(new Func1<JokeEntity, List<ContentlistEntity>>()
                {
                    @Override
                    public List<ContentlistEntity> call(JokeEntity jokeEntity)
                    {

                        for (ContentlistEntity c : jokeEntity.getShowapi_res_body().getContentlist())
                        {
                            Log.d("TAG", c.getTitle() + "," + c.getText());
                        }

                        return jokeEntity.getShowapi_res_body().getContentlist();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())//在UI线程中执行更新UI
                .subscribe(new Observer<List<ContentlistEntity>>()
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
                    public void onNext(List<ContentlistEntity> contentlistEntities)
                    {
                        listener.onSuccess(contentlistEntities);
                    }
                });
    }

    public interface GetPicListenter
    {
        void onSuccess(List<ContentlistEntity> imageList);

        void OnError(Exception e);
    }
}
