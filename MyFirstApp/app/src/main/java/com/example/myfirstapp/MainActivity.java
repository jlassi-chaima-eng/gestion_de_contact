package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn_val,btn_quit;
EditText ed_email ,ed_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_val=findViewById(R.id.btn_val_auth);
        btn_quit=findViewById(R.id.btn_quit_auth);
        ed_email=findViewById(R.id.ed_email_auth);
        ed_pass=findViewById(R.id.ed_pass_auth);

        btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_val.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=ed_email.getText().toString();
                String password=ed_pass.getText().toString();
                if(email.equals("chaima@gmail.com")&&password.equals("1234")){
                    Intent i =new Intent(MainActivity.this,Accueil.class);

                    startActivity(i);
                }else {
                    Toast.makeText(MainActivity.this, "Authentification erroné", Toast.LENGTH_SHORT).show();
                }
            }

        });
        btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });
    }
}