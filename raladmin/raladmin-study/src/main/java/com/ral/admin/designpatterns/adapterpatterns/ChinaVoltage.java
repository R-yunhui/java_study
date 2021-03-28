package com.ral.admin.designpatterns.adapterpatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-28 15:10
 * @Describe: 适配者类
 * @Modify:
 */
public class ChinaVoltage {

    /** 电压220V */
    private int voltage = 220;

    public int outPut220V() {
        return voltage;
    }
}
