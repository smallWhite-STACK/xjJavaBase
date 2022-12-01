package com.atxujian.javaMap;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author xujian
 * @create 2020-02-28 15:01
 */
public class PropertiesTest {

    public static void main(String[] args) throws Exception {

        FileInputStream fis = null;
        try {
            Properties properties = new Properties();

            fis = new FileInputStream("jdbc.properties");
            properties.load(fis);


            String name=properties.getProperty("name");
            String password=properties.getProperty("password");

            System.out.println(name+"////"+password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }


}
