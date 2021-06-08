package com.example.hades;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class HelpActivity extends AppCompatActivity {
    ImageView Konumal;
    Button btntlf;
    ImageView telefon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Konumal=(ImageView)findViewById(R.id.imgwivehds);
        btntlf=(Button)findViewById(R.id.btnphone);
        Konumal.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (Build.VERSION.SDK_INT>=23){
                    String[] Konum_İzni= new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};
                    if (!izinkontrol(HelpActivity.this,Konum_İzni)){
                        requestPermissions(Konum_İzni, 200);
                    } else
                        Konumal();
                }else{}

            }
        });
        btntlf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder uyaripenceresi=new AlertDialog.Builder(HelpActivity.this);
                uyaripenceresi.setMessage(getText(R.string.help));

                uyaripenceresi.setPositiveButton(getText(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:155"));
                        startActivity(intent);
                    }
                });
                uyaripenceresi.setNegativeButton(getText(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        uyaripenceresi.setTitle(getText(R.string.bilgilendirme));
                        Toast.makeText(HelpActivity.this,getText(R.string.talep),Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                uyaripenceresi.show();
                return;
            }
        });
        return;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0) {
            boolean konumIzniVerildiMi1 = grantResults[0] == PackageManager.PERMISSION_GRANTED;
            boolean konumIzniVerildiMi2 = grantResults[1] == PackageManager.PERMISSION_GRANTED;
            if (konumIzniVerildiMi1 && konumIzniVerildiMi2) {
                Konumal();
            } else {
                Toast.makeText(getApplicationContext(), getString(R.string.konum), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.konum), Toast.LENGTH_SHORT).show();
        }

    }

    public boolean izinkontrol(Context context, String... izinler) {
        if (context != null && izinler != null) {
            for (String izin : izinler) {
                if (ActivityCompat.checkSelfPermission(context, izin) != PackageManager.PERMISSION_GRANTED)
                    return true;
            }
        }
        return false;
    }
    public void Konumal() {

    }

}
