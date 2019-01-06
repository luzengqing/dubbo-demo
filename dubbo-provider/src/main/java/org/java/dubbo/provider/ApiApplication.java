package org.java.dubbo.provider;

import com.alibaba.dubbo.config.*;
import org.java.dubbo.api.HelloService;

/**
 * @author zqlu
 * @date 2019/1/5
 */
public class ApiApplication {


    public static void main(String[] args) throws InterruptedException {
        // 服务实现
        HelloService helloService = new HelloServiceImpl();

        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbo-demo-provider");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
//        registry.setAddress("zookeeper://127.0.0.1:2181");
        registry.setAddress("redis://127.0.0.1:6379");

        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setHost("127.0.0.1");
        protocol.setPort(20880);

        // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口

        // 服务提供者暴露服务配置
        // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        ServiceConfig<HelloService> service = new ServiceConfig<>();
        service.setApplication(application);
        service.setRegistry(registry); // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol); // 多个协议可以用setProtocols()
        service.setInterface(HelloService.class);
        service.setRef(helloService);

        // 暴露及注册服务
        service.export();
        System.out.println("export success");
        while (true) {
            Thread.sleep(1000);
        }
    }
}
