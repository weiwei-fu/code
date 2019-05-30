package com.fww.code.design.factory;

/**
 * Created by @author fww on 2019-05-30.
 */
public abstract class AbstractHumanFactory {

    public abstract <T extends Human> T createHuman(Class<T> t);
}
