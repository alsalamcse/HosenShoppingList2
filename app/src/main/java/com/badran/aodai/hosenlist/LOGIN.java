package com.badran.aodai.hosenlist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.badran.aodai.hosenlist.mainlistfragments.MainListActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LOGIN extends AppCompatActivity implements View.OnClickListener {
    private static final String PREF_FILE_NAME = "AodaiPref";
    private Button BTNsignin;
    private Button BTNsignup;
    private Button BTNfmpassword;
    private EditText ETusername;
    private EditText ETpassword;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ETusername = (EditText) findViewById(R.id.ETusername);
        ETpassword = (EditText) findViewById(R.id.ETpassword);
        BTNsignin = (Button) findViewById(R.id.BTsignin);
        BTNsignup = (Button) findViewById(R.id.BTsignup);
        BTNfmpassword = (Button) findViewById(R.id.BTNfmpassword);
        BTNsignin.setOnClickListener(this);
        BTNsignup.setOnClickListener(this);
        BTNfmpassword.setOnClickListener(this);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
    }

    public void onClick(View view) {
        if (BTNsignin==view)
        dataHander();

        if (BTNsignup==view){
            Intent i = new Intent(this,REGISTER.class);
            startActivity(i);
        }

    }


    //*to deal with input data
    private void dataHander() {
        String username = ETusername.getText().toString();
        String passw = ETpassword.getText().toString();
        boolean isOk = true;//to check if all feilds are filled correctly

        signIn(username, passw);
    }



    private void signIn(String username, String passw) {
        Task<AuthResult> authResultTask = auth.signInWithEmailAndPassword(username, passw).addOnCompleteListener(LOGIN.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LOGIN.this, "signIn Successful.", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LOGIN.this,MainListActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LOGIN.this, "signIn failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }
}



