package com.fww.code.design.factory;

/**
 * Created by @author fww on 2019-05-30.
 */
public class BlackHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("肤色："+Color.BLACK.getValue());
    }

    @Override
    public void talk() {
        System.out.println("黑人说话了");
    }
}
