package com.example.fang.librarysearch.Tools.htmlDataParase;


import com.example.fang.librarysearch.mode.Retrieval.RetrievalResponse;

import java.io.InputStreamReader;

/**
 * 用于实现对Html网页爬取的数据进行一个解析操作
 */
public class HtmlDataParse {

    /**
     * @param htmlData 网页的数据
     */
    public static RetrievalResponse retrievalResponse(String htmlData) {
        //这里我们需要定制解析规则
        RetrievalResponse retrievalResponse = new RetrievalResponse();

        return retrievalResponse;
    }

    /**
     * 空实现，
     *
     * @param inputStreamReader 读取一个输入流
     * @return
     */
    public static RetrievalResponse retrievalResponse(InputStreamReader inputStreamReader) {

        return null;
    }
}
