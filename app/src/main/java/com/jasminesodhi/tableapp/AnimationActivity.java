package com.jasminesodhi.tableapp;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by jasminesodhi on 24/06/17.
 */

public class AnimationActivity extends AppCompatActivity{

    FancyButton anim1Button, anim2Button, anim3Button, anim4Button, anim5Button;

    BluetoothSPP bluetoothSPP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        anim1Button = (FancyButton) findViewById(R.id.animation_1);
        anim2Button = (FancyButton) findViewById(R.id.animation_2);
        anim3Button = (FancyButton) findViewById(R.id.animation_3);
        anim4Button = (FancyButton) findViewById(R.id.animation_4);
        anim5Button = (FancyButton) findViewById(R.id.animation_5);

        bluetoothSPP = Data.getBluetoothSPP();

        anim1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bluetoothSPP.send("c", true);
                Toast.makeText(getApplicationContext(), "Animation set!", Toast.LENGTH_SHORT).show();
            }
        });

        anim2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bluetoothSPP.send("d", true);
                Toast.makeText(getApplicationContext(), "Animation set!", Toast.LENGTH_SHORT).show();
            }
        });

        anim3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bluetoothSPP.send("e", true);
                Toast.makeText(getApplicationContext(), "Animation set!", Toast.LENGTH_SHORT).show();
            }
        });

        anim4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bluetoothSPP.send("f", true);
                Toast.makeText(getApplicationContext(), "Animation set!", Toast.LENGTH_SHORT).show();
            }
        });

        anim5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bluetoothSPP.send("g", true);
                Toast.makeText(getApplicationContext(), "Animation set!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
