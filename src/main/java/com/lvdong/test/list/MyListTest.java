package com.lvdong.test.list;

/**
 * Created by lvdong on 2017/5/28.
 */
public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list.toString());
        list.revese();
        System.out.println(list.toString());
    }
}
