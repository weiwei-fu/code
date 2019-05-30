package com.fww.code.design.factory;

/**
 * Created by @author fww on 2019-05-30.
 */
public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("肤色："+Color.YELLOW.getValue());
    }

    @Override
    public void talk() {
        System.out.println("黄种人说话了");
    }
}
