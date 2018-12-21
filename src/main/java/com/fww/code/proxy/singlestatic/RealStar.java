package com.fww.code.proxy.singlestatic;

/**
 * Created by @author fww on 2018/12/21.
 */
public class RealStar implements Star{
    @Override
    public void sing() {
        System.out.println("start sing!");
    }

    @Override
    public void say() {
        System.out.println("说点啥");
    }
}
