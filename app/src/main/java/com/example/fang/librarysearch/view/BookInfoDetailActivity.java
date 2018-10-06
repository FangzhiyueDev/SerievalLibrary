package com.example.fang.librarysearch.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.fang.librarysearch.R;
import com.example.fang.librarysearch.Tools.UiThread;
import com.example.fang.librarysearch.mode.BookInfo;
import com.example.fang.librarysearch.standard.StandardSet;

public class BookInfoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookinfo_detail);
        initData();
        initComponent();
    }

    /**
     * private String bookName;
     * private String author;
     * private String press;
     * private String publishingTime;
     * private String ISBN;
     * private String callNumber;
     * private String classificationNumber;
     * private String pageCount;
     * private String price;
     * private String duplicateNumber;
     * private String inLibraryNumber;
     * private String loadDays;
     * private String loadCount;
     * private String distribution;
     * private String bookInfoS;
     */

    TextView bookName;
    TextView author;
    TextView press;
    TextView publishingTime;
    TextView ISBN;
    TextView callNumber;
    TextView classificationNumber;
    TextView pageCount;
    TextView price;
    TextView duplicateNumber;
    TextView inLibraryNumber;
    TextView loadDays;
    TextView loadCount;
    TextView distribution;


    private void initComponent() {

        bookName = findViewById(R.id.bookName);
        author = findViewById(R.id.author);
        press = findViewById(R.id.press);
        publishingTime = findViewById(R.id.publishingTime);
        ISBN = findViewById(R.id.ISBN);
        callNumber = findViewById(R.id.callNumber);
        classificationNumber = findViewById(R.id.classificationNumber);
        pageCount = findViewById(R.id.pageCount);
        price = findViewById(R.id.price);
        duplicateNumber = findViewById(R.id.duplicateNumber);
        inLibraryNumber = findViewById(R.id.inLibraryNumber);
        loadDays = findViewById(R.id.loadDays);
        loadCount = findViewById(R.id.loadCount);
        distribution = findViewById(R.id.distribution);
    }

    private void initData() {
        final BookInfo bookInfo = (BookInfo) getIntent().getSerializableExtra(StandardSet.bookInfoDetailDump);
        //解析数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                String bookInfoS = bookInfo.getBookInfo();
                String[] bookInfoA = bookInfoS.split(" ");
                for (int i = 0; i < bookInfoA.length; i++) {
                    Log.d("test", "书籍信息" + bookInfoA[i]);
                    String key = bookInfoA[i].split("：")[0];
                    Log.d("test", "key=" + key);
                    switch (key) {
                        case "作者":
                            bookInfo.setAuthor(bookInfoA[i]);
                            break;
                        case "出版社":
                            bookInfo.setPress(bookInfoA[i]);
                            break;
                        case "出版时间":
                            bookInfo.setPublishingTime(bookInfoA[i]);
                            break;
                        case "ISBN":
                            bookInfo.setISBN(bookInfoA[i]);
                            break;
                        case "索书号":
                            bookInfo.setCallNumber(bookInfoA[i]);
                            break;
                        case "分类号":
                            bookInfo.setClassificationNumber(bookInfoA[i]);
                            break;
                        case "页数":
                            bookInfo.setPageCount(bookInfoA[i]);
                            break;
                        case "价格":
                            bookInfo.setPrice(bookInfoA[i]);
                            break;
                        case "复本数":
                            bookInfo.setDuplicateNumber(bookInfoA[i]);
                            break;
                        case "在馆数":
                            bookInfo.setInLibraryNumber(bookInfoA[i]);
                            break;
                        case "累借天数":
                            bookInfo.setLoadDays(bookInfoA[i]);
                            break;
                        case "累借次数":
                            bookInfo.setLoadCount(bookInfoA[i]);
                            break;
                    }
                }

                //解析过后
                UiThread.getUiThead().post(new Runnable() {
                    @Override
                    public void run() {
                        setValue(bookInfo);
                    }
                });

            }
        }).start();
    }

    /**
     * 设置数据的显示
     * bookName = findViewById(R.id.bookName);
     * author = findViewById(R.id.author);
     * press = findViewById(R.id.press);
     * publishingTime = findViewById(R.id.publishingTime);
     * ISBN = findViewById(R.id.ISBN);
     * callNumber = findViewById(R.id.callNumber);
     * classificationNumber = findViewById(R.id.classificationNumber);
     * pageCount = findViewById(R.id.pageCount);
     * price = findViewById(R.id.price);
     * duplicateNumber = findViewById(R.id.duplicateNumber);
     * inLibraryNumber = findViewById(R.id.inLibraryNumber);
     * loadDays = findViewById(R.id.loadDays);
     * loadCount = findViewById(R.id.loadCount);
     * distribution = findViewById(R.id.distribution);
     *
     * @param bookInfo
     */
    private void setValue(BookInfo bookInfo) {
        bookName.setText(bookInfo.getBookName());
        author.setText(bookInfo.getAuthor());
        press.setText(bookInfo.getPress());
        publishingTime.setText(bookInfo.getPublishingTime());
        ISBN.setText(bookInfo.getISBN());
        callNumber.setText(bookInfo.getCallNumber());
        classificationNumber.setText(bookInfo.getClassificationNumber());
        pageCount.setText(bookInfo.getPageCount());
        price.setText(bookInfo.getPrice());
        duplicateNumber.setText(bookInfo.getDuplicateNumber());
        inLibraryNumber.setText(bookInfo.getInLibraryNumber());
        loadDays.setText(bookInfo.getLoadDays());
        loadCount.setText(bookInfo.getLoadCount());
        distribution.setText(bookInfo.getDistribution());
    }
}
