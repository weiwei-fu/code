package com.fww.code.proxy.dynamic;

import com.fww.code.proxy.singlestatic.RealStar;
import com.fww.code.proxy.singlestatic.Star;

/**
 * Created by @author fww on 2018/12/21.
 */
public class Client {
    public static void main(String[] args) {
        Star star = new RealStar();
        Star proxy = (Star) new JdkProxyHandle(star).getProxyInstance();
        proxy.sing();
        proxy.say();
    }
}
