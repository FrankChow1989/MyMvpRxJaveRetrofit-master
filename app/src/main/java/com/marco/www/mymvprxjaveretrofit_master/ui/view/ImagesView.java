package com.marco.www.mymvprxjaveretrofit_master.ui.view;

import com.marco.www.mymvprxjaveretrofit_master.domain.ContentlistEntity;
import com.marco.www.mymvprxjaveretrofit_master.domain.Images;

import java.util.List;

/**
 * Created by pc on 2016/6/23.
 */
public interface ImagesView extends MvpView
{
    void refresh(List<Images> data);

    void loadMore(List<Images> data);
}
