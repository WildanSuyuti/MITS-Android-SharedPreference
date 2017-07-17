package com.example.kakaroto.sharedpreferencesdemo;

/**
 * Created by kakaroto on 17/07/17.
 */

public class Person {
    private String name;
    private int noHp;

    public Person(String name, int noHp) {
        this.name = name;
        this.noHp = noHp;
    }

    public String getName() {
        return name;
    }

    public int getNoHp() {
        return noHp;
    }

    public String info(){
        return "Hala nama saya : "+name+" no HP : "+noHp;
    }
}
