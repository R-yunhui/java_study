package com.ral.admin.auth.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * RoleDo
 * @Description RoleDo 角色表
 * @author renyunhui
 * @date 2021/2/1 15:50
 * @version 1.0
 */
@ApiModel(value="角色表")
@Data
public class RoleDo implements Serializable {
    /**
     * 角色ID
     */
    @ApiModelProperty(value="角色ID")
    private String roleId;

    /**
     * 角色名
     */
    @ApiModelProperty(value="角色名")
    private String roleName;

    /**
     * 所含权限码
     */
    @ApiModelProperty(value="所含权限码")
    private String authorityCodes;

    /**
     * 状态 1 - 启用 2 - 禁用 3 - 已删除
     */
    @ApiModelProperty(value="状态 1 - 启用 2 - 禁用 3 - 已删除")
    private Integer status;

    /**
     * 创建人
     */
    @ApiModelProperty(value="创建人")
    private String createUser;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 修改人
     */
    @ApiModelProperty(value="修改人")
    private String updateUser;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date updateTime;

    /**
     * 最后修改方式 1 - 新增 2 - 修改
     */
    @ApiModelProperty(value="最后修改方式 1 - 新增 2 - 修改")
    private Integer modifyMethod;

    /**
     * 对应的权限信息
     */
    private List<AuthorityDo> authorityDoList;

    private static final long serialVersionUID = 1L;
}