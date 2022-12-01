package com.atxujian.javaexer;

/**
 * @author xujian
 * @create 2020-02-26 17:07
 */
public class PersonO {
    private int age;
    private String name;

    public PersonO() {
    }

    public PersonO(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonO{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonO personO = (PersonO) o;

        if (age != personO.age) return false;
        return name != null ? name.equals(personO.name) : personO.name == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
