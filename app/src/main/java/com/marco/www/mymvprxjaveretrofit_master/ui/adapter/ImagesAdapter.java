package com.marco.www.mymvprxjaveretrofit_master.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.marco.www.mymvprxjaveretrofit_master.R;
import com.marco.www.mymvprxjaveretrofit_master.domain.Images;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by JDD on 2016/4/23 0023.
 */
public class ImagesAdapter extends RecyclerView.Adapter
{
    private List<Images> jokeList;
    private Context context;

    public ImagesAdapter(Context context, List<Images> jokeList)
    {
        this.context = context;
        this.jokeList = jokeList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.img_list_item, parent, false);
        JokeViewHolder holder = new JokeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        JokeViewHolder jokeViewHolder = (JokeViewHolder) holder;
        Glide.with(context)
                .load(jokeList.get(position).image_url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(jokeViewHolder.imageIv);
        jokeViewHolder.descriptionTv.setText(jokeList.get(position).description);
    }

    @Override
    public int getItemCount()
    {
        return jokeList.size();
    }

    static class JokeViewHolder extends RecyclerView.ViewHolder
    {
        @Bind(R.id.imageIv)
        ImageView imageIv;
        @Bind(R.id.descriptionTv)
        TextView descriptionTv;

        public JokeViewHolder(View view)
        {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
