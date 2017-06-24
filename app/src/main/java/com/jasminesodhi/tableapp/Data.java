package com.jasminesodhi.tableapp;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;

/**
 * Created by jasminesodhi on 24/06/17.
 */

public class Data {
    public static BluetoothSPP bluetoothSPP;

    public static void setBluetoothSPP(BluetoothSPP spp) {
        Data.bluetoothSPP = spp;
    }

    public static BluetoothSPP getBluetoothSPP() {
        return bluetoothSPP;
    }
}
