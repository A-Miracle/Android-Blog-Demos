package com.ctao.demos;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

/**
 * Created by A Miracle on 2016/9/12.
 */
public class WApplication extends Application {
    private static WApplication mInstance;
    private static int mMainThreadId = -1;
    private static Thread mMainThread;
    private static Handler mMainThreadHandler;
    private static Looper mMainLooper;

    @Override
    public void onCreate() {
        mMainThreadId = android.os.Process.myTid();
        mMainThread = Thread.currentThread();
        mMainThreadHandler = new Handler();
        mMainLooper = getMainLooper();
        mInstance = this;
        super.onCreate();
    }

    public static WApplication getApplication() {
        return mInstance;
    }

    public static int getMainThreadId() {
        return mMainThreadId;
    }

    public static Thread getMainThread() {
        return mMainThread;
    }

    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }

    public static Looper getMainThreadLooper() {
        return mMainLooper;
    }
}
