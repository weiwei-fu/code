package com.fww.code;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by @author fww on 2018/10/30.
 */

public class testOptional {

    @Test(expected = NullPointerException.class)
    public void whenCreateOfEmptyOptionalThenNullPointerException(){
        Optional<String> optional = Optional.of(null);
    }

    @Test
    public void whenCheckIfPresentThenOK(){
        Optional<String> optional = Optional.ofNullable("zhangsan");
        assertTrue(optional.isPresent());
        assertEquals("zhangsan", optional.get());
    }

    @Test
    public void whenExistedThenDoSomething(){
        InnerUser innerUser = new InnerUser();
        Optional<InnerUser> optional = Optional.ofNullable(innerUser);
        optional.ifPresent(innerUser1 -> innerUser1.setName("hello"));

        assertEquals("hello",innerUser.getName());

        innerUser=null;
        Optional.ofNullable(innerUser).ifPresent(e -> e.setName("world"));
        assertNull(innerUser);
    }


    @Test
    public void testReturndefault(){
        InnerUser innerUser = new InnerUser();
        innerUser.setName("zhangsan");
        InnerUser innerUser2 = new InnerUser();
        innerUser2.setName("lisi");
        InnerUser innerUser3 = null;
        InnerUser result = Optional.ofNullable(innerUser).orElse(innerUser2);
        InnerUser result2 = Optional.ofNullable(innerUser3).orElse(innerUser2);
        assertEquals("zhangsan",result.getName());
        assertEquals("lisi",result2.getName());
    }


    @Test
    public void testMap(){
        InnerUser innerUser = new InnerUser();
        innerUser.setName("haha");
        String name = Optional.ofNullable(innerUser).map(e -> e.getName()).orElse("zzz");
        assertEquals("haha",name);
        String sex = Optional.ofNullable(innerUser).map(e -> e.getSex()).orElse("what");
        assertEquals("what",sex);
    }

    @Test
    public void testFilter(){
        InnerUser innerUser = new InnerUser();
        innerUser.setName("world");
        Optional<InnerUser> optional = Optional.ofNullable(innerUser).filter(innerUser1 -> innerUser1.getName().equals("world"));
        assertTrue(optional.isPresent());
        assertEquals("world",optional.get().getName());
    }

    @Test
    public void testNUll(){
        InnerUser innerUser = new InnerUser();
        innerUser.setName("hello");
        innerUser.setSex("sex");
        String result = Optional.ofNullable(innerUser).map(name -> innerUser.getName()).map(sex -> innerUser.getSex()).orElse("ddd");
        assertEquals("sex",result);
    }

    private class InnerUser {
        private String name;
        private String sex;
        private int age = 0;

        public String getName() {
            return name;
        }

        public String getSex() {
            return sex;
        }

        public InnerUser setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public int getAge() {
            return age;
        }

        public InnerUser setAge(int age) {
            this.age = age;
            return this;
        }

        public InnerUser setName(String name) {
            this.name = name;
            return this;
        }
    }
}
