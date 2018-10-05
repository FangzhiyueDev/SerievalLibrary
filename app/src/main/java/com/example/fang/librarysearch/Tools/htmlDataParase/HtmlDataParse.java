package com.example.fang.librarysearch.Tools.htmlDataParase;


import com.example.fang.librarysearch.mode.BookInfo;
import com.example.fang.librarysearch.mode.Retrieval.RetrievalResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于实现对Html网页爬取的数据进行一个解析操作
 */
public class HtmlDataParse {

    /**
     * @param fileName 网页的数据
     *                 [{书名,作者，出版社，出版时间，ISBN，索书号，分类号，页数，价格，复本数，在馆数，累借天数，累借次数，描述}]
     */
    public static RetrievalResponse retrievalResponse(String fileName) {
        //这里我们需要定制解析规则
        RetrievalResponse retrievalResponse = null;
        try {

            Document document = Jsoup.parse(readHtml(fileName));
            retrievalResponse = new RetrievalResponse();
            retrievalResponse = executeParse(document, retrievalResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return retrievalResponse;
    }

    /**
     * 执行解析
     *
     * @param document
     * @param retrievalResponse
     */
    private static RetrievalResponse executeParse(Document document, RetrievalResponse retrievalResponse) {

        List<BookInfo> bookInfos = new ArrayList<>();
        Element element3 = document.select("span#labAllCount").get(0);
        //获得查询结果的数量
        retrievalResponse.setRetrievalCount(element3.text());

        Elements elements = document.select("div.into");
        for (int i = 0; i < elements.size(); i++) {
            Elements bookName = elements.get(i).select("h3 a");
            //获得书名称
            BookInfo bookInfoObj = new BookInfo();
            bookInfoObj.setBookName(bookName.get(0).text());

            Element bookInfo = elements.get(i).select("div.titbar").get(0);
            /**
             * 解析书籍的各种信息
             * {“作者”,"出版社","出版时间","ISBN","索书号","分页号","页数","价格","副本数","在馆数","累借天数","累借次数"}
             */
            bookInfoObj.setBookInfo(bookInfo.text());

            //解析出对书籍的描述信息
            Element distribute = elements.get(i).select("div.text").get(0);
//            System.out.println(distribute.text());
            bookInfoObj.setDistribution(distribute.text());
            bookInfos.add(bookInfoObj);
        }
        retrievalResponse.setBookInfo(bookInfos);

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


    public static InputStream getStringStream(String sInputString) {

        if (sInputString != null && !sInputString.trim().equals("")) {
            try {
                ByteArrayInputStream tInputStringStream = new ByteArrayInputStream(sInputString.getBytes());
                return tInputStringStream;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 读html文件
     *
     * @param fileName
     * @return
     */
    public static String readHtml(String fileName) {
        FileInputStream fis = null;
        StringBuffer sb = new StringBuffer();
        try {
            fis = new FileInputStream(fileName);
            byte[] bytes = new byte[1024];
            while (-1 != fis.read(bytes)) {
                sb.append(new String(bytes));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return sb.toString();
    }

}