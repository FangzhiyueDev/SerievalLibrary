package com.example.fang.librarysearch.view.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fang.librarysearch.R;
import com.example.fang.librarysearch.standard.StandardSet;

import java.io.File;

/**
 * 设置界面的Fragment
 */
public class SettingPageFragment extends Fragment {

    SharedPreferences sp;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getContext().getSharedPreferences(StandardSet.historyName, Context.MODE_PRIVATE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.setting_fragment, null, false);

        initComponent((ViewGroup) view);

        return view;
    }

    TextView reset;
    TextView clearCache;

    /**
     * 对里面的子视图进行初始化
     *
     * @param view
     */
    private void initComponent(ViewGroup view) {

        reset = view.findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在这里我们清除我们的html网页缓存
                File file = new File(getContext().getCacheDir(), StandardSet.saveHtmlName);
                File file1 = new File(getContext().getCacheDir(), StandardSet.reretrievalHtmlData);
                if (file.exists()) {
                    file.delete();
                }
                if (file1.exists()) {
                    file1.delete();
                }
            }
        });

        clearCache = view.findViewById(R.id.clearCache);
        clearCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在这里我们清除  配置文件
                if (sp != null) {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.clear();
                    editor.commit();

                }
            }
        });

    }
}
