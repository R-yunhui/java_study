package com.ral.admin.auth.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * RoleDo
 * @Description: 角色信息实体表
 *
 * @author renyunhui
 * @date 2021/2/3 9:57
 * @version 1.0
 */
@ApiModel(value="角色表")
@Data
@TableName(value = "db_role")
public class RoleDo implements Serializable, GrantedAuthority {

    /**
     * 主键ID
     */
    @ApiModelProperty(value="主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remark;

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

    private static final long serialVersionUID = 1L;

    @Override
    public String getAuthority() {
        return this.roleName;
    }
}