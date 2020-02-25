package ru.maluginp.bt.lib

import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

interface Socket {
    @Throws(IOException::class)
    fun open()

    @Throws(IOException::class)
    fun close()

    fun inputStream(): InputStream

    fun outputStream(): OutputStream

}