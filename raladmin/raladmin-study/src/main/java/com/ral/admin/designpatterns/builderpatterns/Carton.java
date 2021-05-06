/*
 * @projectName raladmin
 * @package com.ral.admin.designpatterns.builderpatterns
 * @className com.ral.admin.designpatterns.builderpatterns.Carton
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.designpatterns.builderpatterns;

/**
 * Carton
 * @Description 纸盒
 * @author renyunhui
 * @date 2021/3/31 9:27
 * @version 1.0
 */
public class Carton implements Package {

    @Override
    public String getPackType() {
        return "纸盒";
    }
}
