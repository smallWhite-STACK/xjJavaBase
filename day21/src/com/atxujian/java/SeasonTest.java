package com.atxujian.java;

/**
 * @author xujian
 * @create 2020-02-21 16:08
 */
public class SeasonTest {

    public static void main(String[] args) {
        Season spring=Season.Spring;
        System.out.println(spring);
    }
}
//自定义枚举类
class Season{
    //类--private final属性变量--私有的构造器--
    // 提供当前的枚举类的多个对象---其他诉求（get方法  toString方法等）

    //1.私有的属性变量
    private String seasonName;
    private String seasonDes;
    //2.私有构造器

    private Season(String seasonName, String seasonDes) {
        this.seasonName = seasonName;
        this.seasonDes = seasonDes;
    }
    //3.提供当前枚举类的多个对象
       public static final Season Spring=new Season("春天","春暖花开");
    public static final Season Summer=new Season("夏天","夏日骄阳");
    public static final Season Fall=new Season("秋天","秋风萧瑟");
    public static final Season Winter=new Season("冬天","白雪皑皑");

    //4.其他诉求，比如获取属性，输出字符串

    public String getSeasonName() {
        return seasonName;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDes='" + seasonDes + '\'' +
                '}';
    }
}
