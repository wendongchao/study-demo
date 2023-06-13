package com.example.reflection;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.example.reflection.SmallPineapple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @auther wendongchao
 * @date 2023/6/13 20:33
 **/
@Slf4j
public class Test01 extends TestCase {

    /**
     * 获取类的class对象
     *
     * @throws ClassNotFoundException
     */
    public void test01() throws ClassNotFoundException {
        Class clazz1 = Class.forName("org.example.reflection.SmallPineapple");
        Class clazz2 = SmallPineapple.class;
        SmallPineapple instance = new SmallPineapple();
        Class clazz3 = instance.getClass();
        System.out.println("Class.forName() == SmallPineapple.class:" + (clazz1 == clazz2));
        System.out.println("Class.forName() == instance.getClass():" + (clazz1 == clazz3));
        System.out.println("instance.getClass() == SmallPineapple.class:" + (clazz2 == clazz3));
    }

    /**
     * 无参构造方法
     *
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public void test02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class clazz1 = Class.forName("org.example.reflection.SmallPineapple");
        SmallPineapple smallPineapple = (SmallPineapple) clazz1.newInstance();
        smallPineapple.getInfo();
    }

    /**
     * 有参构造方法
     *
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public void test03() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz2 = Class.forName("org.example.reflection.SmallPineapple");
        Constructor constructor = clazz2.getConstructor(String.class, int.class);
        constructor.setAccessible(true);
        SmallPineapple smallPineapple2 = (SmallPineapple) constructor.newInstance("小菠萝", 21);
        smallPineapple2.getInfo();
    }

    /**
     * 李艳严
     * 获取类中的变量-Field
     *
     * @throws ClassNotFoundException
     */
    public void test04() throws ClassNotFoundException, NoSuchFieldException {
        Class clazz = Class.forName("org.example.reflection.SmallPineapple");
        // 获取 public 属性，包括继承
        Field[] fields1 = clazz.getFields();
        // 获取public指定属性名，包括继承
        Field address = clazz.getField("address");
        System.out.println(address.getName());
        // 获取所有属性，不包括继承
        Field[] fields2 = clazz.getDeclaredFields();
        // 获取指定属性，不包括继承
        Field age = clazz.getDeclaredField("age");
        System.out.println(age.getName());
    }

    /**
     * 获取类中的方法-Methods
     *
     * @throws ClassNotFoundException
     */
    public void test05() throws ClassNotFoundException, NoSuchMethodException {
        Class clazz = Class.forName("org.example.reflection.SmallPineapple");
        // 获取 public 方法，包括继承
        Method[] methods1 = clazz.getMethods();
        // 指定public方法，包括继承
        Method getMessage = clazz.getMethod("getMessage", String.class);
        System.out.println(getMessage.getName());
        // 获取所有方法，不包括继承
        Method[] declaredMethods = clazz.getDeclaredMethods();
        // 获取指定方法，不包括继承
        Method getInfo = clazz.getDeclaredMethod("getInfo");
        System.out.println(getInfo.getName());
    }

    /**
     * 获取类中的构造方法
     *
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     */
    public void test06() throws ClassNotFoundException, NoSuchMethodException {
        Class clazz = Class.forName("org.example.reflection.SmallPineapple");
        // 获取类中所有被public修饰的构造器
        Constructor[] constructors = clazz.getConstructors();
        // 根据参数类型获取类中某个构造器，该构造器必须被public修饰
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        // 获取类中所有构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
    }

    /**
     * 获取类中方法上的注解
     * 只有注解Retention标注为-RUNTIME，才能被解析
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     */
    public void test07() throws ClassNotFoundException, NoSuchMethodException {
        Class clazz = Class.forName("org.example.reflection.SmallPineapple");

        Method getInfo = clazz.getMethod("getInfo");
        // 获取类中的所有注解信息
        Annotation[] annotations = getInfo.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }
    }

    /**
     * 通过反射调用方法
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public void test08() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName("org.example.reflection.SmallPineapple");
        // 获取类class的对象
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        constructor.setAccessible(true);
        SmallPineapple sp = (SmallPineapple) constructor.newInstance("小菠萝", 21);

        Method getInfo = clazz.getMethod("getInfo");
        if (getInfo != null) {
            // invoke方法执行，第一个参数是对象，第二个参数是方法的参数对象
            getInfo.invoke(sp, null);
        }
    }

    /**
     * Spring的IOC容器
     */
    public void test09() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        SmallPineapple smallPineapple = (SmallPineapple) ac.getBean("smallpineapple");
        smallPineapple.getInfo(); // [小菠萝的年龄是：21]
    }


}
