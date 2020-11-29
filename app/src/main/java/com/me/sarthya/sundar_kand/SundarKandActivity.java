package com.me.sarthya.sundar_kand;

import android.content.res.Configuration;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SundarKandActivity extends AppCompatActivity {

    TextView dataText;
    JSONObject object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sundar_kand);


        dataText = (TextView) findViewById(R.id.dataText);
       /* object = loadJsonData();
        String str;
        try {
            str = object.get("item_1").toString()+ object.get("item_2").toString();
            dataText.setText(str);
        }catch (Exception e){

        }*/
        InputStream inputStream = null;
        try {
            inputStream = getAssets().open("data.txt");
        } catch (Exception e) {
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        String myText = "";
        int in;
        try {
            in = inputStream.read();
            while (in != -1) {
                byteArrayOutputStream.write(in);
                in = inputStream.read();
            }
            inputStream.close();

            myText = byteArrayOutputStream.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataText.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                getResources().getDimension(R.dimen.textsize));
        dataText.setText(myText);

    }

    private JSONObject loadJsonData() {
        JSONObject object;
        try {
            object = new JSONObject(loadJSONFromAsset());
        } catch (Exception e) {
            e.printStackTrace();
            object = null;
        }
        return object;
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
