package com.example.fang.librarysearch.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fang.librarysearch.R;

import java.util.List;

/**
 * 历史结果的Fragment
 */
public class HistoryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.history_fragment,
                null, false);
        initComponent((ViewGroup) view);
        return view;
    }

    ListView queryHistory;

    private void initComponent(ViewGroup viewGroup) {
        queryHistory = viewGroup.findViewById(R.id.queryHistory);
        queryHistory.setAdapter();
        queryHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }


    class MyAdapter extends BaseAdapter {

        Context context;
        List<String> bookName;

        MyAdapter(Context context, List<String> bookName) {
            this.context = context;
            this.bookName = bookName;

        }

        @Override
        public int getCount() {
            return bookName.size();
        }

        @Override
        public Object getItem(int position) {
            return bookName.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MyHolder myHolder;
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.bookname_sub, parent, false);
                myHolder = new MyHolder();
                myHolder.bookNameDis = convertView.findViewById(R.id.bookname_sub_name);
            }

            return null;
        }


        class MyHolder {
            TextView bookNameDis;
        }
    }

}
