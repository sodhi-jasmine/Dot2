package com.jasminesodhi.tableapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by jasminesodhi on 24/06/17.
 */

public class GameActivity extends AppCompatActivity{

    FancyButton upButton, downButton, leftButton, rightButton;
    FancyButton startButton, stopButton;

    BluetoothSPP bluetoothSPP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        bluetoothSPP = Data.getBluetoothSPP();

        upButton = (FancyButton) findViewById(R.id.up_button);
        downButton = (FancyButton) findViewById(R.id.down_button);
        leftButton = (FancyButton) findViewById(R.id.left_button);
        rightButton = (FancyButton) findViewById(R.id.right_button);

        startButton = (FancyButton) findViewById(R.id.start_button);
        stopButton = (FancyButton) findViewById(R.id.stop_button);

        upButton.setEnabled(false);
        downButton.setEnabled(false);
        leftButton.setEnabled(false);
        rightButton.setEnabled(false);

        stopButton.setEnabled(false);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upButton.setEnabled(true);
                downButton.setEnabled(true);
                leftButton.setEnabled(true);
                rightButton.setEnabled(true);

                stopButton.setEnabled(true);

                startButton.setEnabled(false);

                upButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bluetoothSPP.send(new byte[] {0x30}, false);
                    }
                });

                downButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bluetoothSPP.send(new byte[] {0x32}, false);
                    }
                });

                leftButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bluetoothSPP.send(new byte[] {0x34}, false);
                    }
                });

                rightButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bluetoothSPP.send(new byte[] {0x36}, false);
                    }
                });

                stopButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bluetoothSPP.send(new byte[] {0x38}, false);

                        upButton.setEnabled(false);
                        downButton.setEnabled(false);
                        leftButton.setEnabled(false);
                        rightButton.setEnabled(false);

                        stopButton.setEnabled(false);
                        startButton.setEnabled(true);

                        Toast.makeText(getApplicationContext(), "Game Over!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
