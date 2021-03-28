package com.ral.admin.designpatterns.adapterpatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-28 15:19
 * @Describe: 适配器使用者
 * @Modify:
 */
public class Phone {

    public int convertVoltage(PhoneVoltage voltage) {
        return voltage.optPutVoltage();
    }
}
