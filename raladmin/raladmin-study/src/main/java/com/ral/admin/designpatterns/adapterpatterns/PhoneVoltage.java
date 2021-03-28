package com.ral.admin.designpatterns.adapterpatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-28 15:12
 * @Describe: 适配目标的抽象接口
 * @Modify:
 */
public interface PhoneVoltage {

    /**
     * 电压输出
     * @return 输出的电压数
     */
    int optPutVoltage();
}
