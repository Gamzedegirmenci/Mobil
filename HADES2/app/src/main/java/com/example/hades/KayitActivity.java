package com.example.hades;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.se.omapi.Session;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class KayitActivity extends AppCompatActivity {
    Button button1;
    Button startActivity;
    EditText edittext;
    EditText edittext1;
    EditText edittext2;
    EditText edittext3;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
        button1=(Button)findViewById(R.id.btnfurther);
        edittext=(EditText)findViewById(R.id.edtTxtTc);
        edittext1=(EditText)findViewById(R.id.edttextname);
        edittext2=(EditText)findViewById(R.id.edttextsurname);
        edittext3=(EditText)findViewById(R.id.edttxtdate);
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = preferences.edit();
        KayitActivity activity=this;

        if(preferences.getBoolean("login", false)){
            Intent i = new Intent(getApplicationContext(),HelpActivity.class);
            startActivity(i);
            finish();
        }
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tc = edittext.getText().toString();
                String name = edittext1.getText().toString();
                String surname=edittext2.getText().toString();
                String date=edittext3.getText().toString();
                if(tc.matches("") || name.matches("")|| surname.matches("")||date.matches("")){

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(KayitActivity.this);
                    alertDialog.setTitle("Uyarı");
                    alertDialog.setMessage(getString(R.string.text));
                    alertDialog.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int which) {

                        }
                    });
                    alertDialog.show();
                }
                else{

                    preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    editor = preferences.edit();


                    editor.putString("tc", tc);
                    editor.putString("name", name);
                    editor.putString("surname", surname);
                    editor.putString("date",date);
                    editor.putBoolean("login", true);

                    editor.commit();
                    Intent i = new Intent(getApplicationContext(),HelpActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });

            }
        }
