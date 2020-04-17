package com.cy.user.dao;

/**
 * @Author: cy
 * @Date: 2019/3/19 18:54
 */
public interface TestInterface {

    public static void getMa(){

    }

    public int getC();

    public default String get() {
        return null;
    }
}
