/**
 * @author xujian
 * @create 2020-03-30 16:04
 */
public class test1 {
    public static void main(String[] args) {
       /* int a=1,b;
        b=(++a*3)+(++a*4);
        System.out.println(b);
        System.out.println(a);
*/
        //交换两个变量的值，不借助中间变量
        int s=1;
        int q=2;
        s=s+q;
        q=s-q;
        s=s-q;
        System.out.println(s);
        System.out.println(q);

        int a=1,b=2;
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("a:"+a+",b"+b);

    }
}
