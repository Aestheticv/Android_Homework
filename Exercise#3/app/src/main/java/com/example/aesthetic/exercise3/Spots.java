package com.example.aesthetic.exercise3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Spots extends AppCompatActivity implements View.OnClickListener {

    int SID;
    String spot;

    TextView SpotName,SpotIntro;
    ImageView SpotImg;
    Button Map,Web,Tel;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spots);

        bundle = this.getIntent().getExtras();
        SID = bundle.getInt("SID");
        spot = bundle.getString("SpotName");

        SpotName = (TextView) findViewById(R.id.textView_SpotName);
        SpotIntro = (TextView) findViewById(R.id.textView_SpotIntro);
        SpotImg = (ImageView) findViewById(R.id.imageView_SoptImg);
        Map = (Button) findViewById(R.id.button_Map);
        Web = (Button) findViewById(R.id.button_Website);
        Tel = (Button) findViewById(R.id.button_Tel);

        Map.setOnClickListener(this);
        Web.setOnClickListener(this);
        Tel.setOnClickListener(this);

        switch (SID){
            case 0:
                SpotName.setText(spot);
                SpotIntro.setText(R.string.Taroko);
                SpotImg.setImageResource(R.mipmap.p0);
                break;
            case 1:
                SpotName.setText(spot);
                SpotIntro.setText(R.string.Shei_Pa);
                SpotImg.setImageResource(R.mipmap.p1);
                break;
            case 2:
                SpotName.setText(spot);
                SpotIntro.setText(R.string.Yushan);
                SpotImg.setImageResource(R.mipmap.p2);
                break;
            case 3:
                SpotName.setText(spot);
                SpotIntro.setText(R.string.Kenting);
                SpotImg.setImageResource(R.mipmap.p3);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Uri uri;
        Intent intent;

        switch(id){
            case R.id.button_Map:
                switch (SID){
                    case 0:
                        uri = Uri.parse("geo:24.1581285,121.6221393");
                        intent = new Intent(Intent.ACTION_VIEW,uri);
                        startActivity(intent);
                        break;
                    case 1:
                        uri = Uri.parse("geo:24.3624183,121.1230249");
                        intent = new Intent(Intent.ACTION_VIEW,uri);
                        startActivity(intent);
                        break;
                    case 2:
                        uri = Uri.parse("geo:23.6361461,120.7716532");
                        intent = new Intent(Intent.ACTION_VIEW,uri);
                        startActivity(intent);
                        break;
                    case 3:
                        uri = Uri.parse("geo:21.9494156,120.7793374");
                        intent = new Intent(Intent.ACTION_VIEW,uri);
                        startActivity(intent);
                        break;
                }
                break;
            case R.id.button_Website:
                switch (SID){
                    case 0:
                        uri = Uri.parse("http://old.taroko.gov.tw/English/");
                        intent = new Intent(Intent.ACTION_VIEW,uri);
                        startActivity(intent);
                        break;
                    case 1:
                        uri = Uri.parse("http://www.spnp.gov.tw/v2/default.aspx?lang=1");
                        intent = new Intent(Intent.ACTION_VIEW,uri);
                        startActivity(intent);
                        break;
                    case 2:
                        uri = Uri.parse("http://www.ysnp.gov.tw/css_en/default.aspx");
                        intent = new Intent(Intent.ACTION_VIEW,uri);
                        startActivity(intent);
                        break;
                    case 3:
                        uri = Uri.parse("http://www.ktnp.gov.tw/en/Default.aspx");
                        intent = new Intent(Intent.ACTION_VIEW,uri);
                        startActivity(intent);
                        break;
                }
                break;
            case R.id.button_Tel:
                switch (SID){
                    case 0:
                        uri = Uri.parse("tel:+88638621100");
                        intent = new Intent(Intent.ACTION_DIAL,uri);
                        startActivity(intent);
                        break;
                    case 1:
                        uri = Uri.parse("tel:+88637996100");
                        intent = new Intent(Intent.ACTION_DIAL,uri);
                        startActivity(intent);
                        break;
                    case 2:
                        uri = Uri.parse("tel:+886492773121");
                        intent = new Intent(Intent.ACTION_DIAL,uri);
                        startActivity(intent);
                        break;
                    case 3:
                        uri = Uri.parse("tel:+88688861321");
                        intent = new Intent(Intent.ACTION_DIAL,uri);
                        startActivity(intent);
                        break;
                }
                break;
        }
    }
}