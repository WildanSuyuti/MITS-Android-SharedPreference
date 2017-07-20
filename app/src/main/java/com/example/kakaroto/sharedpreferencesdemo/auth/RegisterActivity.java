package com.example.kakaroto.sharedpreferencesdemo.auth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.kakaroto.sharedpreferencesdemo.R;
import com.example.kakaroto.sharedpreferencesdemo.model.User;
import com.example.kakaroto.sharedpreferencesdemo.utility.DatabaseHandler;

public class RegisterActivity extends AppCompatActivity {


    private final String TAG = RegisterActivity.class.getSimpleName();
    private EditText etName, etEmail, etPhone, etPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.et_name);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPhone = (EditText) findViewById(R.id.et_phone);
        etPass = (EditText) findViewById(R.id.et_pass);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    public void doRegister(View view) {
        DatabaseHandler db = DatabaseHandler.getInstance();

        User user = new User(etName.getText().toString(), etEmail.getText().toString(),
                etPass.getText().toString(), Integer.valueOf(etPhone.getText().toString()));
        if (user != null) {
//            SessionManager.getInstance().setPerson(user);
            db.addUser(user);
//            startActivity(new Intent(this, LoginActivity.class));
//            finish();

            for (User user1 : db.getAllUser()) {
                Log.d(TAG, "data : " + user1.toString());
            }
        }
    }

}
