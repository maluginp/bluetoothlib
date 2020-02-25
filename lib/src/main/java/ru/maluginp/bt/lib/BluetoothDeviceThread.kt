package ru.maluginp.bt.lib

import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.OutputStream

class BluetoothDeviceThread(val inputStream: InputStream, val outputStream: OutputStream) : Thread() {
    private var stop: Boolean = false

    override fun run() {
        val buffer = ByteArray(1024)

        var byteBuffer = ByteArrayOutputStream()
        var bytes: Int

        while (true) {
            if (stop) {
//                logger.d("BT ConnectionThread: Stopped Bluetooth connection thread.")
                break
            }
            try {
                bytes = 0
                if (inputStream.available() > 0) {
//                    logger.d("BT ConnectionThread: Available bytes %d in sockets", mmInStream.available())
                    bytes = inputStream.read(buffer)
                    byteBuffer.write(buffer, 0, bytes)
                }
                //                    logger.d("BT ConnectionThread: Try read bytes %d in sockets", bytes);
                if (bytes == 0) {
                    if (byteBuffer.size() > 0) {
//                        logger.d("BT ConnectionThread: %d received bytes from socket", byteBuffer.size())
//                        if (listener != null) {
//                            listener.onReadData(mDeviceMacAddress, byteBuffer.toByteArray())
//                        }
                        byteBuffer = ByteArrayOutputStream()
                    }
                }
                sleep(500)
            } catch (e: Exception) {
//                e.printStackTrace()
//                logger.e(e, "BT ConnectionThread: Failed read data from socket")
                break
            }
        }
    }
}