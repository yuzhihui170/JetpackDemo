package com.yuzh.jetpackDemo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getArguments() 获取的就是bundle
                String name = getArguments().getString("name");
                Log.d("FirstFragment", "name = " + name);
                Bundle bundle = new Bundle();
                bundle.putString("newName", "XXXXX");
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_firstFragment_to_secondFragment, bundle);
            }
        });
    }
}
