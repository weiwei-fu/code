package com.fww.code.design.factory;

/**
 * Created by @author fww on 2019-05-30.
 */
public class NvWa {

    public static void main(String[] args) {
        AbstractHumanFactory yinYangLu = new HumanFactory();
        Human whiteHuman = yinYangLu.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();

        Human blackHuman = yinYangLu.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();

        Human yelloHuman = yinYangLu.createHuman(YellowHuman.class);
        yelloHuman.getColor();
        yelloHuman.talk();

    }
}
