package com.chuancheng.test;

import com.chuancheng.pojo.UserBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jws.soap.SOAPBinding;

public class IocMainTest {

    /**
     * Ioc控制反转
     * 非Ioc的操作
     */
    @Test
    public void fun1(){
        //非Ioc，我们之间new出来
        UserBean userBean = new UserBean();
        userBean.say();
    }

    /**
     * 基于Ioc方式
     */
    @Test
    public void fun2(){
        //1.IOC容器的初始化操作,调用UserBean中无参构造器创建对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.从容器中获取对象
        UserBean userBean = (UserBean) ac.getBean("userBean");
        userBean.say();
    }

    /**
     * 根据 name 获取对象
     */
    @Test
    public void fun3(){
        //1.IOC容器的初始化操作,调用UserBean中无参构造器创建对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserBean userBean =(UserBean) ac.getBean("user1");
        userBean.say();
    }

    /**
     * 根据类型获取对象
     */
    @Test
    public void fun4(){
        //1.IOC容器的初始化操作,调用UserBean中无参构造器创建对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserBean userBean = ac.getBean(UserBean.class);
        userBean.say();
    }

    /**
     * 组合方式获取对象
     */
    @Test
    public void fun5(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserBean userBean = ac.getBean("userBean",UserBean.class);
        userBean.say();
    }
}
