/*
 * @projectName raladmin
 * @package com.ral.admin.stream
 * @className com.ral.admin.stream.Demo01
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Demo01
 * @Description java8 流的学习
 * @author renyunhui
 * @date 2021/4/30 15:11
 * @version 1.0
 */
@Slf4j
public class Demo01 {

    /** 男 */
    private static final int MAN = 1;
    /** 女 */
    private static final int WOMAN = 2;

    public static void main(String[] args) {
        UserPo userPoOne = UserPo.builder().id(1).age(21).gender(1).username("mike").password("321").birthday(DateUtil.parse("1996-08-19")).wage(7800).bonus(1000).build();
        UserPo userPoTwo = UserPo.builder().id(2).age(22).gender(2).username("mary").password("123").birthday(DateUtil.parse("1997-07-21")).wage(7500).bonus(1200).build();
        UserPo userPoThree = UserPo.builder().id(3).age(23).gender(2).username("amy").password("312").birthday(DateUtil.parse("1997-09-25")).wage(9800).bonus(2000).build();
        UserPo userPoFour = UserPo.builder().id(4).age(21).gender(2).username("lily").password("456").birthday(DateUtil.parse("1997-10-19")).wage(9500).bonus(1500).build();
        UserPo userPoFive = UserPo.builder().id(5).age(22).gender(1).username("bob").password("654").birthday(DateUtil.parse("1998-09-22")).wage(12500).bonus(1800).build();
        UserPo userPoSix = UserPo.builder().id(6).age(20).gender(1).username("jack").password("465").birthday(DateUtil.parse("1997-02-03")).wage(11500).bonus(2500).build();
        UserPo userPoSeven = UserPo.builder().id(7).age(19).gender(1).username("peter").password("789").birthday(DateUtil.parse("1996-06-19")).wage(8500).bonus(2100).build();
        UserPo userPoEight = UserPo.builder().id(8).age(18).gender(1).username("james").password("987").birthday(DateUtil.parse("1995-12-15")).wage(6600).bonus(1400).build();
        UserPo userPoNine = UserPo.builder().id(9).age(26).gender(2).username("rose").password("798").birthday(DateUtil.parse("1999-05-14")).wage(6500).bonus(3000).build();
        UserPo userPoTen = UserPo.builder().id(10).age(29).gender(1).username("jackson").password("135").birthday(DateUtil.parse("2000-10-12")).wage(8000).bonus(3500).build();
        List<UserPo> dataList = Lists.newArrayList(userPoOne, userPoTwo, userPoThree, userPoFour, userPoFive, userPoSix, userPoSeven, userPoEight, userPoNine, userPoTen);

        // 按性别分组
        Map<String, List<UserPo>> userPoMap = dataList.stream().collect(Collectors.groupingBy(userPo -> MAN == userPo.getGender() ? "男" : (WOMAN == userPo.getGender() ? "女" : "暂无")));
        log.info("按性别分组：" + JSONUtil.toJsonStr(userPoMap));

        // 过滤出来工资在8000以上且年龄在21及以下的男生,并按工资进行排序取前3位
        List<UserPo> resultOne = dataList.stream().filter(userPo -> MAN == userPo.getGender() && userPo.getAge() >= 21 && userPo.getWage() >= 8000).sorted(Comparator.comparing(UserPo::getWage).reversed()).limit(3).collect(Collectors.toList());
        log.info("过滤出来工资在8000以上且年龄在21及以下的男生,并按工资进行排序取前3位的数据为：" + JSONUtil.toJsonStr(resultOne));

        // 统计工资在10000元以上的人的姓名
        List<String> resultTwo = dataList.stream().filter(x -> x.getWage() >= 10000).map(userPo -> userPo.getUsername() + "工资：" + userPo.getWage()).collect(Collectors.toList());
        log.info("工资在10000元以上的人的姓名：" + JSONUtil.toJsonStr(resultTwo));

        // 统计所有人一个月工资的总和
        int count = dataList.stream().mapToInt(UserPo::getWage).sum();
        log.info("统计所有人一个月工资的总和：" + count);

        // 按姓名进行分组统计每人每月的收入
        Map<String, Integer> resultThree = dataList.stream().collect(Collectors.toMap(UserPo::getUsername, userPo -> userPo.getBonus() + userPo.getWage()));
        log.info("按姓名进行分组统计每人每月的收入：" + JSONUtil.toJsonStr(resultThree));

        dataList.stream().reduce((o1, o2) -> UserPo.builder()
                .id(11)
                .age(21)
                .birthday(DateUtil.parse("1997-05-23"))
                .username("admin")
                .password("113")
                .gender(MAN)
                .wage(o1.getWage() + o2.getWage())
                .bonus(o1.getBonus() + o2.getBonus())
                .build()).ifPresent(x -> log.info("老板的月收入是所有员工月收入的总和：" + JSONUtil.toJsonStr(x)));
    }
}
