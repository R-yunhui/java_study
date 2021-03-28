package com.ral.admin.designpatterns.proxypatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-28 10:30
 * @Describe: 有一段这样的代码,如何能在不修改UserDao接口类的情况下开启事务和关闭事务呢.在保存前后打印出开启事务和关闭事务的信息，完成程序
 * 代理模式
 * @Modify:
 */
public class UserDao {

    public void save() {
        System.out.println("保存数据的方法");
    }
}
