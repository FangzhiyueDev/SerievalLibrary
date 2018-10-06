package com.example.fang.librarysearch.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.fang.librarysearch.R;
import com.example.fang.librarysearch.view.fragment.HistoryFragment;
import com.example.fang.librarysearch.view.fragment.RetrievalPageFragment;
import com.example.fang.librarysearch.view.fragment.SettingPageFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initComponent();
    }


    TextView historyButton;
    TextView retrievalButton;
    TextView settingButton;

    FrameLayout contentFrame;

    private void initComponent() {


        contentFrame = findViewById(R.id.contentView);
        historyButton = findViewById(R.id.historyButton);
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HistoryFragment historyFragment = new HistoryFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.contentView, historyFragment);
                fragmentTransaction.commit();
            }
        });
        settingButton = findViewById(R.id.settingButton);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingPageFragment settingPageFragment = new SettingPageFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.contentView, settingPageFragment);
                fragmentTransaction.commit();
            }
        });
        retrievalButton = findViewById(R.id.queryButton);
        retrievalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrievalPageFragment retrievalPageFragment = new RetrievalPageFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.contentView, retrievalPageFragment);
                fragmentTransaction.commit();
            }
        });

        RetrievalPageFragment retrievalPageFragment = new RetrievalPageFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.contentView, retrievalPageFragment);
        fragmentTransaction.commit();


    }

    private void initData() {

    }


}
