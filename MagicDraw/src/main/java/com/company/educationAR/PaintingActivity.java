package com.company.educationAR;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PaintingActivity extends Activity {
    private List<painting> paintingList = new ArrayList<painting>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paintings);

        //listView
        initPainting();
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new DemoListAdapter());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View v, int index, long arg3) {
                Intent intent = null;
                System.out.println("6");
                intent = new Intent(PaintingActivity.this, pictureActivity.class);
                intent.putExtra("data",demos[index].desc);
                System.out.println("7");
                startActivity(intent);
                System.out.println("ok");
            }
        });
    }
    private void initPainting() {
        painting plane = new painting("plane", R.drawable.plane);
        paintingList.add(plane);
        painting taxi = new painting("taxi", R.drawable.taxi);
        paintingList.add(taxi);
        painting mashroom = new painting("mashroom", R.drawable.mashroom);
        paintingList.add(mashroom);
        painting house = new painting("house", R.drawable.house);
        paintingList.add(house);
        painting elephant = new painting("elephant", R.drawable.elephant);
        paintingList.add(elephant);
        painting apple = new painting("apple", R.drawable.apple);
        paintingList.add(apple);
    }

    private static final DemoInfo[] demos = {
            new DemoInfo(R.string.plane_name, R.drawable.plane),
            new DemoInfo(R.string.taxi_name, R.drawable.taxi),
            new DemoInfo(R.string.mashroom_name, R.drawable.mashroom),
            new DemoInfo(R.string.house_name, R.drawable.house),
            new DemoInfo(R.string.elephant_name, R.drawable.elephant),
            new DemoInfo(R.string.apple_name, R.drawable.apple)
    };

    private class DemoListAdapter extends BaseAdapter {
        public DemoListAdapter() {
            super();
        }
        @SuppressLint("ViewHolder")
        @Override
        public View getView(int index, View convertView, ViewGroup parent) {
            convertView = View.inflate(PaintingActivity.this, R.layout.listitem, null);
            TextView title = (TextView) convertView.findViewById(R.id.name);
            ImageView desc = (ImageView) convertView.findViewById(R.id.image);
            title.setText(demos[index].title);
            desc.setImageResource(demos[index].desc);
            return convertView;
        }

        @Override
        public int getCount() {
            return demos.length;
        }

        @Override
        public Object getItem(int index) {
            return demos[index];
        }

        @Override
        public long getItemId(int id) {
            return id;
        }
    }

    private static class DemoInfo {
        private final int title;
        private final int desc;

        public DemoInfo(int title, int desc) {
            this.title = title;
            this.desc = desc;
        }
    }
    private long firstTime=0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK && event.getAction()==KeyEvent.ACTION_DOWN){
            if (System.currentTimeMillis()-firstTime>2000){
                Toast.makeText(PaintingActivity.this,"Press again to go back",Toast.LENGTH_SHORT).show();
                firstTime=System.currentTimeMillis();
            }else{
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
