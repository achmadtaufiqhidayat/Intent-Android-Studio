package com.ofeq.taskintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
//deklarasi
    Button myButton, btnSubmit, btnWa;
    EditText edtText, name;
    private String KEY_NAME = "NAMA";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*IMPLEMENTASI IMPLICIT INTENT*/
        /*menyambungkan deklarasi button dan edit text
        di MainActivity dengan myButton di
        activity_main.xml*/
        myButton = findViewById(R.id.myButton);
        edtText = findViewById(R.id.edtText);
        btnWa = findViewById(R.id.btnwa);
        /*memberikan action saat diklik
        * dalam kasus ini, kita mengisi url
        * kemudian menekan button
        * lalu, kita akn diarahkan ke browser*/
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //memberikan input url yang akan dituju
                String url = edtText.getText().toString();
                /*berpindah ke browser
                disini kita memilih actoin view agar dapat melihat dari link yang dituju
                melalui url yang diparse
                kemudian terakhir adalah menjalankan intent
                */
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        /*IMPLEMENTASI EXPLICIT INTENT*/
        /*menyambungkan deklarasi button dan edit text
        di MainActivity dengan myButton di
        activity_main.xml*/
        name = (EditText) findViewById(R.id.edt_nama);
        btnSubmit = (Button) findViewById(R.id.submitBtn);
        
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             try {
            String nama = name.getText().toString();
            if (nama != ""){
                Intent i = new Intent(MainActivity.this, ActivityDua.class);
                i.putExtra(KEY_NAME, nama);
                startActivity(i);
             } else {
                Toast.makeText(getApplication(), "YOU NEED TO FILL YOUR NAME",Toast.LENGTH_SHORT);
            }

        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), "ERROR, TRY AGAIN !",Toast.LENGTH_SHORT);
        }


       }



        });
        //disini code untuk direct wa



        btnWa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String link = "https://api.whatsapp.com/send?phone=+6281249345670";
                String link= null;
                try {
                    link = "https://api.whatsapp.com/send?phone=+6281249345670"+"&text=Hallo.\n" +
                            "Saya ingin bertanya ketersediaan item di POLOSKUY!";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplication(), "Gagal membuka WhatsApp", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}