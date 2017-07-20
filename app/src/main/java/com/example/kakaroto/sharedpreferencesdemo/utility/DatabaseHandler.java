package com.example.kakaroto.sharedpreferencesdemo.utility;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.kakaroto.sharedpreferencesdemo.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kakaroto on 20/07/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 5;
    private static final String DATABSE_NAME = "db_demo_sqlite";
    private static final String TABLE_USER = "user";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASS = "pass";
    private static final String KEY_NO_HP = "no_hp";
    private static SQLiteDatabase sqLiteDatabase;
    private static DatabaseHandler databaseHandler;
    private final String TAG = DatabaseHandler.class.getSimpleName();

    public DatabaseHandler(Context context) {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }

    public static void init(Context context) {
        databaseHandler = new DatabaseHandler(context);
        sqLiteDatabase = databaseHandler.getWritableDatabase();
    }

    public static synchronized DatabaseHandler getInstance() {
        return databaseHandler;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
/*        String CREATE_USER = "CREATE TABLE " + TABLE_USER + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + "TEXT,"
                + KEY_EMAIL + "TEXT,"
                + KEY_PASS + "TEXT,"
                + KEY_NO_HP + "INTEGER" + ")";*/

//CREATE TABLE user id INTEGER PRIMARY KEY,email TEXT

        String CREATE_USER = "CREATE TABLE " + TABLE_USER + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT,"
                + KEY_PASS + " TEXT,"
                + KEY_NO_HP + " INTEGER" + ")";

        sqLiteDatabase.execSQL(CREATE_USER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(sqLiteDatabase);
    }

    public void addUser(User user) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getName());
        values.put(KEY_EMAIL, user.getEmail());
        values.put(KEY_PASS, user.getPass());
        values.put(KEY_NO_HP, user.getNoHp());

        sqLiteDatabase.insert(TABLE_USER, null, values);
        Log.d(TAG, "insert table user success !");
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        String selectAllUser = "SELECT * FROM " + TABLE_USER + " ORDER BY " + KEY_ID + " DESC";

        Cursor cursor = sqLiteDatabase.rawQuery(selectAllUser, null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(cursor.getInt(0));
                user.setName(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setPass(cursor.getString(3));
                user.setNoHp(cursor.getInt(4));
                users.add(user);
            } while (cursor.moveToNext());
        }
        return users;
    }
}
