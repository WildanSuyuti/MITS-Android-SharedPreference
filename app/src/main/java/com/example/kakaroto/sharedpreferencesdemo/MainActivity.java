package com.example.kakaroto.sharedpreferencesdemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etName, etNoHP;
    private TextView tvResult;

    private final String KEY_NAME="neme";
    private final String KEY_NO_HP ="mail";
    private final String PREFERENCE_NAME="simple_preference";

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);

        etName = (EditText) findViewById(R.id.et_name);
        etNoHP = (EditText) findViewById(R.id.et_no_hp);
        tvResult = (TextView) findViewById(R.id.tv_result);

//        sharedPreferences.edit().clear();

//        if(getPerson() !=null) tvResult.setText(getPerson().info());

    }

    public void doSubmit(View view){
        Person person = new Person(etName.getText().toString(), Integer.valueOf(etNoHP.getText().toString()));
        setPerson(person);
        if(getPerson() !=null) tvResult.setText(getPerson().info());

    }
    private void setPerson(Person person){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NAME, person.getName());
        editor.putInt(KEY_NO_HP, person.getNoHp());
        editor.commit();
    }

    private Person getPerson(){
        Person person = new Person(sharedPreferences.getString(KEY_NAME,""), sharedPreferences.getInt(KEY_NO_HP,0));
        return person;
    }
}
