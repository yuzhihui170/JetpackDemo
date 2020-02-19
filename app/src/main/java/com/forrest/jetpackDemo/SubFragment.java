package com.forrest.jetpackDemo;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.forrest.jetpackDemo.adapter.VideoRlvApater;
import com.forrest.jetpackDemo.bean.VideoBean;
import com.yuzh.jetpackDemo.R;

import java.util.ArrayList;
import java.util.List;

import me.forrest.commonlib.adapter.RecyclerListener;
import me.forrest.commonlib.log.LogTool;

public class SubFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, RecyclerListener.OnLoadListener {

    private View rootView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView rlv_video;
    private VideoRlvApater videoRlvApater;

    private List<VideoBean> videoBeanList = new ArrayList<>(10);

    private Handler handler = new Handler();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        LogTool.debug("[SubFragment onAttach]");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogTool.debug("[SubFragment onCreate]");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_sub, container, false);
            swipeRefreshLayout = rootView.findViewById(R.id.swipeRefreshLayout);
            swipeRefreshLayout.setOnRefreshListener(this);
            rlv_video = rootView.findViewById(R.id.rlv_video);
            // 设置 LayoutManager
            rlv_video.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
//            rlv_video.setLayoutManager(new GridLayoutManager(this, 2));
//            rlv_video.addItemDecoration(new SpacesItemDecoration(2, false));
            videoRlvApater = new VideoRlvApater(null, R.layout.item_video);
            videoRlvApater.setOnLoadListener(this);
            rlv_video.setAdapter(videoRlvApater);
        }
        LogTool.debug("[SubFragment onCreateView]");
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogTool.debug("[SubFragment onActivityCreated]");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogTool.debug("[SubFragment onStart]");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogTool.debug("[SubFragment onResume]");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogTool.debug("[SubFragment onPause]");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogTool.debug("[SubFragment onStop]");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogTool.debug("[SubFragment onDestroyView]");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogTool.debug("[SubFragment onDestroy]");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogTool.debug("[SubFragment onDetach]");
    }

    // 使用add hide() show()方法切换fragment, 不会走任何的生命周期 无法通过生命周期进行刷新
    // 这个时候通过该方法来判断是否显示
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        LogTool.debug("[SubFragment onHiddenChanged] hidden: " + hidden);
    }

    int mPageNum = 1;
    // 下拉刷新时调用这个方法
    @Override
    public void onRefresh() {
        LogTool.debug("[SubFragment onRefresh]");

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                videoBeanList.clear();
                videoBeanList.add(new VideoBean());
                videoBeanList.add(new VideoBean());
                videoBeanList.add(new VideoBean());
                videoBeanList.add(new VideoBean());
                videoBeanList.add(new VideoBean());
                videoRlvApater.refurbish(videoBeanList);
                videoRlvApater.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false); // 隐藏圈圈
            }
        },1000);

    }

    int i = 0;
    // 第一次就会加载
    @Override
    public void onLoad() {
        LogTool.debug("[SubFragment onLoad]");
        videoRlvApater.setFootLoading(); // 当然，当list.size == 0时 loading不会显示
        videoRlvApater.notifyDataSetChanged();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (i++ < 4) {
                    videoBeanList.clear();
                    videoBeanList.add(new VideoBean());
                    videoRlvApater.addList(videoBeanList);
                    videoRlvApater.notifyDataSetChanged();
                    videoRlvApater.finishLoadMore();
                } else {
                    videoRlvApater.setFootEmpty();
                    videoRlvApater.notifyDataSetChanged();
                }
            }
        }, 1000);
    }

}
