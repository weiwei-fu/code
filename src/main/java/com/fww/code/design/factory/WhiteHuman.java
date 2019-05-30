package com.fww.code.design.factory;

/**
 * Created by @author fww on 2019-05-30.
 */
public class WhiteHuman implements Human{
    @Override
    public String getColor() {
        return Color.WHITE.getValue();
    }

    @Override
    public void talk() {
        System.out.println("白人说话了");
    }
}
