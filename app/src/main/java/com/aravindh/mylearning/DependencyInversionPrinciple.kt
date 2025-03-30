
package com.aravindh.mylearning

fun main() {

    val printLog = PrintLog()
    val fileLog = FileLog()

    printLog.log("Print the log message")
    fileLog.log("Store the log message into File")
}


/*------------------------------------*/


interface Logger {
    fun log(message: String?)
}


/*------------------------------------*/


class PrintLog : Logger {
    override fun log(message: String?) {
        println(message)
    }
}


/*------------------------------------*/


class FileLog : Logger {
    override fun log(message: String?) {
        writeToFile(message)
    }
    
    private fun writeToFile(message: String?) {
        // Write the log message to a file
        println(message)
    }
}
