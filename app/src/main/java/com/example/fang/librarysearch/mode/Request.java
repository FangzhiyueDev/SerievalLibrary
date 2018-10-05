package com.example.fang.librarysearch.mode;


public class Request {


    /**
     * 请求的页面
     */
    private String page;


    public String strAuthorer;

    public String strPublisher;

    public String strEndYear;

    public String strStartYear;

    private String RepSearch;

    private String strKeyValue2;

    private String strAllAuthor;

    private String strAllPubyear;

    private String strAllPublish;

    private String strAllLanguage;

    private String strCondition2;

    private String strVip;

    /**
     * 请求的服务器主机
     */
    private String url;
    /**
     * 类型  文本
     */
    private String strType;
    /**
     * 搜索关键字
     */
    private String strKeyValue;
    /**
     * 页面显示的数量
     */

    private String strPageNum;

    /**
     * 表格类型
     */
    private String strTableType;

    /**
     * 排序类型
     */
    private String strSortType;

    /**
     * 排序方式
     */
    private String strSort;


    public Request(String url, String strType, String strKeyValue, String strPageNum, String strTableType, String strSortType, String strSort) {
        this.url = url;
        this.strType = strType;
        this.strKeyValue = strKeyValue;
        this.strPageNum = strPageNum;
        this.strTableType = strTableType;
        this.strSortType = strSortType;
        this.strSort = strSort;
    }

    /**
     * http://192.168.30.248:81/NTRdrBookRetr.aspx?page=1&strKeyValue=%e7%ae%80%e7%88%b1&strType=text&tabletype=*&RepSearch=&strKeyValue2=&&strAllAuthor=&strAllPubyear=&strAllPublish=&strAllLanguage=&strCondition2=&strpageNum=10&strVip=&strStartYear=&strEndYear=&strPublisher=&strAuthorer=&strSortType=&strSort=
     */


    /**
     * 这个构造函数的作用是实现二次请求，也就是实现下一页面的跳转的实现的构造
     *
     * @param page
     * @param url
     * @param strKeyValue
     */
    public Request(String page, String url, String strKeyValue) {
        this.strType = "text";
        this.strPublisher = "";
        this.strAuthorer = "";
        this.strSortType="";
        this.strSort="";
        this.strAllAuthor = "";
        this.strAllPubyear = "";
        this.strAllPublish="";
        this.strAllLanguage = "";
        this.strCondition2 = "";
        this.strPageNum = "10";
        this.strVip = "";
        this.strStartYear = "";
        this.strEndYear = "";
        this.strTableType = "*";
        this.RepSearch = "";
        this.strKeyValue2 = "";
        this.page = page;
        this.url = url;
        this.strKeyValue = strKeyValue;
    }

    /**
     * 实现的是查询一次构造的实现
     *
     * @param url
     * @param strKeyValue
     */
    public Request(String url, String strKeyValue) {
        this.url = url;
        this.strKeyValue = strKeyValue;
        this.strPageNum = "10";
        this.strSort = "asc";
        this.strSortType = "";
        this.strType = "text";
        this.strTableType = "*";
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStrType() {
        return strType;
    }

    public void setStrType(String strType) {
        this.strType = strType;
    }

    public String getStrKeyValue() {
        return strKeyValue;
    }

    public void setStrKeyValue(String strKeyValue) {
        this.strKeyValue = strKeyValue;
    }

    public String getStrPageNum() {
        return strPageNum;
    }

    public void setStrPageNum(String strPageNum) {
        this.strPageNum = strPageNum;
    }

    public String getStrTableType() {
        return strTableType;
    }

    public void setStrTableType(String strTableType) {
        this.strTableType = strTableType;
    }

    public String getStrSortType() {
        return strSortType;
    }

    public void setStrSortType(String strSortType) {
        this.strSortType = strSortType;
    }

    public String getStrSort() {
        return strSort;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getStrAuthorer() {
        return strAuthorer;
    }

    public void setStrAuthorer(String strAuthorer) {
        this.strAuthorer = strAuthorer;
    }

    public String getStrPublisher() {
        return strPublisher;
    }

    public void setStrPublisher(String strPublisher) {
        this.strPublisher = strPublisher;
    }

    public String getStrEndYear() {
        return strEndYear;
    }

    public void setStrEndYear(String strEndYear) {
        this.strEndYear = strEndYear;
    }

    public String getStrStartYear() {
        return strStartYear;
    }

    public void setStrStartYear(String strStartYear) {
        this.strStartYear = strStartYear;
    }

    public String getRepSearch() {
        return RepSearch;
    }

    public void setRepSearch(String repSearch) {
        RepSearch = repSearch;
    }

    public String getStrKeyValue2() {
        return strKeyValue2;
    }

    public void setStrKeyValue2(String strKeyValue2) {
        this.strKeyValue2 = strKeyValue2;
    }

    public String getStrAllAuthor() {
        return strAllAuthor;
    }

    public void setStrAllAuthor(String strAllAuthor) {
        this.strAllAuthor = strAllAuthor;
    }

    public String getStrAllPubyear() {
        return strAllPubyear;
    }

    public void setStrAllPubyear(String strAllPubyear) {
        this.strAllPubyear = strAllPubyear;
    }

    public String getStrAllPublish() {
        return strAllPublish;
    }

    public void setStrAllPublish(String strAllPublish) {
        this.strAllPublish = strAllPublish;
    }

    public String getStrAllLanguage() {
        return strAllLanguage;
    }

    public void setStrAllLanguage(String strAllLanguage) {
        this.strAllLanguage = strAllLanguage;
    }

    public String getStrCondition2() {
        return strCondition2;
    }

    public void setStrCondition2(String strCondition2) {
        this.strCondition2 = strCondition2;
    }

    public String getStrVip() {
        return strVip;
    }

    public void setStrVip(String strVip) {
        this.strVip = strVip;
    }

    public void setStrSort(String strSort) {
        this.strSort = strSort;
    }
}
