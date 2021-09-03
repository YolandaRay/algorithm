package org.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class TestProperty {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {

            InputStream in = TestProperty.class.getClassLoader().getResourceAsStream("milk.properties");
            URL url = Test.class.getClassLoader().getResource("env.properties")  ;
            properties.load(in);
            String path = (String) properties.get("path");
            System.out.println(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
