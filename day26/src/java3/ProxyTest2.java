package java3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xujian
 * @create 2020-03-20 15:04
 */
interface Dog{

    void info();
    void run();

}
class HuntingDog implements Dog{
    @Override
    public void info() {
        System.out.println("我是一个猎狗");

    }

    @Override
    public void run() {
        System.out.println("我跑的特别快");
    }
}

class DogUtil{
    public void method1(){
        System.out.println("--------模拟通用方法------=");
    }
    public void method2(){
        System.out.println("-------模拟通用方法二-------");
    }
}
class My2InvocationHandler implements InvocationHandler{
    // 需要被代理的对象
    private Object target;
    public void setTarget(Object target){
        this.target = target;
    }
    // 执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception{
        DogUtil du = new DogUtil();
        // 执行DogUtil对象中的method1。
        du.method1();
        // 以target作为主调来执行method方法
        Object result = method.invoke(target , args);
        // 执行DogUtil对象中的method2。
        du.method2();
        return result;
    }
}

class MyProxyFactory{
    // 为指定target生成动态代理对象
    public static Object getProxy(Object target) throws Exception{
    // 创建一个MyInvokationHandler对象
    My2InvocationHandler handler = new My2InvocationHandler();
    // 为MyInvokationHandler设置target对象
    handler.setTarget(target);
    // 创建、并返回一个动态代理对象
    return Proxy.newProxyInstance(target.getClass().getClassLoader() , target.getClass().getInterfaces() , handler);
    // }
 }
}
    public class ProxyTest2 {
        public static void main(String[] args) throws Exception {
            // 创建一个原始的HuntingDog对象，作为target
            Dog target = new HuntingDog();
            // 以指定的target来创建动态代理
            Dog dog = (Dog) MyProxyFactory.getProxy(target);
            dog.info();
            dog.run();
        }
    }
