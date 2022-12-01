package com.atxujian.exer;

import java.util.*;

/**
 * @author xujian
 * @create 2020-03-07 12:49
 */

/*
* 定义个泛型类 DAO<T>，在其中定义一个 Map 成员变量，
* Map 的键 为 String 类型，值为 T 类型。

分别创建以下方法：
public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员 变量中
public T get(String id)：从 map 中获取 id 对应的对象
public void update(String id,T entity)：替换 map 中 key 为 id 的内容, 改为 entity 对象
public List<T> list()：返回 map 中存放的所有 T 对象
public void delete(String id)：删除指定 id 对象

定义一个 User 类：
该类包含：private 成员变量（int 类型） id，age；（ String 类型）name。

定义一个测试类：
创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方 法来操作 User 对象，
使用 Junit 单元测试类进行测试。
* */
public class DAO<T> {
    //为了避免调用下列方法时空指针异常，所以对map初始化
    private Map<String,T> map=new HashMap<String,T>();

    public void save(String id,T entity){
        //保存 T 类型的对象到 Map 成员 变量中
        map.put(id, entity);
    }
    public T get(String id){
        //从 map 中获取 id 对应的对象
        return  map.get(id);
    }
    public void update(String id,T entity){
        //替换 map 中 key 为 id 的内容, 改为 entity 对象
       // map.put(id, entity);  直接put不严谨，如果没有此id就变为添加了
        if(map.containsKey(id)){
            map.put(id, entity);
        }
    }
    public List<T> list(){
        //返回 map 中存放的所有 T 对象

        /*Collection<T> values = map.values();
        return (List<T>) values;  错误的*/
        //正确的
        List<T> list = new ArrayList<T>();
        Collection<T> values = map.values();
        for(T t: values){
            list.add(t);
        }
        return list;
    }
    public void delete(String id){
        //删除指定 id 对象
        map.remove(id);
    }


}
