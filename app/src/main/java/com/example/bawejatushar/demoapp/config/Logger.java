package com.example.bawejatushar.demoapp.config;

import android.util.Log;

/**
 * Created by BawejaTushar on 9/20/2016.
 */
public class Logger {
    public enum Level {
        ERROR, WARN, INFO, DEBUG, VERBOSE
    }
    public static String TAG = "surple-play";
    private static boolean isLogEnabled = true;
    private static Level logLevel = Level.VERBOSE;
    public static boolean isIsLogEnabled() {
        return isLogEnabled;
    }
    public static void setLogEnabled(boolean isLogEnabled) {
        Logger.isLogEnabled = isLogEnabled;
    }
    public static Level getLogLevel() {
        return logLevel;
    }
    public static void setLogLevel(Level logLevel) {
        Logger.logLevel = logLevel;
    }
    public static void setLogTag(String logTag) {
        TAG = logTag;
    }
    public static void debug(String msg) {
        if (isLogEnabled && logLevel.ordinal() >= 3 && msg != null) {
            Log.d(TAG, msg);
        }
    }
    public static void debug(Throwable t) {
        if (isLogEnabled && logLevel.ordinal() >= 3) {
            Log.d(TAG, "Exception: ", t);
        }
    }
    public static void debug(String msg, Throwable t) {
        if (isLogEnabled && logLevel.ordinal() >= 3 && msg != null) {
            Log.d(TAG, msg, t);
        }
    }
    public static void info(String msg) {
        if (isLogEnabled && logLevel.ordinal() >= 2 && msg != null) {
            Log.i(TAG, msg);
        }
    }
    public static void warn(String msg) {
        if (isLogEnabled && logLevel.ordinal() >= 1 && msg != null) {
            Log.w(TAG, msg);
        }
    }
    public static void error(String msg) {
        if (isLogEnabled && logLevel.ordinal() >= 0 && msg != null) {
            Log.e(TAG, msg);
        }
    }
}
