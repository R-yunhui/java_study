/*
 * @projectName raladmin
 * @package com.ral.admin.vo
 * @className com.ral.admin.vo.PageForm
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.vo;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * PageForm
 * @Description 分页表单数据实体
 * @author renyunhui
 * @date 2021/2/1 15:43
 * @version 1.0
 */
@Data
@ApiModel(value = "分页数据", description = "分页需要的表单数据")
public class PageForm<T extends PageForm<?>> {

    /**
     * 页码
     */
    @ApiModelProperty(value = "页码 从第一页开始 1")
    @Min(value = 1, message = "页码输入有误")
    private Integer current;

    /**
     * 每页显示的数量
     */
    @ApiModelProperty(value = "每页显示的数量 范围在1~100")
    @Range(min = 1, max = 100, message = "每页显示的数量输入有误")
    private Integer size;

    /**
     * 计算当前页 ,方便mysql 进行分页查询
     * @return 返回 pageForm
     */
    @ApiModelProperty(hidden = true)
    public T calcCurrent() {
        current = (current - 1) * size;
        return (T) this;
    }
}
