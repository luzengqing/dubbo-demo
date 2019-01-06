package org.java.dubbo.provider;

import org.java.dubbo.api.HelloService;

/**
 * @author zqlu
 * @date 2019/1/5
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String say(String name) {
        return "Hello, ".concat(name);
    }
}
