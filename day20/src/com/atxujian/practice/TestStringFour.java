package com.atxujian.practice;

import org.junit.Test;

/**
 * @author xujian
 * @create 2020-02-16 21:11
 */
/*判断一个字符串在另一个字符串中出现的个数
* 比如：获取：ab在adhcjsahnckdksmc中出现的次数
* */

//视频讲解为：不断的调用indexOf方法，然后截取str2,赋予str2新的，然后再用indexOf找到新的str2的str1的地方，并计数

public class TestStringFour {
    int index;
    int count=0;
    public int countAll(String str1,String str2){
    if(str1.length()<str2.length()){
        //index要大于0
        while((index=str2.indexOf(str1))>=0) {

            str2 = str2.substring(index + str1.length());
            count++;
        }
        return count;
    }else{
        return -1;
    }
    }
    @Test
    public void test(){
        String str1="ab";
        String str2="abcdabcdabcd";
        int count=countAll(str1,str2);
        System.out.println(count);
    }
}
