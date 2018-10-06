package com.example.fang.librarysearch.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fang.librarysearch.Controler.RequestControler;
import com.example.fang.librarysearch.R;
import com.example.fang.librarysearch.Tools.FileOprationTools;
import com.example.fang.librarysearch.Tools.UiThread;
import com.example.fang.librarysearch.Tools.htmlDataParase.HtmlDataParse;
import com.example.fang.librarysearch.mode.BookInfo;
import com.example.fang.librarysearch.mode.Request;
import com.example.fang.librarysearch.mode.Retrieval.RetrievalResponse;
import com.example.fang.librarysearch.standard.StandardSet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DetailInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_info);

        initData();
        initComponent();

    }

    private TextView labAllCount;
    private ListView listView;
    private ImageButton reflush;
    private MyBookInfoAdapter myBookInfoAdapter;

    private void initComponent() {
        labAllCount = findViewById(R.id.labAllCount);

        listView = findViewById(R.id.retrievalListView);
        listView.setAdapter(myBookInfoAdapter = new MyBookInfoAdapter(this, new ArrayList<BookInfo>()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // MyBookInfoAdapter.MyHolder myHolder = (MyBookInfoAdapter.MyHolder) parent.getTag();
                BookInfo bookInfo = (BookInfo) myBookInfoAdapter.getItem(position);
                //点击之后将数据进行传递到书籍的详情界面里去
                Intent intent = new Intent(DetailInfoActivity.this, BookInfoDetailActivity.class);
                intent.putExtra(StandardSet.bookInfoDetailDump, bookInfo);
                startActivity(intent);
            }
        });
        reflush = findViewById(R.id.reFlashButton);
        reflush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在这里刷新数据
                executeFlushRequest();
                //执行动画
                executeAnimation();
            }
        });
    }

    private void executeAnimation() {

    }

    private int count;
    private int staticsticCount = 1;

    private void statisticFlushCount() {
        if (count > 0) {//代表的是有数据
            staticsticCount++;

        } else {
            Toast.makeText(this, "查询的结果为空", Toast.LENGTH_SHORT).show();
        }

    }

    private void executeFlushRequest() {

        //进行计数
        statisticFlushCount();

        if (staticsticCount > count) {
            //在这里我们设置刷新按钮不可见，不可点击，代表的是没有数据，我们将不能再次的进行刷新
            reflush.setVisibility(View.INVISIBLE);
            reflush.setClickable(false);
        }


        new Thread(new Runnable() {
            @Override
            public void run() {
                if (bookName == null) {
                    Toast.makeText(DetailInfoActivity.this,
                            "检索数据丢失", Toast.LENGTH_SHORT).show();
                    finish();
                }
                final Request request = new Request(staticsticCount + "", StandardSet.serverMainPage, bookName);
                try {
/***
 * http://192.168.30.248:81/NTRdrBookRetr.aspx?page=2&strKeyValue=android&strType=text&tabletype=*&RepSearch=&strKeyValue2=&&strAllAuthor=&strAllPubyear=&strAllPublish=&strAllLanguage=&strCondition2=&strpageNum=10&strVip=&strStartYear=&strEndYear=&strPublisher=&strAuthorer=&strSortType=&strSort=asc
 */
                    RequestControler.retrievalResultNextPage(request, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Log.d("test", "onFailure: 执行出错" + e.getMessage());
                            Toast.makeText(DetailInfoActivity.this,
                                    "出现未知错误，请联系开发者或稍后再试",
                                    Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            final String data = response.body().string();

                            //在这里我们跳转到另外一个界面进行显示
                            Log.d("test", "onResponse: 大小" + data.getBytes().length);
                            writeData(data);

                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void writeData(String data) {
        //写入
        FileOprationTools.writeFile(this, data, StandardSet.reretrievalHtmlData);
        //解析
        parseData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //进行按钮状态的恢复

    }

    private void parseData() {

        final File file = new File(getCacheDir(), StandardSet.reretrievalHtmlData);
        if (!file.exists()) {
            Toast.makeText(this, "发生未知错误，程序退出", Toast.LENGTH_SHORT).show();
            finish();
        }

        Log.d("test", "initData: 文件名称位" + file.getAbsolutePath());


        //解析的过程应该在子线称总运行
        new Thread(new Runnable() {
            @Override
            public void run() {
                final RetrievalResponse retrievalResponse =
                        HtmlDataParse.retrievalResponse(file.getAbsolutePath());
                UiThread.getUiThead().post(new Runnable() {
                    @Override
                    public void run() {
                        List<BookInfo> list = retrievalResponse.getBookInfo();
                        myBookInfoAdapter.addBookInfos(list);
                    }
                });
            }
        }).start();
    }

    /**
     * 统计需要刷新的次数
     */
    private void needFlushCount(int numbers) {
        count = numbers / 10;//代表的需要刷新的次数
        if (numbers % 10 > 0) {
            count++;
        }
    }

    private String bookName;

    private void initData() {
        bookName = getIntent().getStringExtra(StandardSet.retrievalBookName);
        //传递到解析的程序中进行数据的解析
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
                final RetrievalResponse retrievalResponse = HtmlDataParse.retrievalResponse(file.getAbsolutePath());
                UiThread.getUiThead().post(new Runnable() {
                    @Override
                    public void run() {
                        int numbers = Integer.parseInt(retrievalResponse.getRetrievalCount());
                        needFlushCount(numbers);
                        labAllCount.setText("检索到数据" + numbers + "条");
                        List<BookInfo> list = retrievalResponse.getBookInfo();

                        myBookInfoAdapter.addBookInfos(list);
                    }
                });
            }
        }).start();
    }


    /**
     * 书籍信息的适配器
     */
    class MyBookInfoAdapter extends BaseAdapter {

        Context context;
        List<BookInfo> bookInfos;

        MyBookInfoAdapter(Context context, List<BookInfo> bookInfos) {
            this.context = context;
            this.bookInfos = bookInfos;
        }

        public void setBookInfos(List<BookInfo> bookInfos) {
            this.bookInfos = bookInfos;
            this.notifyDataSetChanged();
        }

        public void addBookInfos(List<BookInfo> bookInfos) {
            this.bookInfos.addAll(bookInfos);
            this.notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return bookInfos.size();
        }

        @Override
        public Object getItem(int position) {
            return bookInfos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            BookInfo bookInfo = bookInfos.get(position);

            MyHolder myHolder;
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.bookinfo_subview, parent, false);
                myHolder = new MyHolder();
                myHolder.textView = convertView.findViewById(R.id.bookInfo_Name);
                convertView.setTag(myHolder);
            } else {
                myHolder = (MyHolder) convertView.getTag();
            }
            myHolder.textView.setText(bookInfo.getBookName());


            return convertView;
        }


        class MyHolder {
            TextView textView;
        }
    }

}
