package com.fww.code.design.factory;

/**
 * Created by @author fww on 2019-05-30.
 */
public class YellowHuman implements Human {
    @Override
    public String getColor() {
        return Color.YELLOW.getValue();
    }

    @Override
    public void talk() {
        System.out.println("黄种人说话了");
    }
}
