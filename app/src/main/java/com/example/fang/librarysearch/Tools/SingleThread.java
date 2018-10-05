package com.example.fang.librarysearch.Tools;

/**
 * 单线程
 */
public class SingleThread extends Thread {


    private static SingleThread uiThread;

    public static SingleThread getInstance() {

        if (uiThread == null) {
            synchronized (SingleThread.class) {
                uiThread = new SingleThread();
            }
        }
        return uiThread;
    }


}
