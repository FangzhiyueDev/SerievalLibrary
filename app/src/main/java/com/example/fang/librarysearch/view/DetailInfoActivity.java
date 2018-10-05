package com.example.fang.librarysearch.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.fang.librarysearch.R;
import com.example.fang.librarysearch.Tools.htmlDataParase.HtmlDataParse;
import com.example.fang.librarysearch.mode.Retrieval.RetrievalResponse;
import com.example.fang.librarysearch.standard.StandardSet;

import java.io.File;

public class DetailInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_info);

        initData();
        initComponent();

    }

    private void initComponent() {


    }

    private void initData() {
        // String data = getIntent().getStringExtra(StandardSet.responseDataDumpExtraName);
        //  传递到解析的程序中进行数据的解析
        //我们需要的数据有
        /**
         *    1    总数
         *    2    获得检索数据的详细信息的数组
         *    [{书名,作者，出版社，出版时间，ISBN，索书号，分类号，页数，价格，复本数，在馆数，累借天数，累借次数，描述}]
         */

        final File file = new File(getCacheDir(), StandardSet.saveHtmlName);
        if (!file.exists()) {
            Toast.makeText(this, "发生未知错误，程序退出", Toast.LENGTH_SHORT).show();
            finish();
        }

        Log.d("test", "initData: 文件名称位" + file.getAbsolutePath());


        //解析的过程应该在子线称总运行
        new Thread(new Runnable() {
            @Override
            public void run() {
                RetrievalResponse retrievalResponse = HtmlDataParse.retrievalResponse(file.getAbsolutePath());

            }
        }).start();
    }
}
