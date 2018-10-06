package com.example.fang.librarysearch.view.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.fang.librarysearch.R;
import com.example.fang.librarysearch.Tools.Tools;
import com.example.fang.librarysearch.standard.StandardSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 历史结果的Fragment
 */
public class HistoryFragment extends Fragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("test", "fragment被创建");
        initData();
    }

    SharedPreferences sp;

    @SuppressLint("WrongConstant")
    private void initData() {
        //在这里我们对保存的查询结果进行检索，将检索的数据进行提取
        sp = getContext().getSharedPreferences(StandardSet.sharedPreferencesName, Context.MODE_PRIVATE);
        Set set = new HashSet();
        set = sp.getStringSet(StandardSet.historyName, set);
        nameList = new ArrayList(set);
        Log.d("test", "数据的大小" + nameList.size());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d("test", "onCreateView:被创建 ");
        View view = getLayoutInflater().inflate(R.layout.history_fragment,
                null, false);
        initComponent((ViewGroup) view);
        return view;
    }

    ListView queryHistory;
    MyAdapter myAdapter;
    List nameList;

    private void initComponent(ViewGroup viewGroup) {
        queryHistory = viewGroup.findViewById(R.id.queryHistory);
        queryHistory.setAdapter(myAdapter = new MyAdapter(getContext(), nameList));
        queryHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) myAdapter.getItem(position);
                RetrievalPageFragment.queryData(name, getContext());
            }
        });

        queryHistory.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                //打开一个Dialog
                openDialog(position);

                return true;//消耗该事件
            }
        });
    }

    AlertDialog alertDialog;

    private void openDialog(final int position) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("确定删除吗?");
        builder.setCancelable(true);
        builder.setTitle("删除");
        alertDialog = builder.create();
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,
                "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myAdapter.removeItem(position);

                        alertDialog.dismiss();
                    }
                });
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
                "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });
        alertDialog.show();

    }


    class MyAdapter extends BaseAdapter {

        Context context;
        List<String> bookNames;

        MyAdapter(Context context, List<String> bookName) {
            this.context = context;
            this.bookNames = bookName;

        }

        @Override
        public int getCount() {
            return bookNames.size();
        }

        @Override
        public Object getItem(int position) {
            return bookNames.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public void removeItem(int position) {
            //删除源数据
            Set<String> set = new HashSet<>();
            set = sp.getStringSet(StandardSet.historyName, set);
            Set set1 = new HashSet(set);
            set1.remove(nameList.get(position));
            SharedPreferences.Editor editor = sp.edit();
            editor.putStringSet(StandardSet.historyName, set1);
            editor.commit();
            nameList.remove(position);
            this.notifyDataSetChanged();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String bookName = bookNames.get(position);

            MyHolder myHolder;
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.bookname_sub, parent, false);
                myHolder = new MyHolder();
                myHolder.bookNameDis = convertView.findViewById(R.id.bookname_sub_name);
                convertView.setTag(myHolder);
            } else {
                myHolder = (MyHolder) convertView.getTag();
            }
            myHolder.bookNameDis.setText(bookName);

            return convertView;
        }


        class MyHolder {
            TextView bookNameDis;
        }
    }

}
