package com.example.fang.librarysearch.Tools;

import android.content.Context;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;


public class UiThread {

    /**
     * 创建一个Ui进程
     *
     * @return
     */
    public static Handler getUiThead() {
        Handler handler = new Handler(Looper.getMainLooper());

        return handler;
    }

}
