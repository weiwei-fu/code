package com.fww.code.design.factory;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by @author fww on 2019-05-30.
 */
public class HumanFactoryTest {

    @Test
    public void createHuman() {
        AbstractHumanFactory humanFactory = new HumanFactory();

        Human whiteHuman = humanFactory.createHuman(WhiteHuman.class);
        assertEquals(Color.WHITE.getValue(),whiteHuman.getColor());
    }
}