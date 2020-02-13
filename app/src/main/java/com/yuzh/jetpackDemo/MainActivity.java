package com.yuzh.jetpackDemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yuzh.ViewModel.MyData;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    private TextView textView;
    private Button button;
    private MyData myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        // 1. 获取 MyData 对象
        myData = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MyData.class);
        // 2. 监听数据变化, 第一次执行时不会监听到，屏幕方向切换时会监听到
        myData.getNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Log.d(TAG, "integer = " + integer);
                textView.setText(String.valueOf(integer));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            int i = 0;
            @Override
            public void onClick(View v) {
                myData.setNumber(++i);
            }
        });
        Log.d(TAG, "[MainActivity]:onCreate ");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "[MainActivity]:onDestroy ");
    }
}
