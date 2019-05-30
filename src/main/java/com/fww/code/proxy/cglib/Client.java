package com.fww.code.proxy.cglib;

import com.fww.code.proxy.singlestatic.RealStar;
import com.fww.code.proxy.singlestatic.Star;

/**
 * Created by @author fww on 2018/12/21.
 */
public class Client {

    public static void main(String[] args) {
        Star realStar = new RealStar();
        Star proxy = (Star) new CglibProxyHandler().getProxyInstance(realStar);
        proxy.sing();

        proxy.say();
    }

}
