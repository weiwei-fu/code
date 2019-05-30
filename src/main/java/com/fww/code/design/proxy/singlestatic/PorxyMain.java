package com.fww.code.design.proxy.singlestatic;

/**
 * Created by @author fww on 2018/12/21.
 */
public class PorxyMain {

    public static void main(String[] args) {
        Star star = new RealStar();
        ProxyStar proxyStar = new ProxyStar(star);
        proxyStar.sing();
    }
}
