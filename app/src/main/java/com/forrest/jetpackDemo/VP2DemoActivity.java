package com.forrest.jetpackDemo;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;

import me.forrest.commonlib.log.LogTool;
import me.forrest.commonlib.util.SpannableStringUtil;
import com.forrest.jetpackDemo.adapter.VPAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.yuzh.jetpackDemo.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class VP2DemoActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 vp2;
    VPAdapter vpAdapter;

    TabLayout tabLayout2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp_demo);
        initView();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initView() {
        tabLayout = findViewById(R.id.tab_layout);

        vp2 = findViewById(R.id.vp2);
        vpAdapter = new VPAdapter(this);
        vp2.setAdapter(vpAdapter);

        // 设置 TabLayout 与 ViewPage2关联
        new TabLayoutMediator(tabLayout, vp2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText("测试1").setIcon(R.drawable.icon_tab_xin_white);
                } else {
                    tab.setText("测试2").setIcon(R.drawable.icon_tab_xin_white);
                }
            }
        }).attach();

        // 设置TabLayout监听 利用富文本的方式设置字体的类型 对于只有文字变化的TabLayout来说比较简单实用
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab == null || TextUtils.isEmpty(tab.getText())) {
                    return;
                }
                // 字体加粗的富文本
                String content = tab.getText().toString();
                SpannableString spanString = SpannableStringUtil.setTypeface(Typeface.BOLD, content);
                tab.setText(spanString);
                tab.setIcon(R.drawable.icon_tab_xin_red);
//                LogTool.debug("tabLayout onTabSelected: ");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab == null || TextUtils.isEmpty(tab.getText())) {
                    return;
                }
                String content = tab.getText().toString();
                SpannableString spanString = SpannableStringUtil.setTypeface(Typeface.NORMAL, content);
                tab.setText(spanString);
                tab.setIcon(R.drawable.icon_tab_xin_white);
//                LogTool.debug("tabLayout onTabUnselected: ");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // 设置默认第一个字体加粗
        String content = tabLayout.getTabAt(0).getText().toString();
        SpannableString spanString = SpannableStringUtil.setTypeface(Typeface.BOLD, content);
        tabLayout.getTabAt(0).setText(spanString).setIcon(R.drawable.icon_tab_xin_red);
    }
}
