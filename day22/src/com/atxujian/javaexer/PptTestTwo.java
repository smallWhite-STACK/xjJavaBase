package com.atxujian.javaexer;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author xujian
 * @create 2020-03-01 10:58
 */
/*请把学生名与考试分数录入到集合中，
并按分数显示前三名 成绩学员的名字。
 */
public class PptTestTwo {

    public static void main(String[] args) {

        TreeSet treeSet = new TreeSet();
        Student s1 = new Student(60, "Jack", 1);
        Student s2 = new Student(70, "Lucky", 2);
        Student s3 = new Student(80, "Monkey", 3);
        Student s4 = new Student(90, "Joy", 4);
        Student s5 = new Student(100, "Yue", 5);

        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);
        treeSet.add(s4);
        treeSet.add(s5);
        System.out.println(treeSet);
        //由于要求只输出前三名，所以我们可以搞成List，然后索引输出前三个
        ArrayList list = new ArrayList(treeSet);
        List list1 = list.subList(0, 3);
        System.out.println(list1);

    }








}
class Student implements Comparable{
    private int score;
    private String name;
    private int id;

    public Student() {
    }

    public Student(int score, String name, int id) {
        this.score = score;
        this.name = name;
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (score != student.score) return false;
        if (id != student.id) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = score;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Student){
            Student temp=(Student)o;
            return -Integer.compare(this.score, temp.score);
        }
        throw new RuntimeException();
    }
}