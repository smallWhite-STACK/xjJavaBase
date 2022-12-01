package com.atxujian.java;

import java.util.Arrays;

/**
 * @author xujian
 * @create 2020-02-21 16:42
 */
public class SeasonEnumTest {
    public static void main(String[] args) {
        Season1 spring = Season1.Spring;
        System.out.println(spring);//Season{seasonName='春天', seasonDes='春暖花开'}
        System.out.println(Season.class.getSuperclass());   //class java.lang.Object
        System.out.println(Season1.class.getSuperclass());  //class java.lang.Enum

        //values()
        Season1[] values = Season1.values();
        System.out.println(Arrays.toString(values));
//[Season{seasonName='春天', seasonDes='春暖花开'}, Season{seasonName='夏天', seasonDes='夏日骄阳'}, Season{seasonName='秋天', seasonDes='秋风萧瑟'},
// Season{seasonName='冬天', seasonDes='白雪皑皑'}]
        for (int i = 0; i <values.length; i++) {
            System.out.println(values[i]);

        }

        //valueOf(Object objName) 返回枚举类中对象名是objName的对象
        String str="Spring";
        Season1 season1 = Season1.valueOf(str);
        System.out.println(season1);    //Season{seasonName='春天', seasonDes='春暖花开'}

        Season1 fall = Season1.Fall;
        System.out.println(fall.toString());//Season{seasonName='秋天', seasonDes='秋风萧瑟'}
        fall.show();

    }
}
interface  Infor{
    public void show();
}
enum Season1 implements Infor{

    //1.提供当前枚举类的多个对象
    Spring("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    Summer("夏天","夏日骄阳"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    Fall("秋天","秋风萧瑟"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    Winter("冬天","白雪皑皑"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    //2.私有的属性变量
    private String seasonName;
    private String seasonDes;
    //3.私有构造器

    private Season1(String seasonName, String seasonDes) {
        this.seasonName = seasonName;
        this.seasonDes = seasonDes;
    }

    //4.其他诉求，比如获取属性，输出字符串

    public String getSeasonName() {
        return seasonName;
    }

    /*@Override
    public void show() {
        System.out.println("这是一个季节");
    }*/

   /* @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDes='" + seasonDes + '\'' +
                '}';
    }*/

}
