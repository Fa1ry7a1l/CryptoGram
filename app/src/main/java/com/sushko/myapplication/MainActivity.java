package com.sushko.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import static com.sushko.myapplication.RSA.generateKeyPair;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1;
    EditText editText2;
    EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.text1);
        editText2 = findViewById(R.id.text2);
        editText3 = findViewById(R.id.text3);
        Button button = findViewById(R.id.Knoponika);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Knoponika:
                KeyPair keyPair = null;
                try {
                    keyPair = generateKeyPair();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    editText2.setText(RSA.encrypt(editText1.getText().toString(), keyPair.getPublic()));

                    editText3.setText(RSA.decrypt(editText2.getText().toString(), keyPair.getPrivate()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }
}