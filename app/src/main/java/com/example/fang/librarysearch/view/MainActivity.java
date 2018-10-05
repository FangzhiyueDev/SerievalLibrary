package com.example.fang.librarysearch.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.MimeTypeFilter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.fang.librarysearch.Controler.RequestControler;
import com.example.fang.librarysearch.R;
import com.example.fang.librarysearch.Tools.UiThread;
import com.example.fang.librarysearch.mode.Request;
import com.example.fang.librarysearch.mode.Response;
import com.example.fang.librarysearch.netWork.NetWorkTools;
import com.example.fang.librarysearch.standard.StandardSet;
import com.example.fang.librarysearch.view.fragment.HistoryFragment;
import com.example.fang.librarysearch.view.fragment.RetrievalPageFragment;
import com.example.fang.librarysearch.view.fragment.SettingPageFragment;

import java.io.IOException;
import java.nio.file.WatchEvent;

import okhttp3.Call;
import okhttp3.Callback;

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

//    private void initData() {
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                final Request request = new Request(StandardSet.serverMainPage, "简爱");
//                try {
//
//                    RequestControler.sinceRetrieval(request, new Callback() {
//                        @Override
//                        public void onFailure(Call call, IOException e) {
//                            Log.d("test", "onFailure: 执行出错" + e.getMessage());
//                        }
//
//                        @Override
//                        public void onResponse(Call call, okhttp3.Response response) throws IOException {
//                            final String data = response.body().string();
//                            Log.d("test", "得到的数据是" + data);
//                            UiThread.getUiThead().post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    webView.loadData(data, "text/html", "utf-8");
//                                }
//                            });
//                        }
//                    });
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }

//    WebView webView;
//
//    private void initComponent() {
//
//        webView = findViewById(R.id.webViewId);
//        webView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//        });
//
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        webSettings.setLoadWithOverviewMode(true);
//
//    }


}
