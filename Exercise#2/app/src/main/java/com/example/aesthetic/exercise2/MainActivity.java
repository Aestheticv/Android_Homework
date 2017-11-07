package com.example.aesthetic.exercise2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private EditText Edit_name;
    private Button Btn_Submit;
    private Spinner Spinner_edu;
    private RadioGroup blood;
    private String blood_type,education,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Edit_name = (EditText) findViewById(R.id.edit_name);

        Spinner_edu= (Spinner)findViewById(R.id.spinner_edu);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.edu_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_edu.setAdapter(adapter);
        Spinner_edu.setOnItemSelectedListener(this);

        blood = (RadioGroup)findViewById(R.id.radio_group);

        Btn_Submit = (Button)findViewById(R.id.button2);
        Btn_Submit.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {

        name = Edit_name.getText().toString();

        if(blood.getCheckedRadioButtonId()==-1)
        {
            Toast.makeText(getApplicationContext(), "Please select blood type", Toast.LENGTH_SHORT).show();
        }
        else
        {
            // get selected radio button from radioGroup
            int selectedId = blood.getCheckedRadioButtonId();
            // find the radiobutton by returned id
            if(selectedId == R.id.radio_O){
                blood_type = "O";
            }
            else if(selectedId == R.id.radio_A){
                blood_type = "A";
            }
            else if(selectedId == R.id.radio_B){
                blood_type = "B";
            }
            else if(selectedId == R.id.radio_AB){
                blood_type = "AB";
            }
        }

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("");
        dialog.setMessage(name+"血型是"+blood_type+"，學歷是"+education);
        dialog.setPositiveButton("確認",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // TODO Auto-generated method stub
            }

        });
        dialog.setNeutralButton("取消",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // TODO Auto-generated method stub
            }

        });
        dialog.show();
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        education = String.valueOf(adapterView.getSelectedItem());  //取得選取的ID ; 若要取得選取的文字,可改用getSelectedItem()

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
