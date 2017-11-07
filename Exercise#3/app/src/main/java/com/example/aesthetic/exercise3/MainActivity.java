package com.example.aesthetic.exercise3;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView spots;
    String [] country = new String[] {"Xiulin,Hualien","Wufeng,Hsinchu","Shuili,Nantou","Hengchun,Pingtung"};
    String [] spot = new String[] {"Taroko National Park","Shei-Pa National Park","Yushan National Park","Kenting National Park"};

    int SID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spots = (ListView) findViewById(R.id.PostList);
        MyAdapter adapter = new MyAdapter(this);
        spots.setAdapter(adapter);

        final Intent intent = new Intent();
        final Bundle bundle = new Bundle();

        spots.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // TODO Auto-generated method stub
                SID = position;
                intent.setClass(MainActivity.this,Spots.class);
                bundle.putInt("SID",SID);
                bundle.putString("SpotName",spot[position]);
                intent.putExtras(bundle);
                startActivity(intent);
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
        if (id == R.id.about) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Editor");
            dialog.setMessage(" 610521213 Chang-Ho");
            dialog.setPositiveButton("Confirm",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    // TODO Auto-generated method stub
                }
            });
            dialog.show();
            return true;
        }
        if (id == R.id.exit) {
            this.finish();
            return true;
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
            return country.length;
        }

        @Override
        public Object getItem(int i) {
            return country[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = inflater.inflate(R.layout.layout_adapter,null);
            TextView TV_Country,TV_Spot;

            TV_Country = (TextView) view.findViewById(R.id.textView_Country);
            TV_Spot = (TextView) view.findViewById(R.id.textView_Spot);

            TV_Country.setText(country[i]);
            TV_Spot.setText(spot[i]);
            return view;
        }
    }
}