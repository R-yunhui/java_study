/*
 * @projectName raladmin
 * @package com.ral.admin.designpatterns.observerpatterns
 * @className com.ral.admin.designpatterns.observerpatterns.MessageSubject
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.designpatterns.observerpatterns;

import java.util.Observable;

/**
 * MessageSubject
 * @Description: 消息主题对象
 * @author renyunhui
 * @date 2021/3/31 12:48
 * @version 1.0
 */
public class MessageSubject extends Observable {

    private int messageLevel;

    public MessageSubject(int messageLevel) {
        this.messageLevel = messageLevel;
    }

    public void setMessageLevel(int messageLevel) {
        this.messageLevel = messageLevel;
    }

    public int getMessageLevel() {
        return messageLevel;
    }

    public void makeChanged() {
        // 通知观察者发生变动
        setChanged();
        notifyObservers(this.messageLevel);
    }
}
