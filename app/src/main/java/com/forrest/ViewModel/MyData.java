package com.forrest.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 利用 LiveData 和 ViewModel 来实现数据模型
 * ViewModel 可以实现 Activity 重建时数据不丢失
 * LiveData 可以实现数据监听，方便UI更新
 */
public class MyData extends ViewModel {
    private MutableLiveData<Integer> number;

    public MyData() {
        number = new MutableLiveData<>();
    }

    public MutableLiveData<Integer> getNumber() {
        return number;
    }

    public void setNumber(int n) {
        number.setValue(n);
    }
}
