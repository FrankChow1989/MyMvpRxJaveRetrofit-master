package com.marco.www.mymvprxjaveretrofit_master.ui.view;

import com.marco.www.mymvprxjaveretrofit_master.domain.ContentlistEntity;
import com.marco.www.mymvprxjaveretrofit_master.domain.Images;
import com.marco.www.mymvprxjaveretrofit_master.domain.JokeEntity;

import java.util.List;

/**
 * Created by pc on 2016/6/22.
 */
public interface PicView extends MvpView
{
    void receivePicList(List<ContentlistEntity> imageListDomains);
}
