package ru.maluginp.bt.lib

import android.bluetooth.BluetoothAdapter

class BluetoothDevice(private val btAdapter: BluetoothAdapter, private val macAddress: MacAddress) : Device {



    override fun connect() {
        // TODO: Add
    }

    override fun disconnect() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}