/*
 * @projectName raladmin
 * @package com.ral.admin.function
 * @className com.ral.admin.function.MyFunction
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.function;

/**
 * MyFunction
 * @Description
 * @author renyunhui
 * @date 2021/3/22 16:52
 * @version 1.0
 */
@FunctionalInterface
public interface MyFunction<T, R, S> {

    /**
     * 测试函数式接口
     * @param t 参数
     * @param s 参数
     * @return 返回值
     */
    R run(T t, S s);
}
