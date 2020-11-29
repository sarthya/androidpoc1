package com.me.sarthya.sundar_kand;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
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
        adjustFontScale( getResources().getConfiguration());
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

    public  void adjustFontScale( Configuration configuration) {

        configuration.fontScale = (float) 1.0;
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        metrics.scaledDensity = configuration.fontScale * metrics.density;
        getBaseContext().getResources().updateConfiguration(configuration, metrics);

    }
}
