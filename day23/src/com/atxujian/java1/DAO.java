package com.atxujian.java1;

import java.util.List;

/**
 * @author xujian
 * @create 2020-03-01 19:58
 */
/*
* DAO：data access object(数据访问对象)
*ORM:object relational mapping(数据库中)
* */
public class DAO<T> {//表的共性操作的DAO

    //添加一条记录
    public void add(T t){

    }
    //删除一条记录
    public boolean remove(int index){
        return false;
    }

    //修改一条记录
    public void update(int index,T t){

    }
    //查询一条记录
    public T getIndex(int index){
        return null;
    }
    //查询多条记录(list)
    public List<T> getForList(int index){

        return null;
    }

    //可能也会有泛型方法
    public <E> E getValue(){
        return null;
    }

}
