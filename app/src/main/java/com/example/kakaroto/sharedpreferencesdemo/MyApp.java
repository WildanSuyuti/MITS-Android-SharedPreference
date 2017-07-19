package com.example.kakaroto.sharedpreferencesdemo;

import android.app.Application;

/**
 * Created by kakaroto on 19/07/17.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SessionManager.init(this);
    }
}
