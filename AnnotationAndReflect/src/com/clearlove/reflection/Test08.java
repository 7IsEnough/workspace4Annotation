package com.clearlove.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author promise
 * @date 2022/3/30 - 21:32
 * 获得类的信息
 */
public class Test08 {

  public static void main(String[] args)
      throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
    Class c1 = Class.forName("com.clearlove.reflection.User");

    // 获得类的名字
    // 获得包名 + 类名
    System.out.println(c1.getName());
    // 获得类名
    System.out.println(c1.getSimpleName());

    // 获得类的属性
    System.out.println("=================");
    // 只能找到public属性
    Field[] fields = c1.getFields();

    // 找到全部的属性
    fields = c1.getDeclaredFields();
    for (Field field : fields) {
      System.out.println(field);
    }

    // 获得指定属性的值
    Field name = c1.getDeclaredField("name");
    System.out.println(name);

    // 获得类的方法
    System.out.println("=================");
    Method[] methods = c1.getMethods();
    // 获得本类和父类的全部public方法
    for (Method method : methods) {
      System.out.println("正常的：" + method);
    }
    // 获得本类的所有方法
    methods = c1.getDeclaredMethods();
    for (Method method : methods) {
      System.out.println("getDeclaredMethods：" + method);
    }


    // 获取指定方法
    // 输入参数的原因是防止重载时，无法识别
    Method getName = c1.getMethod("getName", null);
    Method setName = c1.getMethod("setName", String.class);
    System.out.println(getName);
    System.out.println(setName);

    // 获得构造器
    System.out.println("=================");
    // 获得public方法
    Constructor[] constructors = c1.getConstructors();
    for (Constructor constructor : constructors) {
      System.out.println(constructor);
    }
    // 获得全部方法
    constructors = c1.getDeclaredConstructors();
    for (Constructor constructor : constructors) {
      System.out.println("#" + constructor);
    }

    // 获得指定的构造器
    Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
    System.out.println("指定" + declaredConstructor);
  }
}
