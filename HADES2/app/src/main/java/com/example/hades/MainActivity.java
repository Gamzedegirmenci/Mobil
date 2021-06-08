

package com.example.hades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.session.MediaSessionManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.se.omapi.Session;
import android.view.View;
import android.view.contentcapture.ContentCaptureSessionId;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Locale locale = Locale.getDefault();
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        b1=(Button)findViewById(R.id.btntr);
        b2=(Button)findViewById(R.id.btnen);
        b3=(Button)findViewById(R.id.btnarapca);
        b4=(Button)findViewById(R.id.btnfarsca);
        b5=(Button)findViewById(R.id.btnrusca);
        b6=(Button)findViewById(R.id.btnfr);
        b7=(Button)findViewById(R.id.btnalmanca);
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = preferences.edit();
        MainActivity activity=this;
        if(preferences.getBoolean("login", false)){
            Intent i = new Intent(getApplicationContext(),HelpActivity.class);
            startActivity(i);
            finish();
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
            String tr = b1.getText().toString();
                preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                editor = preferences.edit();
                editor.putString("tr", tr);
                editor.putBoolean("login", true);
                editor.commit();
                Intent git = new Intent(MainActivity.this, KayitActivity.class);
                startActivity(git);
                activity.finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                finish();
                startActivity(getIntent());
                String en = b2.getText().toString();
                preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                editor = preferences.edit();
                editor.putString("en", en);
                editor.putBoolean("login", true);
                editor.commit();
                Intent git = new Intent(MainActivity.this, KayitActivity.class);
                startActivity(git);
                activity.finish();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("ar");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                finish();
                startActivity(getIntent());
                String ar = b3.getText().toString();
                preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                editor = preferences.edit();
                editor.putString("ar", ar);
                editor.putBoolean("login", true);
                editor.commit();
                Intent git = new Intent(MainActivity.this, KayitActivity.class);
                startActivity(git);
                activity.finish();

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("fa");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                finish();
                startActivity(getIntent());
                String fa = b4.getText().toString();
                preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                editor = preferences.edit();
                editor.putString("fa", fa);
                editor.putBoolean("login", true);
                editor.commit();
                Intent git = new Intent(MainActivity.this, KayitActivity.class);
                startActivity(git);
                activity.finish();

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("ru");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                finish();
                startActivity(getIntent());
                String ru = b5.getText().toString();
                preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                editor = preferences.edit();
                editor.putString("ru", ru);
                editor.putBoolean("login", true);
                editor.commit();
                Intent git = new Intent(MainActivity.this, KayitActivity.class);
                startActivity(git);
                activity.finish();

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("fr");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                finish();
                startActivity(getIntent());
                String fr = b6.getText().toString();
                preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                editor = preferences.edit();
                editor.putString("fr", fr);
                editor.putBoolean("login", true);
                editor.commit();
                Intent git = new Intent(MainActivity.this, KayitActivity.class);
                startActivity(git);
                activity.finish();

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("de");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                finish();
                startActivity(getIntent());
                String de = b7.getText().toString();
                preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                editor = preferences.edit();
                editor.putString("de", de);
                editor.putBoolean("login", true);
                editor.commit();
                Intent git = new Intent(MainActivity.this, KayitActivity.class);
                startActivity(git);
                activity.finish();

            }
        });
    }
}