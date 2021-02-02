package com.ral.admin.auth.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * AuthorityDo
 * @Description AuthorityDo 权限表
 * @author renyunhui
 * @date 2021/2/1 15:50
 * @version 1.0
 */
@ApiModel(value="权限表")
@Data
public class AuthorityDo implements Serializable, GrantedAuthority {
    /**
     * 权限ID
     */
    @ApiModelProperty(value="权限ID")
    private Integer authorityId;

    /**
     * 权限码
     */
    @ApiModelProperty(value="权限码")
    private String authorityCode;

    /**
     * 权限描述
     */
    @ApiModelProperty(value="权限描述")
    private String description;

    /**
     * 状态  1 - 启用  2 - 禁用  3 - 已删除
     */
    @ApiModelProperty(value="状态  1 - 启用  2 - 禁用  3 - 已删除")
    private Integer status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value="创建人")
    private String createUser;

    /**
     * 修改时间
     */
    @ApiModelProperty(value="修改时间")
    private Date updateTime;

    /**
     * 修改人
     */
    @ApiModelProperty(value="修改人")
    private String updateUser;

    /**
     * 修改方式  1 - 新增  2 - 修改
     */
    @ApiModelProperty(value="修改方式  1 - 新增  2 - 修改")
    private Integer modifyMethod;

    private static final long serialVersionUID = 1L;

    @Override
    public String getAuthority() {
        return authorityCode;
    }
}