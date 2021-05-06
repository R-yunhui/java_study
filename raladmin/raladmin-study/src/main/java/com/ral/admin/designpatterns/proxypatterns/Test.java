package com.ral.admin.designpatterns.proxypatterns;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-28 10:31
 * @Describe:
 * @Modify:
 */
public class Test {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        // cglib代理方式
        CglibDynamicProxyFactory proxyFactory = new CglibDynamicProxyFactory();
        UserDao proxy = (UserDao) proxyFactory.getProxy(userDao);
        proxy.save();
    }

    static class CglibDynamicProxyFactory implements MethodInterceptor {

        public Object getProxy(Object target) {
            Enhancer enhancer = new Enhancer();
            // CGLib通过继承被代理类的方式实现代理
            enhancer.setSuperclass(target.getClass());
            enhancer.setCallback(this);
            return enhancer.create();
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("开启事务");

            // 调用被拦截的方法
            Object result = methodProxy.invokeSuper(o, objects);

            System.out.println("关闭事务");
            return result;
        }
    }
}
