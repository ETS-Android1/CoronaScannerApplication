package com.dvirchacham.coronascanner;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Main2Activity extends MainActivity {

    private AdView mAdView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView2 = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest);


        String name1= "";
        boolean malee = false, femalee = false;
        Intent i = getIntent();
        Bundle b = i.getExtras();
        TextView result = (TextView) findViewById(R.id.textView4);
        TextView say = (TextView) findViewById(R.id.textView7);

        if(b!=null){
            name1 = (String) b.get("Person's name");
            malee = (boolean) b.get("male?");
            femalee = (boolean) b.get("female?");
        }

        if(malee) {
            result.setText(name1 + ", אתה 0% קורונה!");
        }

        else {
            result.setText(name1 + ", את 0% קורונה!");
            say.setText("תאמיני לי, הלוואי על כולנו כמוך");
        }
        }

    }


