package java3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xujian
 * @create 2020-03-20 11:47

 动态代理

 */

interface Human{

        String position();
        void eat(String food);

}
//被代理类
class SuperMan implements Human{
    @Override
     public String position() {
        return "我在中国  ";
 }

     @Override
    public void eat(String food) {
         System.out.println("我喜欢"+food);
 }
}

//代理类
class ProxyFactory{
    //解决问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
    public static Object getProxyInstance(Object obj){
        //由于创建一个动态代理对象需要三个参数ClassLoader,Interface[],InvocationHandler(调用器)
        //我们看源码InvocationHandler是一个接口，我们搞一个类，实例化一个对象,其中有方法invoke
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();

        myInvocationHandler.bind(obj);
        //得到了一个代理类的对象，因为第三个参数时一个InvocationHandler的对象，由于已经封装好了，
        // 所以我们在创建一个动态代理对象的参数时，会调用方法invoke
        Object o = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), myInvocationHandler);
        return o;
    }

}

class MyInvocationHandler implements InvocationHandler{

    Object obj;//使用Object也可以看出来动态性，
                // 将被代理类的对象赋给obj,我们使用bind

    public void bind(Object obj){
        this.obj=obj;

    }
    //当我们通过代理类的对象，调用方法a时，就会自动调用如下的方法:invoke()
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //method：即为代理对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //我们的目的就是让代理调用与被代理同名的方法，达到调用被代理类的方法的目的
        //obj:被代理类的对象

        //invoke:第一个参数代表的是调用那个方法名，第二个参数代表 方法的参数的一个数组
        Object returnInvoke = method.invoke(obj,args);
        return returnInvoke;
    }
}
public class ProxyTest {

        public static void main(String[] args) {
            //创建被代理类的对象
            SuperMan superMan = new SuperMan();
            //创建代理类的对象:使用定义的类调用静态方法得到一个动态代理对象
            Human proxyInstance = (Human)ProxyFactory.getProxyInstance(superMan);

            /*Object proxyInstance = ProxyFactory.getProxyInstance(superMan);
            如果不进行强制类型转换，则无法调用被代理类的同名方法

            */
            //使用动态代理对象调用方法position与eat
            String position = proxyInstance.position();
            System.out.print(position);
            proxyInstance.eat("河南烩面");
        }

}
