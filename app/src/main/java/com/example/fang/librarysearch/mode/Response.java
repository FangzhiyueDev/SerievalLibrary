package com.example.fang.librarysearch.mode;

public class Response {

    /**
     * 响应的数据
     */
    private String responseDate;

    /**
     * 由于读取的数据存放在文件中，该域存放的是文件的路径和名称
     */
    private String fileName;


    public Response(String responseDate, String fileName) {
        this.responseDate = responseDate;
        this.fileName = fileName;
    }

    public Response(String fileName) {
        this.fileName = fileName;
    }

    public String getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(String responseDate) {
        this.responseDate = responseDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
