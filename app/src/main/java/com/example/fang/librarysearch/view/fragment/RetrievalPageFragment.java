package com.example.fang.librarysearch.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fang.librarysearch.R;

/**
 * 检索界面的Fragment
 */
public class RetrievalPageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.retrieval_page_fragment,
                null, false);
        initComponent((ViewGroup) view);
        return view;
    }

    private void initComponent(ViewGroup view) {

    }
}
