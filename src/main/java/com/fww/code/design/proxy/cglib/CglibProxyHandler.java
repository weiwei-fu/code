package com.fww.code.design.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by @author fww on 2018/12/21.
 */
public class CglibProxyHandler implements MethodInterceptor{

    private Object target;

    public Object getProxyInstance(final Object target) {
        this.target = target;
        // Enhancer类是CGLIB中的一个字节码增强器，它可以方便的对你想要处理的类进行扩展
        Enhancer enhancer = new Enhancer();
        // 将被代理的对象设置成父类
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法，设置拦截器
        enhancer.setCallback(this);
        // 动态创建一个代理类
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("代理进行谈判cglib...");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("代理谈判后cglib...");
        return result;
    }
}
