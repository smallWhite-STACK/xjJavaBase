package com.atxujian.exer;

import java.util.List;

/**
 * @author xujian
 * @create 2020-03-07 13:19
 */
/*定义一个测试类：
创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方 法来操作 User 对象，
使用 Junit 单元测试类进行测试。
*/
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<User>();
        userDAO.save("1001",new User(1,20,"Jack") );
        userDAO.save("1002",new User(2,60,"LaNa") );
        userDAO.save("1003",new User(3,40,"Monkey") );

        //其他操作省略

        List<User> list = userDAO.list();
        //System.out.println(list);
        list.forEach(System.out::println);  //java8新特性



    }

}
