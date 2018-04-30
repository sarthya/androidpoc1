package com.me.sarthya.sundar_kand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HanumanChalisaActivity extends AppCompatActivity {
    TextView dataText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_hanuman_chalisa);

        dataText = (TextView) findViewById(R.id.dataText1);
       /* object = loadJsonData();
        String str;
        try {
            str = object.get("item_1").toString()+ object.get("item_2").toString();
            dataText.setText(str);
        }catch (Exception e){

        }*/
        InputStream inputStream = null;
        try {
            inputStream = getAssets().open("data_chalisa.txt");
        }catch (Exception e){}
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        String myText = "";
        int in;
        try {
            in = inputStream.read();
            while (in != -1)
            {
                byteArrayOutputStream.write(in);
                in = inputStream.read();
            }
            inputStream.close();

            myText = byteArrayOutputStream.toString();
        }catch (IOException e) {
            e.printStackTrace();
        }

        dataText.setText(myText);

    }
}
