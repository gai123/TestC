package com.gai.testc;

import android.content.Context;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RelativeLayout constraintLayout;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TRelativeLayout trl = (TRelativeLayout) findViewById(R.id.trl);
        List<Map<String, Object>> map = getData();
        MyAdapter baseAdapter = new MyAdapter(this,createViewByBean());

        Log.i("tag",createViewByBean()+"");
        Log.i("tag",baseAdapter.getCount()+"");
        trl.setmTagAdapter(baseAdapter);

    }


    public List<Item> createViewByBean() {
        List<Item> lists = new ArrayList<>();
        Item item = new Item(0, 0);
        item.setTag("1");
        item.setLeftof("2");
        lists.add(item);
        Log.i("tag",lists+"");
        Item item2 = new Item(0, 0);
        item2.setTag("2");
        item2.setRightof("1");
        lists.add(item2);
        Log.i("tag",lists+"");
        return lists;

    }


    class MyAdapter<Item> extends ItemAdapter {

        private Context context;

        public MyAdapter(Context context, List<Item> datas) {
            super(datas);
            this.context = context;
        }



        @Override
        public View getView(TRelativeLayout parent, int position) {
            return new TextView(context);
        }
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for (int i = 0; i < 10; i++) {
            map = new HashMap<String, Object>();
            map.put("img", R.mipmap.ic_launcher);
            map.put("title", "跆拳道");
            map.put("info", "快乐源于生活...");
            list.add(map);
        }
        return list;
    }
}
