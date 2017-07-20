package com.example.kakaroto.sharedpreferencesdemo.model;

/**
 * Created by kakaroto on 17/07/17.
 */

public class User {
    private String name, email, pass;
    private int noHp, id;

    public User() {
    }

    public User(String name, String email, String pass, int noHp) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.noHp = noHp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setNoHp(int noHp) {
        this.noHp = noHp;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", noHp=" + noHp +
                '}';
    }
}
