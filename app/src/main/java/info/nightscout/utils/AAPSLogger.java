package info.nightscout.utils;

import android.util.Log;

import info.nightscout.androidaps.MainApp;

public class AAPSLogger {

    public static final int ALL = 6;
    public static final int DEBUG = 5;
    public static final int INFO = 4;
    public static final int WARN = 3;
    public static final int ERROR = 2;
    public static final int FATAL = 1;
    public static final int OFF = 0;

    private final int defaultLevel = WARN;

    int resourceID;

    public AAPSLogger(int resourceID) {
        this.resourceID = resourceID;
    }

    public void d(String msg) {
        if (SP.getInt(resourceID, defaultLevel) >= DEBUG)
            Log.d(MainApp.gs(resourceID), source() + msg);
    }

    public void d(String format, Object... arguments) {
        if (SP.getInt(resourceID, defaultLevel) >= DEBUG)
            Log.d(MainApp.gs(resourceID), source() + String.format(format, arguments));
    }

    public void i(String msg) {
        if (SP.getInt(resourceID, defaultLevel) >= INFO)
            Log.i(MainApp.gs(resourceID), source() + msg);
    }

    public void w(String msg) {
        if (SP.getInt(resourceID, defaultLevel) >= WARN)
            Log.w(MainApp.gs(resourceID), source() + msg);
    }

    public void w(String format, Object... arguments) {
        if (SP.getInt(resourceID, defaultLevel) >= WARN)
            Log.w(MainApp.gs(resourceID), source() + String.format(format, arguments));
    }

    public void e(String msg) {
        if (SP.getInt(resourceID, defaultLevel) >= ERROR)
            Log.e(MainApp.gs(resourceID), source() + msg);
    }

    public void e(String msg, Throwable arg) {
        if (SP.getInt(resourceID, defaultLevel) >= ERROR)
            Log.e(MainApp.gs(resourceID), source() + msg, arg);
    }

    public void e(String format, Object... arguments) {
        if (SP.getInt(resourceID, defaultLevel) >= ERROR)
            Log.e(MainApp.gs(resourceID), source() + String.format(format, arguments));
    }

    private String source() {
        StringBuilder sb = new StringBuilder();
        sb.append("QQQQQQ[");
        sb.append(Thread.currentThread().getName());
        sb.append("] [");
        sb.append(Thread.currentThread().getStackTrace()[4].getFileName().replace(".java", ""));
        sb.append(".");
        sb.append(Thread.currentThread().getStackTrace()[4].getMethodName());
        sb.append("():");
        sb.append(Thread.currentThread().getStackTrace()[4].getLineNumber());
        sb.append("]: ");
        return sb.toString();
    }
}
