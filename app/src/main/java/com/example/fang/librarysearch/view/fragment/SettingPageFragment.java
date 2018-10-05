package com.example.fang.librarysearch.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fang.librarysearch.R;

/**
 * 设置界面的Fragment
 */
public class SettingPageFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.setting_fragment, null, false);

        initComponent((ViewGroup) view);

        return view;
    }

    /**
     * 对里面的子视图进行初始化
     *
     * @param view
     */
    private void initComponent(ViewGroup view) {


    }
}
