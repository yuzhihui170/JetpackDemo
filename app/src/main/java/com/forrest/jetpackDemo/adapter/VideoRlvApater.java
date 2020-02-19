package com.forrest.jetpackDemo.adapter;

import androidx.annotation.NonNull;

import me.forrest.commonlib.adapter.BaseHolder;
import me.forrest.commonlib.adapter.BaseModelLoadAdapter;
import com.forrest.jetpackDemo.bean.VideoBean;

import java.util.List;

public class VideoRlvApater extends BaseModelLoadAdapter<VideoBean> {

    public VideoRlvApater(int layoutId) {
        super(layoutId);
    }

    public VideoRlvApater(List list, int layoutId) {
        super(list, layoutId);
    }

    @Override
    protected void onBindItemViewHolder(@NonNull BaseHolder holder, int position) {

    }
}
