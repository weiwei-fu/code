package com.fww.code.design.factory;

/**
 * Created by @author fww on 2019-05-30.
 */
public enum Color {

    /**
     * 白色
     */
    WHITE("白色"),
    /**
     * 黑色
     */
    BLACK("黑色"),
    /**
     * 黄色
     */
    YELLOW("黄色"),
    ;

    /**
     * value
     */
    private final String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
