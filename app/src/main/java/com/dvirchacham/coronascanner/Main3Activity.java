package com.dvirchacham.coronascanner;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Main3Activity extends MainActivity {

    private AdView mAdView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView3 = findViewById(R.id.adView3);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView3.loadAd(adRequest);


        String name2 = "";
        boolean maleee = false, femaleee = false;
        int howMuch = 1;
        Intent ii = getIntent();
        Bundle bb = ii.getExtras();
        TextView result = (TextView) findViewById(R.id.textView5);
        TextView joke = (TextView) findViewById(R.id.textView2);


        if(bb!=null){
            name2 = (String) bb.get("Person's name");
            howMuch = (int) bb.get("How sick");
            maleee = (boolean)bb.get("male?");
            femaleee = (boolean) bb.get("female?");
        }

        if(maleee)
            result.setText(name2 + ", אתה " + howMuch + "% קורונה!");
        else
            result.setText(name2 + ", את " + howMuch + "% קורונה!");


        if(maleee){
            if(howMuch>=1 && howMuch<=10)
                joke.setText("מפחיד זה בטח לא");

            if(howMuch>=11 && howMuch<=20)
                joke.setText("נו, ישנן צרות גרועות יותר");

            if(howMuch>=21 && howMuch<=30)
                joke.setText("עברנו את צהל, נעבור גם את זה");

            if(howMuch>=31 && howMuch<=40)
                joke.setText("אולי כדאי ללכת לבדיקה...");

            if(howMuch>=41 && howMuch<=50)
                joke.setText("איך להירפא מקורונה? רגע זה לא גוגל!");

            if(howMuch>=51 && howMuch<=60)
                joke.setText("איך כותבים צוואה? רגע זה לא גוגל!");

            if(howMuch>=61 && howMuch<=70)
                joke.setText("כל שיעול שלך זה סכנת נפשות תאמין לי");

            if(howMuch>=71 && howMuch<=80)
                joke.setText("מרוב שאתה מדבק אפילו השב''כ לא עוקב אחריך");

            if(howMuch>=81 && howMuch<=90)
                joke.setText("מגיפה מהלכת, זה מה שאתה");

            if(howMuch>=91 && howMuch<=100)
                joke.setText("ביי אחי.");

        }

        else{
            if(howMuch>=1 && howMuch<=10)
                joke.setText("מפחיד זה בטח לא");

            if(howMuch>=11 && howMuch<=20)
                joke.setText("נו, ישנן צרות גרועות יותר");

            if(howMuch>=21 && howMuch<=30)
                joke.setText("עברנו את צהל, נעבור גם את זה");

            if(howMuch>=31 && howMuch<=40)
                joke.setText("אולי כדאי ללכת לבדיקה...");

            if(howMuch>=41 && howMuch<=50)
                joke.setText("איך להירפא מקורונה? רגע זה לא גוגל!");

            if(howMuch>=51 && howMuch<=60)
                joke.setText("איך כותבים צוואה? רגע זה לא גוגל!");

            if(howMuch>=61 && howMuch<=70)
                joke.setText("כל שיעול שלך זה סכנת נפשות תאמיני לי");

            if(howMuch>=71 && howMuch<=80)
                joke.setText("מרוב שאת מדבקת אפילו השב''כ לא עוקב אחריך");

            if(howMuch>=81 && howMuch<=90)
                joke.setText("מגיפה מהלכת, זה מה שאת");

            if(howMuch>=91 && howMuch<=100)
                joke.setText("ביי אחותי.");

        }

        /*

        if(howMuch>=51 && howMuch<=55)
            joke.setText("");

        if(howMuch>=56 && howMuch<=60)
            joke.setText("");

        if(howMuch>=61 && howMuch<=65)
            joke.setText("");

        if(howMuch>=66 && howMuch<=70)
            joke.setText("");

        if(howMuch>=71 && howMuch<=75)
            joke.setText("");

        if(howMuch>=76 && howMuch<=80)
            joke.setText("");

        if(howMuch>=81 && howMuch<=85)
            joke.setText("");

        if(howMuch>=86 && howMuch<=90)
            joke.setText("");

        if(howMuch>=91 && howMuch<=95)
            joke.setText("");

        if(howMuch>=96 && howMuch<=100)
            joke.setText("");

*/





    }

}
