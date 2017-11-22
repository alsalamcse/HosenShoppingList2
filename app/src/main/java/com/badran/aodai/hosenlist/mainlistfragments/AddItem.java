package com.badran.aodai.hosenlist.mainlistfragments;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.badran.aodai.hosenlist.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddItem extends AppCompatActivity {;
    private EditText etName;
    private EditText etAmount;
    private EditText etUnits;
    private EditText ETprice;
    private Button BTNSave;
    private ImageView iBTNimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        etName = (EditText) findViewById(R.id.ETname);
        etAmount = (EditText) findViewById(R.id.ETamount);
        etUnits = (EditText) findViewById(R.id.ETunits);
        ETprice = (EditText) findViewById(R.id.ETprice);
        BTNSave = (Button) findViewById(R.id.BTNSave);
        iBTNimage = (ImageView) findViewById(R.id.iBTNimage);

        BTNSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();

            }
        });




    }

    public void dataHandler()
    {
        //1. get data from the fields
        String stname = etName.getText().toString();
        String stAmount = etAmount.getText().toString();
        String stPrice = ETprice.getText().toString ();
        String stUnits = etUnits.getText().toString();
        double amount=Double.parseDouble(stAmount);
        double price= Double.parseDouble(stPrice);

        Product p= new Product();
        p.setName(etName);
        p.setAmount(amount);
        p.setPrice(price);
        p.setCompleted(false);
        DatabaseReference reference;
        reference= FirebaseDatabase.getInstance().getReference();

        FirebaseAuth auth=FirebaseAuth.getInstance();
        FirebaseUser user=auth.getCurrentUser();
        String email=user.getEmail();
        email=email.replace('.','*');

        reference.child(email).child("my list").push().setValue(p).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(AddItem.this, "Product add succesfull", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AddItem.this, "Product failed", Toast.LENGTH_SHORT).show();
                }

            }
        });


        //reference.child("list").setValue("koko");

    }

}






