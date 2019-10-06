package com.kinshuu.nightingale;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import io.chirp.chirpsdk.ChirpSDK;
import io.chirp.chirpsdk.interfaces.ChirpEventListener;
import io.chirp.chirpsdk.models.ChirpError;

import static com.kinshuu.nightingale.MainActivity.chirp;

public class Listener extends Service {

    private static final int NOTIF_ID = 1;
    private static final String NOTIF_CHANNEL_ID = "Channel_Id";
    private static final int RESULT_REQUEST_RECORD_AUDIO = 1;
    String CHIRP_APP_KEY = "a425Bff1fE83BaFD9e5F6d5A3";
    String CHIRP_APP_SECRET = "A0DFeB41c736196Fa82fBFCcAa36E334610Ea71bd128e7e9D5";
    String CHIRP_APP_CONFIG = "GpEu5S5FtjVzSmhBNpDrmLU9Ojw4c2xcsrhoPuerCsqSNfoicEuPCx0iX1lNFMYN2ekd4+HAT1wXVvvgqaTrm7FXO3EKt6aDCEOYcZtc8oPSMNk83Q/UMFfdgimH5AYSbx9yFiuvoKAuhXA31VsiEfdYSLD82zXTgEjgTYyzje1BMRIEqXKV3fG6pT14vftbJ1gc3qJR1RW4+/g1bVqKo6zG7gHkC+qwzSrqQ1/63lA2wMQ8Cvu3mmMzvgFVWlsBUg++sxGaztNCX0F7Ig96oi7PGeVGZGj5nnicfJsL3RHH2siNwoILh9E6SkejXNGq5uq35juxz1ySslDGTOr2y0yvKxjfgC5JI2+01TLlXGPTY8q7cDpASP9rbSwHWoEu7HIxHgu/g1ZZTfo21HxAkjHcxg0Zj+25HkTCalQ/jbrB33yYEUUI+05l+dP0OU29SMeZ1G2xTmrzy2nerEzTOW9CECAu/X0Vy6Wk+qYScuW64uboqeQnSfer5qmDK44jNYuwAg9ZklpzkTKaIRD/2bpsBElAwwS5UvTI5u2uQ/obYopGHC6VB88Ird1Q41FGGnIfMYwmvRJfPpBa4TGvU8S/9NoNZF891m0FYvy0FoN2kxus+Xi6z7O2lvcEGON+aiiKenCC+xdAimpNEGVJyQH36AG6KsIz3iAJT+Q/lpBwbWerYf5s7SlNZhlkxeWQfb+X7p/SSNndfrxsuX5g3RhMKXbXvG3bQueQHzguaWi5ykqMWzioEQA/xGeRhPu1gYaMDXYmonLfX/WWEuEpEqhmSlNh/ePnqM85CMkXBPz0AbleD5Xe0nz+f/hO2iX09br1ymNpJ2PnhEwpAPffoGNNYrxceUxCYYEMImRMaBjskKxoGl5jxknvY9G5jn6kW16/91NApoeul75yRFdzqF5fYT68uxNTzlF9stX6ukvsDoWPr8EFWl0OY82pgUfRiGdQwyy/0f9k8SKD41Ptcyac0VVeiZcoLeuRtm3EJPk9bgMk7FpQmkTz/dOSXVCb4upARtDmGY1+v5nbsxNEocmC9aVlHWXyYKqzKjZzf15XPLMUGP5/HPLA+8bNs7G9MT+vWi5EhR/QMKaDykLPdQCKrDJvXdPxeKVriDIqRGim24EmheFz4lb2Q2apYkc4JCD4gnXKuvrTdhtBtHZx3A==";

    public Listener() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        // do your jobs here
//        Toast.makeText(this, "Service LMAO noobs", Toast.LENGTH_SHORT).show();

        /*chirp = new ChirpSDK(this, CHIRP_APP_KEY, CHIRP_APP_SECRET);
        ChirpError error = chirp.setConfig(CHIRP_APP_CONFIG);
        if (error.getCode() == 0) {
            Log.v("ChirpSDK: ", "Configured ChirpSDK");
        } else {
            Log.e("ChirpError: ", error.getMessage());
        }*/
        ChirpEventListener chirpEventListener = new ChirpEventListener() {
            @Override
            public void onReceived(byte[] data, int channel) {
                if (data != null) {
                    String identifier = new String(data);
                    Log.v("ChirpSDK: ", "Received " + identifier);
                    Toast.makeText(Listener.this, "Received " + identifier, Toast.LENGTH_LONG).show();
                } else {
                    Log.e("ChirpError: ", "Decode failed");
                }
            }
            public void onSending(byte[] payload, int channel) {}
            public void onSent(byte[] payload, int channel) {}
            public void onReceiving(int channel) {}
            public void onStateChanged(int oldState, int newState) {}
            @Override
            public void onSystemVolumeChanged(float old, float current) {}
        };
        chirp.setListener(chirpEventListener);
        startForeground();

        return super.onStartCommand(intent, flags, startId);
    }

    private void startForeground() {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);
        initChannels(getApplicationContext());
        startForeground(NOTIF_ID, new NotificationCompat.Builder(this,
                NOTIF_CHANNEL_ID) // don't forget create a notification channel first
                .setOngoing(true)
                .setContentTitle(getString(R.string.app_name))
                .setContentText("Listening in background")
                .setContentIntent(pendingIntent)
                .build());
    }

    public void initChannels(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = new NotificationChannel(NOTIF_CHANNEL_ID,
                "Background channel",
                NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("Channel description");
        notificationManager.createNotificationChannel(channel);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        ChirpError error = chirp.start(true, true);
        if (error.getCode() > 0) {
            Log.e("ChirpError: ", error.getMessage());
        } else {
            Log.v("ChirpSDK: ", "Started ChirpSDK");
        }
    }

    @Override
    public void onRebind(Intent intent) {

            // Start ChirpSDK sender and receiver, if no arguments are passed both sender and receiver are started
            ChirpError error = chirp.start(true, true);
            if (error.getCode() > 0) {
                Log.e("ChirpError: ", error.getMessage());
            } else {
                Log.v("ChirpSDK: ", "Started ChirpSDK");
            }
        super.onRebind(intent);
    }
}
