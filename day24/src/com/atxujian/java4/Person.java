package com.atxujian.java4;

import java.io.Serializable;

/**
 * @author xujian
 * @create 2020-03-13 16:10
 */

/*
* Person实现序列化的条件
* 1实现Serializable接口
* 2当前类提供一个全局常量：serialVersionUID 序列版本号
* 3除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性也必须是可序列化的。
* （默认情况下，基本数据类型可序列化）
* 例如：Person中的一个内部类Access也必须继承Serializable接口
*
*
*
* 补充：对象流中不可以被static 、 transient修饰
* */
public class Person implements Serializable {

    public static final long serialVersionUID = 421482282528L;
    private String name;
    private int age;
    Acount account;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", account=" + account +
                '}';
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, Acount account) {
        this.name = name;
        this.age = age;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Acount getAccount() {
        return account;
    }
}
class Acount implements Serializable{
    private double balance;

    @Override
    public String toString() {
        return "Acount{" +
                "balance=" + balance +
                '}';
    }

    public Acount() {
    }

    public Acount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}