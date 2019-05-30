package com.fww.code.design.factory;

/**
 * Created by @author fww on 2019-05-30.
 */
public class HumanFactory extends AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> t) {
        Human human = null;
        try {
            human = (T) Class.forName(t.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.out.println("创建错误");
        }
        return (T) human;
    }
}
