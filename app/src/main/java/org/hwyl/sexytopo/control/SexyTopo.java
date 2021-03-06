package org.hwyl.sexytopo.control;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;


public class SexyTopo extends Application {

    private Thread.UncaughtExceptionHandler defaultHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler (new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException (Thread thread, Throwable e)
            {
                handleUncaughtException (thread, e);
            }
        });

        Fabric.with(this, new Crashlytics());
    }


    public void handleUncaughtException (Thread thread, Throwable e) {
        Log.setContext(this);
        Log.e(e);
        defaultHandler.uncaughtException(thread, e);
    }
}