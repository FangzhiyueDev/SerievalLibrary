package com.example.fang.librarysearch.Controler;

import android.content.Context;

import com.example.fang.librarysearch.mode.Request;
import com.example.fang.librarysearch.netWork.NetWorkTools;

/**
 * 请求控制，实现的是对请求的逻辑实现，以及进一步的封装实现
 */
public class RequestControler {

    /**
     * 实现的是第一次的检索，下面是请求的头
     * http://192.168.30.248:81/NTRdrBookRetr.aspx?strType=text&strKeyValue=简爱&strpageNum=10&tabletype=*&strSortType=&strSort=asc
     *
     * @param request
     * @param callback
     */
    public static void sinceRetrieval(Request request, okhttp3.Callback callback) {
        //下面进行数据集的拼接
        String url = request.getUrl() + "?strType=" + request.getStrType() +
                "&strKeyValue=" + request.getStrKeyValue() +
                "&strpageNum=" + request.getStrPageNum() +
                "&tabletype=" + request.getStrTableType() +
                "&strSortType=" + request.getStrSortType() +
                "&strSort=" + request.getStrSort();
        NetWorkTools.sendHttpRequest(url, callback);
    }

    /**
     * 对检索的结果进行下一页或者是下几页的数据显示时进行的请求操作
     * http://192.168.30.248:81/NTRdrBookRetr.aspx?page=1&strKeyValue=简爱&strType=text&tabletype=*&RepSearch=&strKeyValue2=&&strAllAuthor=&strAllPubyear=&strAllPublish=&strAllLanguage=&strCondition2=&strpageNum=10&strVip=&strStartYear=&strEndYear=&strPublisher=&strAuthorer=&strSortType=&strSort=
     *
     * @param request
     * @param callback
     */
    public static void retrievalResultNextPage(Request request, okhttp3.Callback callback) {
        String url = request.getUrl() + "?page=" + request.getPage() +
                "&strKeyValue=" + request.getStrKeyValue() +
                "&strType=" + request.getStrType() +
                "&RepSearch=" + request.getRepSearch() +
                "&strKeyValue2=" + request.getStrKeyValue2() +
                "&strAllAuthor=" + request.getStrAllAuthor() +
                "&strAllPubyear=" + request.getStrAllPubyear() +
                "&strAllPublish=" + request.getStrAllPublish() +
                "&strAllLanguage=" + request.getStrAllLanguage() +
                "&strCondition2=" + request.getStrCondition2() +
                "&strpageNum=" + request.getStrPageNum() +
                "&strVip=" + request.getStrVip() +
                "&strStartYear=" + request.getStrStartYear() +
                "&strEndYear=" + request.getStrEndYear() +
                "&strPublisher=" + request.getStrPublisher() +
                "&strAuthorer=" + request.getStrAuthorer() +
                "&strSortType=" + request.getStrSortType() +
                "&strSort=" + request.getStrSort();
        NetWorkTools.sendHttpRequest(url, callback);
    }

}
