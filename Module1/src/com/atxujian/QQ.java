package com.atxujian;

/**
 * @author xujian
 * @create 2020-02-23 15:27
 */
public class QQ {

    //关于判断一个QQ邮箱的格式
    private static String qq;

    public QQ() {
    }

    public QQ(String qq) {
        this.qq = qq;
    }

    public boolean qqTest (String qq){
        char[] smallQQ= qq.toCharArray();
        for (int i = 0; i <smallQQ.length ; i++) {
            //判断@qq.com前的数字个数个数
            if(smallQQ.length-7>10){
                System.out.println("你输入的数字太长，请重新输入！");
                return false;
            }
            char temp=smallQQ[i];
            int ascii=(int) temp;
            if(i==0&&ascii==48){
                System.out.println("请输入数字！");
                return false;
            }else if(ascii>48&&ascii<=57){
                //直接使用endWith方法看邮箱最后以什么形式结尾
                String suffix="@qq.com";
                boolean b = qq.endsWith(suffix);
                if(b==true){
                    System.out.println("输入格式正确");
                }else{
                    System.out.println("请以正确的格式结尾“@qq.com");
                }
                return b;
            }else{
                return false;
            }
        }
        return true;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getQq() {
        return qq;
    }

    public static void main(String[] args) {
        QQ q = new QQ();
        q.setQq("2693144549qq.com");


        System.out.println(q.getQq());
        q.qqTest(qq);
    }
}
