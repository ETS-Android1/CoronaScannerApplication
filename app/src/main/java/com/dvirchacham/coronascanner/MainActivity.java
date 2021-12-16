package com.dvirchacham.coronascanner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.media.ToneGenerator;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import java.lang.Object;
import android.app.Dialog;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends AppCompatActivity {

    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        final ToneGenerator beep = new ToneGenerator(1,1000);
        Button scanner = (Button) findViewById(R.id.button1);
        final CheckBox check1 = (CheckBox) findViewById(R.id.checkBox);
        final CheckBox check2 = (CheckBox) findViewById(R.id.checkBox2);
        final CheckBox check3 = (CheckBox) findViewById(R.id.checkBox3);
        final EditText nameBox = (EditText) findViewById(R.id.editText1);
        final Intent healthy = new Intent(MainActivity.this, Main2Activity.class);
        final Intent sick = new Intent(MainActivity.this, Main3Activity.class);
        final RadioButton male = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton female = (RadioButton) findViewById(R.id.radioButton3);

        final SharedPreferences settings = getSharedPreferences("check first", 0);

        AlertDialog.Builder agree = new AlertDialog.Builder(this);
        agree.setCancelable(false);
        agree.setMessage("אפליקציה זו הינה הומוריסטית לחלוטין. היא אינה מתיימרת להיות כלי רפואי באשר הוא ואין לקחת תוצאותיה ברצינות.");
        agree.setPositiveButton("הבנתי", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                settings.edit().putBoolean("agreement", true).commit();
            }
        });


        if(!settings.getBoolean("agreement", false))
            agree.create().show();


        scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String name = nameBox.getText().toString();

                beep.startTone(1,1000);
                SystemClock.sleep(2000);
                beep.startTone(1,1000);
                SystemClock.sleep(2000);
                beep.startTone(1,2500);
                SystemClock.sleep(3000);
                beep.startTone(28,1000);
                SystemClock.sleep(1000);

                Toast.makeText(getApplicationContext(), "מחשב... תוצאות יהיו מוכנות בעוד 3", Toast.LENGTH_SHORT).show();

                Runnable r1 = new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "מחשב... תוצאות יהיו מוכנות בעוד 2", Toast.LENGTH_SHORT).show();
                    }
                };

                Runnable r2 = new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "מחשב... תוצאות יהיו מוכנות בעוד 1", Toast.LENGTH_SHORT).show();
                    }
                };

                Runnable r3 = new Runnable() {
                    @Override
                    public void run() {

                        boolean isMale = male.isChecked(), isFemale = female.isChecked();

                        int randNum = (int) ((Math.random() * 9)) + 1;

                        if(check1.isChecked() && check2.isChecked() && check3.isChecked()) {
                            if (randNum == 9 || randNum == 10) {
                                healthy.putExtra("Person's name", name);
                                healthy.putExtra("male?", isMale);
                                healthy.putExtra("female?", isFemale);
                                startActivity(healthy);
                            }
                            else {
                                int percentage = (int) ((Math.random() * 20)) + 80;
                                sick.putExtra("Person's name", name);
                                sick.putExtra("How sick", percentage );
                                sick.putExtra("male?", isMale);
                                sick.putExtra("female?", isFemale);
                                startActivity(sick);
                            }
                        }

                        else
                        if((check1.isChecked() && check2.isChecked()) || (check1.isChecked() && check3.isChecked()) || (check2.isChecked() && check3.isChecked()) ) {
                            if (randNum == 7 || randNum == 8 || randNum == 9 || randNum == 10) {
                                healthy.putExtra("Person's name", name);
                                healthy.putExtra("male?", isMale);
                                healthy.putExtra("female?", isFemale);
                                startActivity(healthy);
                            }
                            else {
                                int percentage = (int) ((Math.random() * 39)) + 40;
                                sick.putExtra("Person's name", name);
                                sick.putExtra("How sick", percentage );
                                sick.putExtra("male?", isMale);
                                sick.putExtra("female?", isFemale);
                                startActivity(sick);
                            }
                        }

                        else
                        if(check1.isChecked() || check2.isChecked() || check3.isChecked()) {
                            if (randNum == 5 ||randNum == 6 || randNum == 7 || randNum == 8 || randNum == 9 || randNum == 10) {
                                healthy.putExtra("Person's name", name);
                                healthy.putExtra("male?", isMale);
                                healthy.putExtra("female?", isFemale);
                                startActivity(healthy);
                            }
                            else {
                                int percentage = (int) ((Math.random() * 28)) + 11;
                                sick.putExtra("Person's name", name);
                                sick.putExtra("How sick", percentage );
                                sick.putExtra("male?", isMale);
                                sick.putExtra("female?", isFemale);
                                startActivity(sick);
                            }
                        }


                        else
                        if(!check1.isChecked() && !check2.isChecked() && !check3.isChecked()) {
                            if (randNum == 3 ||randNum == 4 ||randNum == 5 ||randNum == 6 || randNum == 7 || randNum == 8 || randNum == 9 || randNum == 10) {
                                healthy.putExtra("Person's name", name);
                                healthy.putExtra("male?", isMale);
                                healthy.putExtra("female?", isFemale);
                                startActivity(healthy);
                            }
                            else {
                                int percentage = (int) ((Math.random() * 9)) + 1;
                                sick.putExtra("Person's name", name);
                                sick.putExtra("How sick", percentage );
                                sick.putExtra("male?", isMale);
                                sick.putExtra("female?", isFemale);
                                startActivity(sick);
                            }
                        }

                    }
                };

                Handler h1 = new Handler();
                h1.postDelayed(r1, 2000);

                Handler h2 = new Handler();
                h2.postDelayed(r2, 4000);


                Handler h3 = new Handler();
                h3.postDelayed(r3, 6400);


            }
        });


    }

}
