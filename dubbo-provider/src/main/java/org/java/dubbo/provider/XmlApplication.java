package org.java.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zqlu
 * @date 2019/1/5
 */
public class XmlApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        context.start();
        System.out.println("start success");
        while (true) {

        }
    }
}
