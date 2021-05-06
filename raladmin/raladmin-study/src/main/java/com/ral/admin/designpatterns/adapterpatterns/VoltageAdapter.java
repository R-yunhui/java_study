package com.ral.admin.designpatterns.adapterpatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-28 15:11
 * @Describe: 适配器类 直接聚合被适配的类
 * @Modify:
 */
public class VoltageAdapter implements PhoneVoltage {

    private ChinaVoltage chinaVoltage;

    public VoltageAdapter(ChinaVoltage chinaVoltage) {
        this.chinaVoltage = chinaVoltage;
    }

    @Override
    public int optPutVoltage() {
        int voltage = 0;
        if (null != chinaVoltage) {
            voltage = chinaVoltage.outPut220V() / 44;
        }
        return voltage;
    }
}
