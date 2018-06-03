package com.example.thebestone.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String EMAIL_KEY = "email";
    public static String PASS_KEY = "pass";

    EditText editEmail, editPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.editEmail);
        editPass = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);

        final Intent pergiKe = new Intent(MainActivity.this, KelasKedua.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, pass;

                email = editEmail.getText().toString();
                pass = editPass.getText().toString();

                if (email.equalsIgnoreCase("akil@gmail.com")) {

                    if (pass.equals("123")) {
                        pergiKe.putExtra(EMAIL_KEY, email);
                        pergiKe.putExtra(PASS_KEY, pass);

                        startActivity(pergiKe);
                    } else {
                        Toast.makeText(MainActivity.this, "Sandi Salah", Toast.LENGTH_SHORT).show();
                    }

                } else {

                    Toast.makeText(MainActivity.this, "Email tidak benar", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
