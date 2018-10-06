package com.example.fang.librarysearch.Tools;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;

public class Tools {


    /**
     * 获得屏幕的大小
     *
     * @param context
     * @return
     */
    public static int[] getScreenDemintion(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int[] a = new int[2];
        a[0] = dm.widthPixels;
        a[1] = dm.heightPixels;
        return a;
    }

}
