package com.fww.code.design.proxy.jdkdynamic;

import java.lang.reflect.Proxy;

/**
 * Created by @author fww on 2018/12/21.
 */
public class JdkProxyHandle {

    private Object realStar;

    public JdkProxyHandle(Object realStar) {
        this.realStar = realStar;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(realStar.getClass().getClassLoader(),
                realStar.getClass().getInterfaces(), ((proxy, method, args) -> {
                    System.out.println("代理谈判");
                    Object object = method.invoke(realStar, args);
                    System.out.println("代理扫尾操作");
                    return object;
                }));
    }
}
