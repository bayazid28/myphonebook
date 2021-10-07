package com.java.myphonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomeScreen extends AppCompatActivity {
    Button logout;
    FirebaseAuth mFirebaseAuth;
    private  FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        logout = findViewById(R.id.logoutbtn);
        final EditText name = findViewById(R.id.names);
        final EditText mobile = findViewById(R.id.mobiles);
        Button btn = findViewById(R.id.addct);
        Button show = findViewById(R.id.showct);
        HelperContact help = new HelperContact();

        btn.setOnClickListener(v->
        {
            Contact contact = new Contact(name.getText().toString(),mobile.getText().toString());
            help.add(contact).addOnSuccessListener(suc->
                    {
                        Toast.makeText(this,"Contact is Added",Toast.LENGTH_SHORT).show();
                    }
                    ).addOnFailureListener(er->
            {
                        Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();
            });
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.getText().clear();
                mobile.getText().clear();
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(HomeScreen.this,LoginScreen.class);
                startActivity(i);
            }
        });
        show.setOnClickListener(v->
        {
            Intent i = new Intent(HomeScreen.this,ShowContact.class);
            startActivity(i);
        });
    }
}