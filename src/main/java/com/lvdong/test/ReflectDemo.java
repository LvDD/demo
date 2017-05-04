package com.lvdong.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by lvdong on 2017/5/4.
 */
public class ReflectDemo {
    public static void main(String[] args) {
        try {
//            Dog dog = new Dog();
//            Class clazz1 = dog.getClass();
//            System.out.println(clazz1.getName());
//
//            Class clazz2 = Dog.class;
//            System.out.println(clazz2.getName());
//
//            Class clazz3 = Class.forName("com.lvdong.test.Dog",false,Dog.class.getClassLoader());
//            System.out.println(clazz3.getName());
//
//            Class clazz4 = Class.forName("com.lvdong.test.Dog");
//            System.out.println(clazz4.getName());

            Class class_dog = Dog.class;
            Field[] fields = class_dog.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getName());
            }
            Method[] methods = class_dog.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
                if (method.getName().equals("wangwang")) {
                    method.invoke(new Dog(),"呜");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Cat {
    private String name;
    private int age;
    static {
        System.out.println("Cat is load");
    }
}

class Dog {
    private String name;
    private int age;
    static {
        System.out.println("Dog is load");
    }

    public void wangwang(String something){
        System.out.println("汪汪~~~" + something);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}