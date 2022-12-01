package com.atxujian;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xujian
 * @create 2022-11-20 21:20
 */
public class TestString {
    public static void main(String[] args) {
        String s1= "123456ahv";
        String s2 = "789123k";
        System.out.println(getMaxSubString(s1,s2));
        for(int i =0;i<1;i++){
            System.out.println("123");
        }
    }
    public static List<String> getMaxSubString(String str1, String str2){
        String maxStr = (str1.length() > str2.length())? str1 : str2;
        String minStr = (str1.length() < str2.length())? str1 : str2;
        int len = minStr.length();
        List<String> list = new ArrayList<>();
        for(int i = 0;i < len;i++){
            for(int x = 0,y = len - i;y <= len;x++,y++){
                String str = minStr.substring(x, y);
                if(maxStr.contains(str)){
                    list.add(str);
                }
            }
            if(list.size() != 0){
                return list;
            }
        }
        return null;
    }
}
