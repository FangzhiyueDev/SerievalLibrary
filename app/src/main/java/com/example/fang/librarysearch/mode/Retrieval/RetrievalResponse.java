package com.example.fang.librarysearch.mode.Retrieval;

import com.example.fang.librarysearch.mode.BookInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 检索取得的数据的封装bean
 * <p>
 * /**
 * 1    总数
 * 2    获得检索数据的详细信息的数组
 * [{书名,作者，出版社，出版时间，ISBN，索书号，分类号，页数，价格，复本数，在馆数，累借天数，累借次数，描述}]
 */

public class RetrievalResponse {

    /**
     * 检索到的数据的数量
     */
    private String retrievalCount;

    private List<BookInfo> bookInfo;

    public String getRetrievalCount() {
        return retrievalCount;
    }

    public void setRetrievalCount(String retrievalCount) {
        this.retrievalCount = retrievalCount;
    }

    public List<BookInfo> getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(List<BookInfo> bookInfo) {
        this.bookInfo = bookInfo;
    }

    public RetrievalResponse() {

        bookInfo = new ArrayList<>();
    }

    public RetrievalResponse(String retrievalCount, List<BookInfo> bookInfo) {
        this.retrievalCount = retrievalCount;
        this.bookInfo = bookInfo;
    }
}
