package test.com;

import org.junit.Test;

/**
 * @author xujian
 * @create 2022-11-16 15:44
 */
public class MyTest {
    int id;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyTest myTest = (MyTest) o;

        if (id != myTest.id) return false;
        return name.equals(myTest.name);
    }

    @Override
    public String toString() {
        return "MyTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }
    @Test
    public  void xj(int x) {
        // TODO 自动生成的方法存根
//        new Object()
        int[] a=new int[]{1,2,3};
        int[] b = a;
        System.out.println(a[0]);
        System.out.println(b[0]);
        a[0]=78;
        System.out.println(a[0]);
        System.out.println(b[0]);
    }
}
