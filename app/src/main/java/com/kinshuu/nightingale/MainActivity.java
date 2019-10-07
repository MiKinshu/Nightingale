package com.kinshuu.nightingale;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

import io.chirp.chirpsdk.ChirpSDK;
import io.chirp.chirpsdk.models.ChirpError;


public class MainActivity extends AppCompatActivity {


    String TAG="MyLOGS";
    private static final int RC_SIGN_IN = 1;

    //chirp
    String CHIRP_APP_KEY = "a425Bff1fE83BaFD9e5F6d5A3";
    String CHIRP_APP_SECRET = "A0DFeB41c736196Fa82fBFCcAa36E334610Ea71bd128e7e9D5";
    String CHIRP_APP_CONFIG = "GpEu5S5FtjVzSmhBNpDrmLU9Ojw4c2xcsrhoPuerCsqSNfoicEuPCx0iX1lNFMYN2ekd4+HAT1wXVvvgqaTrm7FXO3EKt6aDCEOYcZtc8oPSMNk83Q/UMFfdgimH5AYSbx9yFiuvoKAuhXA31VsiEfdYSLD82zXTgEjgTYyzje1BMRIEqXKV3fG6pT14vftbJ1gc3qJR1RW4+/g1bVqKo6zG7gHkC+qwzSrqQ1/63lA2wMQ8Cvu3mmMzvgFVWlsBUg++sxGaztNCX0F7Ig96oi7PGeVGZGj5nnicfJsL3RHH2siNwoILh9E6SkejXNGq5uq35juxz1ySslDGTOr2y0yvKxjfgC5JI2+01TLlXGPTY8q7cDpASP9rbSwHWoEu7HIxHgu/g1ZZTfo21HxAkjHcxg0Zj+25HkTCalQ/jbrB33yYEUUI+05l+dP0OU29SMeZ1G2xTmrzy2nerEzTOW9CECAu/X0Vy6Wk+qYScuW64uboqeQnSfer5qmDK44jNYuwAg9ZklpzkTKaIRD/2bpsBElAwwS5UvTI5u2uQ/obYopGHC6VB88Ird1Q41FGGnIfMYwmvRJfPpBa4TGvU8S/9NoNZF891m0FYvy0FoN2kxus+Xi6z7O2lvcEGON+aiiKenCC+xdAimpNEGVJyQH36AG6KsIz3iAJT+Q/lpBwbWerYf5s7SlNZhlkxeWQfb+X7p/SSNndfrxsuX5g3RhMKXbXvG3bQueQHzguaWi5ykqMWzioEQA/xGeRhPu1gYaMDXYmonLfX/WWEuEpEqhmSlNh/ePnqM85CMkXBPz0AbleD5Xe0nz+f/hO2iX09br1ymNpJ2PnhEwpAPffoGNNYrxceUxCYYEMImRMaBjskKxoGl5jxknvY9G5jn6kW16/91NApoeul75yRFdzqF5fYT68uxNTzlF9stX6ukvsDoWPr8EFWl0OY82pgUfRiGdQwyy/0f9k8SKD41Ptcyac0VVeiZcoLeuRtm3EJPk9bgMk7FpQmkTz/dOSXVCb4upARtDmGY1+v5nbsxNEocmC9aVlHWXyYKqzKjZzf15XPLMUGP5/HPLA+8bNs7G9MT+vWi5EhR/QMKaDykLPdQCKrDJvXdPxeKVriDIqRGim24EmheFz4lb2Q2apYkc4JCD4gnXKuvrTdhtBtHZx3A==";
    String identifier = "1234567";
    public static ChirpSDK chirp;
    byte[] payload;
    private static final int RESULT_REQUEST_RECORD_AUDIO = 1;

    //firebase instance variables
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    public static FirebaseDatabase mFirebaseDatabase;
    public static DatabaseReference mDatabaseReference,mDatabaseReferencewide;
    public static ChildEventListener mChildEventListener;
    public static String mUsername="0";
    public static String lat="28.613";
    public static String longi="77.229";
    public static ArrayList<ContactDetails> contacts;

    //textmessage
    private SmsManager mMessageManager;
    public static  double mlat=18.6058 ,mLong=73.8753;
    private LocationManager mLocationManager = null;
    ContactDetails contactDetails;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contacts=new ArrayList<>();
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference().child(mUsername);
        mDatabaseReferencewide=mFirebaseDatabase.getReference().child("users");

        lat=lat.substring(lat.lastIndexOf(".")+1);
        longi=longi.substring(longi.lastIndexOf(".")+1);
        chirp = new ChirpSDK(this, CHIRP_APP_KEY, CHIRP_APP_SECRET);
        ChirpError error = chirp.setConfig(CHIRP_APP_CONFIG);
        if (error.getCode() == 0) {
            Log.v("ChirpSDK: ", "Configured ChirpSDK");
        } else {
            Log.e("ChirpError: ", error.getMessage());
        }

        ImageButton IBTNheat=findViewById(R.id.IBTNheat);
        ImageButton IBTNroute=findViewById(R.id.IBTNroute);
        ImageButton IBTNcab=findViewById(R.id.IBTNcab);
        ImageButton IBTNalert=findViewById(R.id.IBTNalert);
        Button BTNsettings=findViewById(R.id.BTNsettings);
        final TextView TVname=findViewById(R.id.TVname);

        mMessageManager = SmsManager.getDefault();
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        startService(new Intent(this, Listener.class));

        //text message
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED ) {
            requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 101);
        }

        IBTNheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,com.kinshuu.nightingale.MapsActivity.class);
                startActivity(intent);
            }
        });

        IBTNalert.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if(!isNetworkAvailable()) {
                    //sending w/o signal
                    Toast.makeText(MainActivity.this, "Network Unavailable, sending audio", Toast.LENGTH_SHORT).show();
                    identifier=mUsername+lat+longi;
                    byte[] payload = identifier.getBytes(Charset.forName("UTF-8"));
                    ChirpError error = chirp.send(payload);
                    Log.d(TAG, "onClick: identifier is "+identifier);
                    if (error.getCode() > 0) {
                        Log.e("ChirpError: ", error.getMessage());
                    } else {
                        Log.v("ChirpSDK: ", "Sent " + identifier);
                    }
                }
                else{
                    //send text message
                    String number= contacts.get(Integer.parseInt(mUsername)).getNum1();
                    Toast.makeText(MainActivity.this, "Network Available, sending text.", Toast.LENGTH_SHORT).show();
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number, null, "I am sending my location for precaution for my safety. lat = " + mlat + " and long= " + mLong, null, null);
                }
            }
        });

        IBTNcab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Cab Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        IBTNroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,com.kinshuu.nightingale.SafestPath.class);
                startActivity(intent);
            }
        });


        BTNsettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,com.kinshuu.nightingale.Settings.class);
                startActivity(intent);
            }
        });

        //initialise Firebase components
        mFirebaseAuth=FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user= firebaseAuth.getCurrentUser();
                if(user!=null){
                    // user is signed in
                    mUsername=user.getDisplayName();
                    TVname.setText(mUsername);
                    mDatabaseReference=mFirebaseDatabase.getReference().child(mUsername);
                }
                else{
                    // user is signed out
                    Log.d(TAG, "onAuthStateChanged: User is signed out.");
                    //OnSignedOutInitialise();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.GoogleBuilder().build(),
                                            new AuthUI.IdpConfig.EmailBuilder().build()))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };
        mChildEventListener= new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                contactDetails = dataSnapshot.getValue(ContactDetails.class);
                contacts.add(contactDetails);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mDatabaseReferencewide.addChildEventListener(mChildEventListener);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.RECORD_AUDIO}, RESULT_REQUEST_RECORD_AUDIO);
        }
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RESULT_REQUEST_RECORD_AUDIO: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    ChirpError error = chirp.start();
                    if (error.getCode() > 0) {
                        Log.e("ChirpError: ", error.getMessage());
                    } else {
                        Log.v("ChirpSDK: ", "Started ChirpSDK");
                    }
                }
                return;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d(TAG, "onActivityResult: In ActivityResult.");
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            if(resultCode==RESULT_CANCELED) {
                Toast.makeText(this, "Cannot work until you Sign-In", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
        Log.d(TAG, "onActivityResult: Exiting ActivityResult");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        chirp.stop();
        try {
            chirp.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
