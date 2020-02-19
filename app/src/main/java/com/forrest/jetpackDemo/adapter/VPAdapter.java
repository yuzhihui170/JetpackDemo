package com.forrest.jetpackDemo.adapter;

import android.util.Log;

import com.forrest.jetpackDemo.FirstFragment;
import com.forrest.jetpackDemo.SubFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class VPAdapter extends FragmentStateAdapter {

    private final static String TAG = VPAdapter.class.getSimpleName();

    public VPAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public VPAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    public VPAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new SubFragment();
        } else if (position == 1) {
            return new FirstFragment();
        }
        Log.d(TAG, "createFragment: " + position);
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
