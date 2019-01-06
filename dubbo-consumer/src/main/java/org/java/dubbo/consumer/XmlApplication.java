package org.java.dubbo.consumer;

import org.java.dubbo.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zqlu
 * @date 2019/1/5
 */
public class XmlApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        context.start();
        HelloService helloService = (HelloService) context.getBean("helloService");
        String res = helloService.say("World");
        System.out.println(res);

    }
}
