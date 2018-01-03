package com.example.a1008.exercise4_1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Time;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    private static String DATABASE_TABLE = "course";
    private SQLiteDatabase db;
    private Database dbHelper;

    private EditText Name,week,STime,ETime;
    private Button delete,submit;
    //private Bundle bundle;
    private String Type,sCID,sweek,sName,sSTime,sETime;

    private Intent intent = new Intent();
    private Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        db = new Database(this).getWritableDatabase();

        bundle = this.getIntent().getExtras();
        Type = bundle.getString("Type");

        Name = (EditText) findViewById(R.id.edit_Name);
        week = (EditText) findViewById(R.id.edit_Week);
        STime = (EditText) findViewById(R.id.edit_STime);
        ETime = (EditText) findViewById(R.id.edit_ETime);

        delete = (Button) findViewById(R.id.btn_delete);
        submit = (Button) findViewById(R.id.btn_submit);

        if(Type.equals("update")){
            sCID = bundle.getString("CID");
            sName = bundle.getString("name");
            sweek = bundle.getString("week");
            sSTime = bundle.getString("stime");
            sETime = bundle.getString("etime");

            Name.setText(sName);
            week.setText(sweek);
            STime.setText(sSTime);
            ETime.setText(sETime);

            delete.setVisibility(View.VISIBLE);
        }

        delete.setOnClickListener(this);
        submit.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.btn_submit:
                if(Type.equals("add")){
                    db.execSQL("INSERT INTO "+DATABASE_TABLE+" (Name,Week,STime,ETime) VALUES ("
                    +"'"+Name.getText().toString()+"',"+"'"+week.getText().toString()+"',"
                    +"'"+STime.getText().toString()+"',"+"'"+ETime.getText().toString()+"')");

                    intent.setClass(AddActivity.this,Main2Activity.class);
                    bundle.putString("Time", week.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                    this.finish();
                }
                else{
                    db.execSQL("UPDATE "+DATABASE_TABLE+
                            " SET Name="+"'"+Name.getText().toString()+"',"+
                            "Week="+"'"+week.getText().toString()+"',"+
                            "STime="+"'"+STime.getText().toString()+"',"+
                            "ETime="+"'"+ETime.getText().toString()+"'"+
                            " WHERE CID="+"'"+sCID+"'");

                    intent.setClass(AddActivity.this,Main2Activity.class);
                    bundle.putString("Time", week.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                    this.finish();

                }
                break;
            case R.id.btn_delete:
                db.execSQL("DELETE FROM "+DATABASE_TABLE+" WHERE CID="+"'"+sCID+"'");
                intent.setClass(AddActivity.this,Main2Activity.class);
                bundle.putString("Time", week.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
                this.finish();
                break;
        }
    }
}
