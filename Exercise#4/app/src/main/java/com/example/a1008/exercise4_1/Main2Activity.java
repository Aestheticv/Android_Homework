package com.example.a1008.exercise4_1;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    private static String DATABASE_TABLE = "course";
    private SQLiteDatabase db;
    private Database dbHelper;
    private ListView list_course;
    private String eweek;
    private Bundle bundle = new Bundle();
    private Intent intent = new Intent();
    private String [] STime = new String[] {"111"};
    private String [] ETime = new String[] {"111"};
    private String [] Name = new String[] {"111"};
    private String [] CID = new String[] {"1"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new Database(this).getWritableDatabase();

        bundle = this.getIntent().getExtras();
        eweek = bundle.getString("Time");

        Cursor c = db.rawQuery("SELECT * FROM " + DATABASE_TABLE + " WHERE Week='"+eweek+"'", null);
        CID = new String[c.getCount()];
        Name = new String[c.getCount()];
        ETime = new String[c.getCount()];
        STime = new String[c.getCount()];
        c.moveToFirst();
        for (int i = 0; i < c.getCount(); i++) {
            CID[i] = c.getString(0);
            Name[i] = c.getString(1);
            ETime[i] = c.getString(4);
            STime[i] = c.getString(3);
            c.moveToNext();  // 下一筆
        }
        c.close();

        list_course = (ListView) findViewById(R.id.list_course);
        MyAdapter adapter = new MyAdapter(this);
        list_course.setAdapter(adapter);
        list_course.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                intent.setClass(Main2Activity.this,AddActivity.class);
                bundle.putString("Type", "update");
                bundle.putString("CID", CID[position]);
                bundle.putString("name", Name[position]);
                bundle.putString("week", eweek);
                bundle.putString("stime", STime[position]);
                bundle.putString("etime", ETime[position]);

                intent.putExtras(bundle);
                startActivity(intent);
                Main2Activity.this.finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            intent.setClass(Main2Activity.this,AddActivity.class);
            bundle.putString("Type", "add");
            intent.putExtras(bundle);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public class MyAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        public MyAdapter(Context c){
            inflater = LayoutInflater.from(c);
        }

        @Override
        public int getCount() {
            return CID.length;
        }

        @Override
        public Object getItem(int i) {
            return CID[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = inflater.inflate(R.layout.layout_adapter2,null);
            TextView text_Name,text_Time;
            text_Name = view.findViewById(R.id.textView_Name);
            text_Time = view.findViewById(R.id.textView_SETime);
            text_Name.setText(Name[i]);
            text_Time.setText(STime[i]+"-"+ETime[i]);
            return view;
        }
    }
}
