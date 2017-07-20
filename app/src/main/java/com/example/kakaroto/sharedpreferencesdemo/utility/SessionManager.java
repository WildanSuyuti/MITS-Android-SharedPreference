package com.example.kakaroto.sharedpreferencesdemo.utility;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.kakaroto.sharedpreferencesdemo.model.User;

/**
 * Created by kakaroto on 19/07/17.
 */

public class SessionManager {

    private static final String AUTH_PREFERENCES = "auth";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_PASS = "pass";
    private static final String KEY_IS_LOGGED_IN = "login";
    private static SessionManager instance;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public SessionManager(Context context) {
        int PRIVATE_MODE = 0;
        preferences = context.getSharedPreferences(AUTH_PREFERENCES, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public static void init(Context context) {
        instance = new SessionManager(context);
    }

    public synchronized static SessionManager getInstance() {
        return instance;
    }

    public User getPerson() {
        User user = new User(preferences.getString(KEY_NAME, ""),
                preferences.getString(KEY_EMAIL, ""), preferences.getString(KEY_PASS, ""),
                preferences.getInt(KEY_PHONE, 0));
        return user;
    }

    public void setPerson(User user) {
        editor.putString(KEY_NAME, user.getName());
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.putString(KEY_PASS, user.getPass());
        editor.putInt(KEY_PHONE, user.getNoHp());
        setLogin(true);
        editor.commit();
    }

    public boolean isLogin() {
        return preferences.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public void setLogin(boolean isLogin) {
        editor.putBoolean(KEY_IS_LOGGED_IN, isLogin);
        editor.commit();
    }

    public void clear() {
        editor.clear();
        editor.commit();
    }


}
