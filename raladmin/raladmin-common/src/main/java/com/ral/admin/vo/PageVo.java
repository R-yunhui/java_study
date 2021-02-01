/*
 * @projectName raladmin
 * @package com.ral.admin.vo
 * @className com.ral.admin.vo.PageVo
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.vo;

import java.util.List;

import org.springframework.beans.BeanUtils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * PageVo
 * @Description 分页对象实体
 * @author renyunhui
 * @date 2021/2/1 15:39
 * @version 1.0
 */
@Data
public class PageVo<T> {
    /**
     * 分页数据
     */
    @ApiModelProperty(value = "分页数据")
    private List<T> records;
    /**
     * 总条数
     */
    @ApiModelProperty(value = "总条数")
    private Integer total;

    /**
     * 总页数
     */
    @ApiModelProperty(value = "总页数")
    private Integer pages;

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private Integer current;

    /**
     * 查询数量
     */
    @ApiModelProperty(value = "查询数量")
    private Integer size;

    /**
     * 设置当前页和每页显示的数量
     * @param pageForm 分页表单
     * @return 返回分页信息
     */
    @ApiModelProperty(hidden = true)
    public PageVo<T> setCurrentAndSize(PageForm<?> pageForm) {
        BeanUtils.copyProperties(pageForm, this);
        return this;
    }

    /**
     * 设置总记录数
     * @param total 总记录数
     */
    @ApiModelProperty(hidden = true)
    public void setTotal(Integer total) {
        this.total = total;
        this.setPages(this.total % this.size > 0 ? this.total / this.size + 1 : this.total / this.size);
    }
}
