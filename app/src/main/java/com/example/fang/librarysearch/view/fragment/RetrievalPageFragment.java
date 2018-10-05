package com.example.fang.librarysearch.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fang.librarysearch.Controler.RequestControler;
import com.example.fang.librarysearch.R;
import com.example.fang.librarysearch.mode.Request;
import com.example.fang.librarysearch.standard.StandardSet;
import com.example.fang.librarysearch.view.DetailInfoActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 检索界面的Fragment
 */
public class RetrievalPageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.retrieval_page_fragment,
                null, false);
        initComponent((ViewGroup) view);
        return view;
    }

    Button retrievalButton;
    EditText retrievalEdit;

    private void initComponent(final ViewGroup view) {

        retrievalEdit = view.findViewById(R.id.retrievalEdit);
        retrievalButton = view.findViewById(R.id.retrievalButton);

        retrievalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(retrievalEdit.getText())) {
                    Toast.makeText(view.getContext(), "请输入关键字", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    //下面进行检索
                    queryData(retrievalEdit.getText().toString());
                }
            }
        });
    }

    private void queryData(final String text) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                final Request request = new Request(StandardSet.serverMainPage, text);
                try {

                    RequestControler.sinceRetrieval(request, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Log.d("test", "onFailure: 执行出错" + e.getMessage());
                            Toast.makeText(getContext(),
                                    "出现未知错误，请联系开发者或稍后再试",
                                    Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            final String data = response.body().string();

                            //在这里我们跳转到另外一个界面进行显示
                            Log.d("test", "onResponse: 大小" + data.getBytes().length);


                            Intent intent = new Intent(getContext(), DetailInfoActivity.class);
                            // intent.putExtra(StandardSet.responseDataDumpExtraName, data);
                            startActivity(intent);

                            writeFile(data);

                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    /**
     * 将数据写入文件
     *
     * @param data
     */
    private void writeFile(String data) {
        File file = getActivity().getCacheDir();
        File htmlFile = new File(file, StandardSet.saveHtmlName);

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
