package com.marco.www.mymvprxjaveretrofit_master.ui.view;

import com.marco.www.mymvprxjaveretrofit_master.domain.ContentlistEntity;

import java.util.List;

/**
 * Created by pc on 2016/6/22.
 */
public interface PicView extends MvpView
{
    void refresh(List<ContentlistEntity> data);

    void loadMore(List<ContentlistEntity> data);
}
