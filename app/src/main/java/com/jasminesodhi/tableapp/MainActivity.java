package com.jasminesodhi.tableapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothService;
import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.DeviceList;
import mehdi.sakout.fancybuttons.FancyButton;

public class MainActivity extends AppCompatActivity {

    BluetoothSPP bluetoothSPP;
    FancyButton animationButton, playGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetoothSPP = new BluetoothSPP(this);

        animationButton = (FancyButton) findViewById(R.id.animation);
        playGameButton = (FancyButton) findViewById(R.id.play_game);

            Intent intent = new Intent(getApplicationContext(), DeviceList.class);
            startActivityForResult(intent, BluetoothState.REQUEST_CONNECT_DEVICE);

        bluetoothSPP.setBluetoothConnectionListener(new BluetoothSPP.BluetoothConnectionListener() {
            @Override
            public void onDeviceConnected(String name, String address) {
                Data.setBluetoothSPP(bluetoothSPP);
                startService(new Intent(getBaseContext(), BluetoothService.class));
            }

            @Override
            public void onDeviceDisconnected() {

            }

            @Override
            public void onDeviceConnectionFailed() {

            }
        });
    }

    public void onStart() {
        super.onStart();
        if(!bluetoothSPP.isBluetoothEnabled()) {
            bluetoothSPP.enable();
        } else {
            if(!bluetoothSPP.isServiceAvailable()) {
                bluetoothSPP.setupService();
                bluetoothSPP.startService(BluetoothState.DEVICE_OTHER);
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == BluetoothState.REQUEST_CONNECT_DEVICE) {
            if(resultCode == Activity.RESULT_OK)
                bluetoothSPP.connect(data);

            animationButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, AnimationActivity.class);
                    startActivity(intent);
                }
            });

            playGameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, GameActivity.class);
                    startActivity(intent);
                }
            });
        } else if(requestCode == BluetoothState.REQUEST_ENABLE_BT) {
            if(resultCode == Activity.RESULT_OK) {
                bluetoothSPP.setupService();
            } else {
                Toast.makeText(getApplicationContext(), "Bluetooth was not enabled.", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}
