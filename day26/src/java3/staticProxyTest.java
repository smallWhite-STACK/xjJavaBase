package java3;

/**
 * @author xujian
 * @create 2020-03-20 11:13
 */
/*静态代理举类：
*
* 特点：代理类和被代理类在编译期间，就确定下来了
*
* */

interface ClothFactory{
    void produceCloth();

}

class ProxyClothFactory implements ClothFactory {

    public ClothFactory factory;
    public ProxyClothFactory(ClothFactory factory){
        this.factory=factory;
    }
    @Override
    public void produceCloth() {
        System.out.println("我是代理工厂");
        factory.produceCloth();
        System.out.println("代理工厂做事");
    }
}
class NikeClothFactory implements ClothFactory{
    @Override
    public void produceCloth() {
        System.out.println("我耐克要生产一批羽绒服");
    }
}
public class staticProxyTest{
    public static void main(String[] args) {
        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        ProxyClothFactory clothFactory = new ProxyClothFactory(nikeClothFactory);
        clothFactory.produceCloth();
    }

}