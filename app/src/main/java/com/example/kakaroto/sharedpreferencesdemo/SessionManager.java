package com.example.kakaroto.sharedpreferencesdemo;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by kakaroto on 19/07/17.
 */

public class SessionManager {

    private static final String AUTH_PREFERENCES="auth";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";
    private static final String KEY_PHONE="phone";
    private static final String KEY_PASS="pass";
    private static final String KEY_IS_LOGGED_IN="login";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private static SessionManager instance;

    public SessionManager(Context context) {
        int PRIVATE_MODE = 0;
        preferences = context.getSharedPreferences(AUTH_PREFERENCES, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public static void init(Context context){
        instance = new SessionManager(context);
    }

    public synchronized static SessionManager getInstance(){
        return instance;
    }

    public void setPerson(Person person){
        editor.putString(KEY_NAME, person.getName());
        editor.putString(KEY_EMAIL, person.getEmail());
        editor.putString(KEY_PASS, person.getPass());
        editor.putInt(KEY_PHONE, person.getNoHp());
        setLogin(true);
        editor.commit();
    }

    public Person getPerson(){
        Person person = new Person(preferences.getString(KEY_NAME,""),
                preferences.getString(KEY_EMAIL,""),preferences.getString(KEY_PASS,""),
                preferences.getInt(KEY_PHONE,0));
        return person;
    }

    public void setLogin(boolean isLogin){
        editor.putBoolean(KEY_IS_LOGGED_IN, isLogin);
        editor.commit();
    }

    public boolean isLogin(){
        return preferences.getBoolean(KEY_IS_LOGGED_IN,false);
    }

    public void clear(){
        editor.clear();
        editor.commit();
    }


}
