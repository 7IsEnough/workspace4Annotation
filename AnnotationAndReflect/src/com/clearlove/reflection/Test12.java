package com.clearlove.reflection;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * @author promise
 * @date 2022/4/4 - 16:58
 * 练习反射操作注解
 */
public class Test12 {

  public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
    Class c1 = Class.forName("com.clearlove.reflection.Student2");

    // 通过反射获得注解
    Annotation[] annotations = c1.getAnnotations();
    for (Annotation annotation : annotations) {
      System.out.println(annotation);
    }

    // 获取注解的value的值
    TableClearlove tableClearlove = (TableClearlove)c1.getAnnotation(TableClearlove.class);
    System.out.println(tableClearlove.value());


    // 获得类指定的注解
    Field name = c1.getDeclaredField("id");
    FleldClearlove annotation = name.getAnnotation(FleldClearlove.class);
    System.out.println(annotation.columnName());
    System.out.println(annotation.type());
    System.out.println(annotation.length());
  }
}

@TableClearlove("db_student")
class Student2 {
  @FleldClearlove(columnName = "db_id", type = "int", length = 10)
  private int id;
  @FleldClearlove(columnName = "db_age", type = "int", length = 10)
  private int age;
  @FleldClearlove(columnName = "db_name", type = "varchar", length = 3)
  private String name;

  public Student2() {
  }

  public Student2(int id, int age, String name) {
    this.id = id;
    this.age = age;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Student2{" +
        "id=" + id +
        ", age=" + age +
        ", name='" + name + '\'' +
        '}';
  }
}


// 类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableClearlove {
  String value();
}

// 属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FleldClearlove{
  String columnName();
  String type();
  int length();
}
