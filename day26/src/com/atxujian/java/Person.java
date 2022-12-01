package com.atxujian.java;

/**
 * @author xujian
 * @create 2020-03-18 15:01
 */
public class Person {
    private String name;
    public int age;
    private String nation;
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String nation) {
        this.name = name;
        this.age = age;
        this.nation = nation;
    }

    public void show(String name){
        System.out.println("我是一个人");
    }
    private void showArea(String nation){
        System.out.println("我出生在"+nation);
    }
}
