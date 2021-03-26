/*
 * @projectName raladmin
 * @package com.ral.admin.function
 * @className com.ral.admin.function.FunctionTest
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.function;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * FunctionTest
 * @Description
 * @author renyunhui
 * @date 2021/3/22 16:54
 * @version 1.0
 */
public class FunctionTest {

    public static void main(String[] args) {
        String dateString = ((MyFunction<LocalDateTime, String, String>) (localDateTime, s) -> LocalDateTime.MAX.format(DateTimeFormatter.ofPattern(s))).run(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss");
        System.err.println(dateString);
    }
}
