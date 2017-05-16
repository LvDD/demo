package com.lvdong.test;

import java.util.HashMap;

/**
 * Created by lvdong on 2017/5/9.
 */
public class TestSingleton {
    public static void main(String args[]){
        Singleton singleton = Singleton.getSingleton();
        System.out.println("counter1="+singleton.counter1);
        System.out.println("counter2="+singleton.counter2);
    }
}
