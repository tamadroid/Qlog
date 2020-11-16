package jp.tama.qlog

import android.os.Looper
import android.util.Log

object Qlog {
    val isUiThread: Boolean
        get() = Thread.currentThread() == Looper.getMainLooper().thread

    private var mDebugFlag = true

    fun set(){

    }

    fun e(msg: Any = "", writeFlag:Boolean = false) {
        logCommon(msg, writeFlag, LogType.ERROR)
    }

    fun w(msg: Any = "", writeFlag:Boolean = false) {
        logCommon(msg, writeFlag, LogType.WARN)
    }

    fun i(msg: Any = "", writeFlag:Boolean = false) {
        logCommon(msg, writeFlag, LogType.INFO)
    }

    fun d(msg: Any = "", writeFlag:Boolean = false) {
        //		logCommon(msg, LogType.DEBUG);
        logCommon(msg, writeFlag, LogType.INFO)
    }

    fun v(msg: Any = "", writeFlag:Boolean = false) {
        logCommon(msg, writeFlag, LogType.VERBOSE)
    }

    private enum class LogType {
        ERROR, WARN, INFO, DEBUG, VERBOSE
    }

    private fun logCommon(msg: Any, writeFlag: Boolean, logType: LogType) {
        if (mDebugFlag) {
            val ste = Thread.currentThread().stackTrace[5]
            val tag = this.getJumpLog(ste)

            val dispData = "${this.isUiThread}, $msg"
            when (logType) {
                LogType.ERROR -> Log.e(tag, dispData)
                LogType.WARN -> Log.w(tag, dispData)
                LogType.INFO -> Log.i(tag, dispData)
                LogType.DEBUG -> Log.d(tag, dispData)
                LogType.VERBOSE -> Log.v(tag, dispData)
            }
        }
    }

    private fun getJumpLog(ste: StackTraceElement): String {
        val jump = "(${ste.fileName}:${ste.lineNumber})${ste.methodName}"

        return String.format("%15s", jump)
    }


}