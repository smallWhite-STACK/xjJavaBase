package com.atxujian.javaMap;

import org.junit.Test;

import java.util.*;

/**
 * @author xujian
 * @create 2020-02-26 17:18
 */
/*
1.Map的实现类
* Map：双列数据，存储key-value对的数据，----类似于高中的函数  y=f(x);
* /------HashMap：作为Map的主要实现类，线程不安全的，效率高，存储null的key与value,健壮性好
*       /----LinkedHashMap:保证在遍历map元素时，可以按添加的顺序遍历。
*                         原因：它在原有的HashMap的底层基础上，添加了一对指针，指向前一个和后一个
*                         对于频繁的遍历操作，此类执行效率高
*
* /------Hashtable(注意table小写):古老的是实现类（Vector）,线程安全的，效率低，不能存储null的key和value
*       /----Properties:常用来处理配置文件，key与value都是String类型
* /------TreeMap：可以按照的key-value对进行排序，实现遍历。（按照key的自然排序与定制排序）
*                   底层使用红黑树
*
*HashMap的底层：数组+链表（jdk7及之前）
*               数组+链表+红黑树（jdk8）
*
*      面试题：
*       1.HashMap的底层实现原理
*       2.HashMap与Hashtable的异同？
*       3.CurrentHashMap与Hashtable的异同？（暂不说）
*
* 二.Map结构的理解
*   Map中的key：无序的，不可重复的，使用set存储所有的key   --->key所在的类需要重写equals()与hashCode（）
*   Map中的value：无序的，可重复的，使用Collection存储所有的value   --->key所在的类需要重写equals()
*   一个键值对：key-value构成一个Entry的对象
*   Map中的entry：无序的、不可重复的，使用Set存储所有的entry
*
*三。HashMap的底层实现原理？以jdk7为例
*       HashMap map=new HashMap();
*       在实例化以后，底层创建了长度为16的一维数组Entry[] table
*       ...在经过执行多次的put操作...
*       map.put(key1,value1):
*       首先，调用key1所在类的hashCode()计算key1的哈希值，此哈希值经过某种算法计算以后得到得到在Entry数组的存储位置
*       如果此位置上的数据为空，此时的key1-value添加成功          ----情况一
*       如果此位置上数据不为空，（以为这次位置上存在一个或多个数据（以链表形式存储）），比较key1的值与与链表中的哈希值
*               如果key1的哈希值与已经存在的数据的哈希值都不相同，则添加成功        -----情况二
*               如果key1的哈希值与已经存在的某一个数据的哈希值相同，继续比较：调用key1所在类的equals(key2)方法
*                           如果equals()返回false:此时key1-value添加成功        ---情况三
*                           如果equals()返回true:此时将value1的值替换了value2的值
*
*        补充：情况二与情况三，此时的key1-value以链表的形式存储
*
*        在不断的添加的过程中，会涉及到扩容问题，当超出临界值且添加位置非空，则不再形成链表默认的扩容方式：扩容为原来的两倍，并将原有的数据复制过来
*
*   JDK8相较于JDK7在底层方面的不同：
*           1.new HashMap():底层没有创建一个长度为16的数组
*           2.JDK8中的底层数组是Node[]，而非Entry[]
*           3.首次使用put()方法时，底层数组创建了长度为16的数组
*           4.JDK7底层结构只有：数组+链表
*             JDK8中的底层数据：数组+链表+红黑树。
*             红黑树：当数组的某一个索引位置的元素以链表形式存在的数据个数>8且
*             当前数组的>64时，此时索引位置上的所有数据改为红黑树存储
*
*四：LinkedHashMap的底层实现原理
*
*                  HashMap中的内部类：Node
*       static class Node<K,V> implements Map.Entry<K,V> {
*       final int hash;
*       final K key;
*       V value;
*       Node<K,V> next;
*       }

                    LinkedHashMap中的内部类：Entry
*       static class Entry<K,V> extends HashMap.Node<K,V> {
*       Entry<K,V> before, after;  //能够记录添加元素的先后顺序
*       Entry(int hash, K key, V value, Node<K,V> next) {
*       super(hash, key, value, next);
*       }
*       }

*
* */

/*
* 常用方法：
* 添加   删除   修改    查询    长度     遍历
* */
public class MapTest {
/* Set keySet()：返回所有key构成的Set集合
 Collection values()：返回所有value构成的Collection集合
 Set entrySet()：返回所有key-value对构成的Set集合*/
    @Test
    public void test(){
        HashMap hashMap = new HashMap();
        hashMap.put("AA", 123);
        hashMap.put("BB", 321);
        hashMap.put("CC", 456);
        hashMap.put("DD", 789);
        System.out.println(hashMap);
        //替换
        hashMap.put("AA", 258);

        Set set = hashMap.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Collection values = hashMap.values();
        Iterator iterator1 = values.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        Set set1 = hashMap.entrySet();
        Iterator iterator2 = set1.iterator();
        while (iterator2.hasNext()){
            Object next = iterator2.next();
            //这里说明next是一个一个entry
            Map.Entry  entry=(Map.Entry)next;
            System.out.println(entry);
        }

    }







}
