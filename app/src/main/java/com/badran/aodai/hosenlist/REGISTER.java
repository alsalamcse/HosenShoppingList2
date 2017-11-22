package com.badran.aodai.hosenlist;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class REGISTER extends AppCompatActivity implements View.OnClickListener {
    private static final String PREF_FILE_NAME = "HosenPref";
    private Button BTNSave;
    private Button BTNDELETE;
    private EditText ETusername;
    private EditText ETemail;
    private EditText ETpassword;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        BTNSave = (Button) findViewById(R.id.BTNSave);
        ETusername = (EditText) findViewById(R.id.ETusername);
        ETemail = (EditText) findViewById(R.id.ETemail);
        ETpassword = (EditText) findViewById(R.id.ETpassword);
        BTNDELETE = (Button) findViewById(R.id.BTNDELETE);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
//
    }

    public void onClick(View view) {
        dataHander();

        }


        //*to deal with input data
        private void dataHander(){
            String email=ETemail.getText().toString();
            String passw=ETpassword.getText().toString();
            String name=ETusername.getText().toString();
            boolean isOk=true;//to check if all feilds are filled correctly

            createAccount(email,passw);
    }
    public void createAccount( String email, String passw) {
        auth.createUserWithEmailAndPassword(email, passw).addOnCompleteListener(REGISTER.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(REGISTER.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                    //updateUserProfile(task.getResult().getUser());
                    finish();
                } else {
                    Toast.makeText(REGISTER.this, "Authentication failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }



}

