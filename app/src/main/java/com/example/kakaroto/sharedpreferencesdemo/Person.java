package com.example.kakaroto.sharedpreferencesdemo;

/**
 * Created by kakaroto on 17/07/17.
 */

public class Person {
    private String name, email, pass;
    private int noHp;

    public Person(String name, String email, String pass, int noHp) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.noHp = noHp;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public int getNoHp() {
        return noHp;
    }

    public String info(){
        return "Hala nama saya : "+name+" no HP : "+noHp;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", noHp=" + noHp +
                '}';
    }
}
