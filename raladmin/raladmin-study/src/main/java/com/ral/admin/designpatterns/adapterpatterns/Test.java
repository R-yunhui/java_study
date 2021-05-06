package com.ral.admin.designpatterns.adapterpatterns;

/**
 * @Author: RenYunHui
 * @Date: 2021-03-28 14:55
 * @Describe:
 * @Modify:
 */
public class Test {

    public static void main(String[] args) {
        ChinaVoltage chinaVoltage = new ChinaVoltage();
        VoltageAdapter voltageAdapter = new VoltageAdapter(chinaVoltage);
        Phone phone = new Phone();
        // 传入被适配的对象
        int voltage = phone.convertVoltage(voltageAdapter);
        System.out.println("当前输入的电压为:" + chinaVoltage.outPut220V() + "V \n输出的电压为:" + voltage + "V");
    }
}
