package com.example.fang.librarysearch.standard;


/**
 * 存放了一些项目中使用的常量集合
 */
public class StandardSet {


    /**
     * 返回数据的静态文件的文件名和路径
     */
    public static final String responseDateFileName = "file:///android_asset/Library.html";

    public static final String serverMainPage = "http://192.168.30.248:81/NTRdrBookRetr.aspx";

    /**
     * 响应的数据集，这里我们应该清楚响应的数据是一个html网页的数据，这时我们在详情的界面需要进行解析我们的数据
     */
    public static final String responseDataDumpExtraName = "responseData";


    public static String saveHtmlName = "index.html";
    /**
     * 实现的是检索的全部数据的一个详细信息的界面跳转的附加数据的key
     */
    public static String bookInfoDetailDump = "bookInfo";

    /**
     * 用于检索书名的输入文字
     */
    public static String retrievalBookName="retrievalBookName";
    /**
     * 再次进行检索的html数据，这个html的数据是由我们进行更改检索结果的数据页而进行的查询
     * 同样的实现的也是get请求
     */
    public static String reretrievalHtmlData="reretrievalHtmlData.html";
}
