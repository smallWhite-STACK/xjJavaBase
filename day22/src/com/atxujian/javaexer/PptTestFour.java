package com.atxujian.javaexer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author xujian
 * @create 2020-03-01 11:59
 */

/*对一个Java源文件中的关键字进行计数。
提示：Java源文件中的每一个单词，需要确定该单词是否是一个关键字。
为了高效处理这个问题，将所有的关键字保存在一个HashSet中。用contains() 来测试。
*/
public class PptTestFour {
    public static void main(String[] args) {
        File pptTestOne = new File("D:\\UserIntellijIDEA\\IdeaProjectsAnd\\day22\\src\\com\\atxujian\\javaexer\\PptTestOne.java");
        Scanner scanner = null;
        try {
            scanner = new Scanner(pptTestOne);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(scanner.hasNext()){
            String s = scanner.next();
            System.out.println(s);

        }
    }
}
