/*
 * @projectName raladmin
 * @package com.ral.admin.designpatterns.observerpatterns
 * @className com.ral.admin.designpatterns.observerpatterns.NormalObserver
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.designpatterns.observerpatterns;

import java.util.Observable;
import java.util.Observer;

/**
 * NormalObserver
 * @Description 消息观察者
 * @author renyunhui
 * @date 2021/3/31 12:52
 * @version 1.0
 */
public class MessageObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        switch (Integer.parseInt(arg.toString())) {
            case 1:
                System.out.println("观察到消息为一般消息,则以系统消息方式通知用户");
                break;
            case 2:
                System.out.println("观察到消息为预警消息,则以系统消息+邮件的方式通知用户");
                break;
            case 3:
                System.out.println("观察到消息为紧急消息,则以系统消息+邮件+短信的方式通知用户");
                break;
            default:
                break;
        }
    }
}
