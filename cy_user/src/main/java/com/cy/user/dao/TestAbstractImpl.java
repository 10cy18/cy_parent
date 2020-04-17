package com.cy.user.dao;

/**
 * @Author: cy
 * @Date: 2019/3/19 19:11
 */
public class TestAbstractImpl{

    public static void main(String[] args) {
        /*int a = 2<<2;//2*2^2
        int b = 17>>>3;//2/3^3
        System.out.println(a);
        System.out.println(b);*/
        int[] arr = {0,1,2,3,4,5,6};
        //Object src,  int  srcPos,Object dest, int destPos, int length
        System.arraycopy(arr,3,arr,2,4);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
    /*public static void main(String[] args) {
        TestAbstract ta = new TestAbstract() {
            @Override
            public void getAbs() {
                return ;
            }
        };

        TestInterface ti = new TestInterface() {
            @Override
            public int getC() {
                return 0;
            }

            @Override
            public String get() {
                return null;
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
    }*/
}
