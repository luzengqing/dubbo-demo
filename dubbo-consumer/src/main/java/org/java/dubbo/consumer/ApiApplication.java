package org.java.dubbo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.java.dubbo.api.HelloService;

/**
 * @author zqlu
 * @date 2019/1/5
 */
public class ApiApplication {
    public static void main(String[] args) {
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbo-demo-consumer");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
//        registry.setAddress("zookeeper://127.0.0.1:2181");
        registry.setAddress("redis://127.0.0.1:6379");

        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接

        // 引用远程服务
        // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        ReferenceConfig<HelloService> reference = new ReferenceConfig<HelloService>();
        reference.setApplication(application);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        reference.setInterface(HelloService.class);

        // 和本地bean一样使用xxxService
        HelloService helloService = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
        String res = helloService.say("world");
        System.out.println(res);
    }
}
