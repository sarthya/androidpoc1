package com.me.sarthya.sundar_kand;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //TextView helloText;
    Button sundarKandButton;
    Intent sundarKandIntent;

    Button hanumanChalisaButton;
    Intent hanumanChalisaIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface hindiFont = Typeface.createFromAsset(getAssets(), "fonts/KRDV021.TTF");

        //helloText = (TextView) findViewById(R.id.helloText);
       // helloText.setTypeface(hindiFont);
        sundarKandButton  = (Button)findViewById(R.id.sundarKandButton);
        sundarKandIntent = new Intent(getApplicationContext(), SundarKandActivity.class);

        hanumanChalisaButton  = (Button)findViewById(R.id.hanumanChalisaButton);
        hanumanChalisaIntent = new Intent(getApplicationContext(), HanumanChalisaActivity.class);

        sundarKandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(sundarKandIntent);
            }
        });

        hanumanChalisaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(hanumanChalisaIntent);
            }
        });

    }
}
