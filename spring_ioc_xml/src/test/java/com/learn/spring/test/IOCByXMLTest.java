package com.learn.spring.test;

import com.learn.spring.pojo.Clazz;
import com.learn.spring.pojo.Person;
import com.learn.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {

    /**
     * 获取bean的3种方式：
     * 1、根据bean的id获取
     * 2、根据bean的类型获取
     * *注意：根据类型获取bean时，要求IOC容器中有且只有一个类型匹配的bean
     * *若没有任何一个类型匹配的bean，此时抛出异常：NoSuchBeanDefinitionException
     * *若有多个类型匹配的bean，此时抛出异常：NoUniqueBeanDefinitionException
     * <p>
     * 3、根据bean的id和类型获取
     * 结论：根据类型来获取bean时，在满足bean唯一性的前提下
     * * 其实只是看：『对象 instanceof 指定的类型』的返回结果
     * * 只要返回的是true就可以认定为和类型匹配，能够获取到。
     * * 即通过bean的类型、bean所继承的类的类型、bean所实现的接口的类型都可以获取bean
     */
    @Test
    public void testIOC() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        //Student student = (Student) ioc.getBean("student1");
        //Student student = ioc.getBean(Student.class);
        //Student student = ioc.getBean("student1", Student.class);
        Person person = ioc.getBean(Person.class);

        System.out.println(person);
    }

    @Test
    public void testDI() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        //Student student2 = ioc.getBean("student2", Student.class);
        //Student student3 = ioc.getBean("student3", Student.class);
        Student student4 = ioc.getBean("student4", Student.class);
        //Clazz clazz = ioc.getBean(Clazz.class);

        System.out.println(student4);
    }
}
