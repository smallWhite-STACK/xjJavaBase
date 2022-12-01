package com.atxujian.javaMap;

/**
 * @author xujian
 * @create 2020-02-26 10:56
 */
public class Customer implements Comparable{
    private String name;
    private int age;

    public Customer() {
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (age != customer.age) return false;
        return name != null ? name.equals(customer.name) : customer.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        //先判断类型       注意instanceof的of小写
        if(o instanceof Customer){
            Customer customer=(Customer) o;
            int compare = this.name.compareTo(customer.name);
            if(compare!=0){
                return compare;
            }else{
                return Integer.compare(this.age,customer.age);
            }
        }else{
            throw new RuntimeException("输入类型不匹配");
        }
    }
}
