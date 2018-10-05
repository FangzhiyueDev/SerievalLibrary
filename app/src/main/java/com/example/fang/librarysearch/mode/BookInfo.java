package com.example.fang.librarysearch.mode;


/**
 * [{书名,作者，出版社，出版时间，ISBN，索书号，分类号，页数，价格，复本数，在馆数，累借天数，累借次数，描述}]
 */
public class BookInfo {

    private String bookName;
    private String author;
    private String press;
    private String publishingTime;
    private String ISBN;
    private String callNumber;
    private String classificationNumber;
    private String pageCount;
    private String price;
    private String duplicateNumber;
    private String inLibraryNumber;
    private String loadDays;
    private String loadCount;
    private String distribution;
    private String bookInfoS;


    public BookInfo() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getPublishingTime() {
        return publishingTime;
    }

    public void setPublishingTime(String publishingTime) {
        this.publishingTime = publishingTime;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public String getClassificationNumber() {
        return classificationNumber;
    }

    public void setClassificationNumber(String classificationNumber) {
        this.classificationNumber = classificationNumber;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDuplicateNumber() {
        return duplicateNumber;
    }

    public void setDuplicateNumber(String duplicateNumber) {
        this.duplicateNumber = duplicateNumber;
    }

    public String getInLibraryNumber() {
        return inLibraryNumber;
    }

    public void setInLibraryNumber(String inLibraryNumber) {
        this.inLibraryNumber = inLibraryNumber;
    }

    public String getLoadDays() {
        return loadDays;
    }

    public void setLoadDays(String loadDays) {
        this.loadDays = loadDays;
    }

    public String getLoadCount() {
        return loadCount;
    }

    public void setLoadCount(String loadCount) {
        this.loadCount = loadCount;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    public BookInfo(String bookName, String author, String press, String publishingTime, String ISBN, String callNumber, String classificationNumber, String pageCount, String price, String duplicateNumber, String inLibraryNumber, String loadDays, String loadCount, String distribution) {
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.publishingTime = publishingTime;
        this.ISBN = ISBN;
        this.callNumber = callNumber;
        this.classificationNumber = classificationNumber;
        this.pageCount = pageCount;
        this.price = price;
        this.duplicateNumber = duplicateNumber;
        this.inLibraryNumber = inLibraryNumber;
        this.loadDays = loadDays;
        this.loadCount = loadCount;
        this.distribution = distribution;
    }

    /**
     * bookInfo存放的是所有的关键信息
     *
     * 解析书籍的各种信息
     * {“作者”,"出版社","出版时间","ISBN","索书号","分页号","页数","价格","副本数","在馆数","累借    * 天数","累借次数"}
     * @param bookInfo
     */

    public void setBookInfo(String bookInfo) {
        this.bookInfoS = bookInfo;
    }

    public String getBookInfo() {
        return bookInfoS;
    }
}
