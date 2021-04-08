/*
 * @projectName raladmin
 * @package com.ral.admin.designpatterns.observerpatterns
 * @className com.ral.admin.designpatterns.observerpatterns.Test
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.designpatterns.observerpatterns;

/**
 * Test
 * @Description
 * @author renyunhui
 * @date 2021/3/31 12:57
 * @version 1.0
 */
public class Test {

    public static void main(String[] args) {
        // 一般消息
        int messageLevel = 1;
        MessageSubject subject = new MessageSubject(messageLevel);
        MessageObserver observer = new MessageObserver();
        subject.addObserver(observer);
        subject.makeChanged();

        messageLevel = 2;
        subject.setMessageLevel(messageLevel);
        subject.makeChanged();

        messageLevel = 3;
        subject.setMessageLevel(messageLevel);
        subject.makeChanged();
    }
}
