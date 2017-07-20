package com.example.kakaroto.sharedpreferencesdemo.base;

import android.app.Application;

import com.example.kakaroto.sharedpreferencesdemo.utility.DatabaseHandler;
import com.example.kakaroto.sharedpreferencesdemo.utility.SessionManager;

/**
 * Created by kakaroto on 19/07/17.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SessionManager.init(this);
        DatabaseHandler.init(this);
    }
}
