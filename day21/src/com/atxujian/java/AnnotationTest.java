package com.atxujian.java;

/**
 * @author xujian
 * @create 2020-02-22 10:26
 */
public class AnnotationTest {

    public static void main(String[] args) {
        Person person = new Person("徐健",20);
        System.out.println(person.getName());

    }
}
class Person{
    @SuppressWarnings("")
    private int i;
    private String name;
    private int age;
@MyAnnotation(value = "hi")
@MyAnnotation
    public Person() {
    }
@MyAnnotation
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}