package com.kinshuu.nightingale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button BTNlogout= findViewById(R.id.BTNlogout);
        BTNlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Settings.this, "Logging out", Toast.LENGTH_SHORT).show();
                AuthUI.getInstance().signOut(getApplicationContext());
                finish();
            }
        });

        final EditText ETnum1=findViewById(R.id.ETnum1);
        final EditText ETnum2=findViewById(R.id.ETnum2);
        final EditText ETnum3=findViewById(R.id.ETnum3);

        Button BTNsave= findViewById(R.id.BTNsave);
        BTNsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ETnum1.getText().toString().equals("")||ETnum3.getText().toString().equals("")||ETnum2.getText().toString().equals("")){
                    Toast.makeText(Settings.this, "Enter the goddamn digits", Toast.LENGTH_SHORT).show();
                }
                else {
                    String num1=ETnum1.getText().toString();
                    String num2=ETnum2.getText().toString();
                    String num3=ETnum3.getText().toString();
                    ContactDetails contactDetails=new ContactDetails(num1,num2,num3);
                    MainActivity.mDatabaseReferencewide.child(MainActivity.mUsername).setValue(contactDetails);
                }
            }
        });
    }
}
