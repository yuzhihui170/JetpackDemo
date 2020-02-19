package me.forrest.commonlib.log;

import android.util.Log;

public class LogTool {
    private final static String TAG = "Forrest";

    public static void debug(String msg) {
        Log.d(TAG, msg);
    }
}
