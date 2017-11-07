package com.example.aesthetic.temperature_transfer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Transfer extends AppCompatActivity implements View.OnClickListener {

    private Button btn_c,btn_f;
    private EditText edit_temp;
    private TextView text_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        btn_c = (Button) findViewById(R.id.btn_c);
        btn_f = (Button) findViewById(R.id.btn_f);
        edit_temp = (EditText) findViewById(R.id.edit_temp);
        text_result = (TextView) findViewById(R.id.text_result);
        btn_f.setOnClickListener(this);
        btn_c.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.btn_c){
            double temp = Double.parseDouble(edit_temp.getText().toString());
            double answer;
            answer = (temp-32)*5/9;
            text_result.setText(Double.toString(answer)+" ℃");
        }
        if(id == R.id.btn_f){
            double temp = Double.parseDouble(edit_temp.getText().toString());
            double answer;
            answer = temp*9/5+32;
            text_result.setText(Double.toString(answer)+" ℉");
        }
    }
}
