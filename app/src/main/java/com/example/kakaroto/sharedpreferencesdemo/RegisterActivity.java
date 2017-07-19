package com.example.kakaroto.sharedpreferencesdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {


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

    public void doRegister(View view){
        Person person =new Person(etName.getText().toString(), etEmail.getText().toString(),
                etPass.getText().toString(),Integer.valueOf(etPhone.getText().toString()));
        if(person !=null) {
            SessionManager.getInstance().setPerson(person);
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }

}
