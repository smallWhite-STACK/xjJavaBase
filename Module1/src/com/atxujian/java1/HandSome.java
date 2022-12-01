package com.atxujian.java1;

/**
 * @author xujian
 * @create 2020-02-12 12:36
 */
/*比较以下==与equals的区别
* */

/*
* Object类中默认存在两个方法equals()与hashCode()
* 其中equals()的比较规则就是比较两个 对象的内存地址。
* 而hashCode是本地方法，java的内存是安全的，因此无法根据散列码得到对象的内存地址，
* 实际上，hashCode是根据 对象的内存地址
* 经哈希算法得来的
*
* */
/*public class User{

    String name;
    int age;

    *//*
    * 保证equals返回true的两个对象一定是hashCode相等的
    * hashCode是用于散列数据的快速存取，如利用HashSet/HashMap/Hashtable类存储数据时，
    *
    * *//*

    public int hashCode(){
        int result=1;
        int prime=31;//为什么是31？因为这个数需要是质数 31是经验验证的一个能够很好地减少哈希碰撞的质数
        result=prime*result+age;//Integer的hashCode
        result=prime*result+((name==null)?0:name.hashCode());//字符串的hashCode
        return result;
    }

    public boolean equals(Object obj){
        if(this==obj)
            return true;
        if(obj==null)
            return false;
        if(obj instanceOf User){//A instanceOf B是判断A是否为B类型
            User other=(User)obj;
            if(age!=other.age)
                return false;
            if(name==null){
                if(other.name!=null)
                    return false;
            }else if (!name.equals(other.name)){
                return false;
            }
        }else{
            return false;
        }
        return true;
    }

}
public class HandSome {
    public static void main(String[] args) {
        String str="aaa";
        String str1="aaa";
        System.out.println(str==str1);//比较的地址是否相等
        System.out.println(str.equals(str1));//比较的是字符串是否相等







    }
}*/
