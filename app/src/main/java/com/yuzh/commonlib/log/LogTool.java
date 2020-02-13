package com.yuzh.commonlib.log;

import android.util.Log;

public class LogTool {
    private final static String TAG = "yuzh";

    public static void debug(String msg) {
        Log.d(TAG, msg);
    }
}
