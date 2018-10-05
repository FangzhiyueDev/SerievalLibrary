package com.example.fang.librarysearch.netWork;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.webkit.WebView;



import okhttp3.OkHttpClient;
import okhttp3.Request;


public class NetWorkTools {


//    public static Response sendNetRequest(Request request, Context context) {
//
//        URL url;
//        HttpURLConnection httpURLConnection = null;
//        BufferedReader bufferedInputStream;
//        BufferedWriter bufferedWriter;
//        Response response = null;
//        try {
//            url = new URL(request.getUrl());
//
//            httpURLConnection = (HttpURLConnection) url.openConnection();
//
//            httpURLConnection.setRequestMethod("GET");
//
//            httpURLConnection.setConnectTimeout(6000);
//
//            InputStream inputStream = httpURLConnection.getInputStream();
//
//            httpURLConnection.connect();
//
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//
//            bufferedInputStream = new BufferedReader(inputStreamReader);
//
//            char[] chars = new char[1024];
//
//            int len = 0;
//
//
//            //AssetManager assetManager = context.getResources().getAssets();
//
//
//            bufferedWriter =
//                    new BufferedWriter(
//                            new FileWriter(new File(new URI(StandardSet.responseDateFileName))));
//
//            while ((len = bufferedInputStream.read()) != -1) {
//                bufferedWriter.write(chars, 0, len);
//                Log.d("test", chars.toString());
//            }
//
//            response = new Response(StandardSet.responseDateFileName);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            httpURLConnection.disconnect();
//        }
//
//        return response;
//
//    }



    /**
     * 发送一条Http请求信息
     *
     * @param url
     * @param callback
     */
    public static void sendHttpRequest(String url, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
        Log.d("test", "sendHttpRequest: 执行请求");
    }


}
