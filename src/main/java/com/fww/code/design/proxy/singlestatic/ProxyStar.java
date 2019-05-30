package com.fww.code.design.proxy.singlestatic;

/**
 * Created by @author fww on 2018/12/21.
 */
public class ProxyStar implements Star{

    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void sing() {
        System.out.println("代理类进行操作开始");
        this.star.sing();
        System.out.println("代理类进行操作结束");
    }

    @Override
    public void say() {
        System.out.println("-----");
    }
}
