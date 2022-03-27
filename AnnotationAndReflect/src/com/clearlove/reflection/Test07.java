package com.clearlove.reflection;

/**
 * @author promise
 * @date 2022/3/27 - 17:05
 */
public class Test07 {
  public static void main(String[] args) throws ClassNotFoundException {
    // 获取系统类的加载器
    ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
    System.out.println(systemClassLoader);

    // 获取系统类加载器的父类加载器 --> 扩展类加载器
    ClassLoader parent = systemClassLoader.getParent();
    System.out.println(parent);

    // 获取扩展类加载器的父类加载器 --> 根加载器(C/C++)
    ClassLoader parent1 = parent.getParent();
    System.out.println(parent1);

    // 测试当前是哪个加载器加载的
    ClassLoader classLoader = Class.forName("com.clearlove.reflection.Test07").getClassLoader();
    System.out.println(classLoader);

    // 测试JDK内置的类是哪个加载器加载的
    classLoader = Class.forName("java.lang.Object").getClassLoader();
    System.out.println(classLoader);

    // 如何获取系统类加载器可以加载的路径
    System.out.println(System.getProperty("java.class.path"));

    // E:\workspace\workspace4AnnotationAndReflect\AnnotationAndReflect\out\production\AnnotationAndReflect


    // 双亲委派机制
  }
}
