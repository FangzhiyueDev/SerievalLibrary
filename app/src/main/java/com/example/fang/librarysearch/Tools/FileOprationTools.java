package com.example.fang.librarysearch.Tools;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class FileOprationTools {


    /**
     * 将数据写入文件
     *
     * @param data
     */
    public static void writeFile(Context context, String data, String saveHtmlName) {
        File file = context.getCacheDir();
        File htmlFile = new File(file, saveHtmlName);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data.getBytes());
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        BufferedWriter bufferedWriter = null;
        try {
            htmlFile.createNewFile();
            char[] chars = new char[1024];
            int len;
            bufferedWriter = new BufferedWriter(new FileWriter(htmlFile));
            while ((len = bufferedReader.read(chars)) != -1) {
                bufferedWriter.write(chars, 0, len);
            }

            bufferedWriter.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                bufferedReader.close();
                bufferedWriter.close();
                inputStreamReader.close();
                byteArrayInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
