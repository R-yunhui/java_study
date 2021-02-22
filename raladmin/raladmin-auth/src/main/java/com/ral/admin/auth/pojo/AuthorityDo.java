package com.ral.admin.auth.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * AuthorityDo
 * @Description: 权限信息实体表
 *
 * @author renyunhui
 * @date 2021/2/3 9:57
 * @version 1.0
 */
@ApiModel(value="权限表")
@Data
@TableName(value = "db_authority")
public class AuthorityDo implements Serializable {

    /**
     * 主键ID
     */
    @ApiModelProperty(value="主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权限ID
     */
    @ApiModelProperty(value="权限ID")
    private String authorityId;

    /**
     * 允许访问的url
     */
    @ApiModelProperty(value="允许访问的url")
    private String permissionUrl;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remark;

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

    private static final long serialVersionUID = 1L;
}