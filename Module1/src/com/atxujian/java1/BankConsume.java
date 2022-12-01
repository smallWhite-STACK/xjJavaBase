package com.atxujian.java1;

/**
 * @author xujian
 * @create 2020-02-12 11:44
 */
/*
* 本例对应印象笔记模拟银行取钱的练习
*多线程440 */
class Account {
    private String accountNum;
    private double balance;
    //要求的两个构造器
    public Account(){
    }
    public Account(String accountNum,double balance){
        this.accountNum=accountNum;
        this.balance=balance;
    }

    public void getterAccount(String accountNum){
        System.out.println("账户："+accountNum+"准备开始存钱");
    }
    public void getterBalance(double balances){
        balance=balances+balance;
        System.out.println("钱存入，余额发生变化,为"+balance);
    }
    public void setterAccount(String accountNum){
        System.out.println("账户："+accountNum+"开始取钱");

    }
    public void setterBalance(double balances) {
        //取钱余额问题
        if (balance > balances) {
            balance = balance - balances;
        } else {
            System.out.println("余额不足，卡内余额为" + balance);
        }
    }
    //可以使用
   /* public Boolean equals(Object obj ){
        if(this==obj){

        }
    }*/

}

//两个线程类
    //小明类
class XiaoMing extends Thread{

}
public class BankConsume {
}
