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
 * UserDo
 * @Description UserDo用户信息表
 * @author renyunhui
 * @date 2021/2/1 15:50
 * @version 1.0
 */
@ApiModel(value = "用户信息表")
@Data
@TableName(value = "user")
public class UserDo implements Serializable {
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    @TableId(type = IdType.UUID)
    private String userId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码")
    private String passWord;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private Integer gender;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String phoneNumber;

    /**
     * 状态 1 - 启用  2 - 禁用  3 - 删除
     */
    @ApiModelProperty(value = "状态 1 - 启用  2 - 禁用  3 - 删除")
    private Integer status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createUser;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人")
    private String updateUser;

    /**
     * 修改方式 1 - 创建  2 - 修改
     */
    @ApiModelProperty(value = "修改方式 1 - 创建  2 - 修改")
    private Integer modifyMethod;

    private static final long serialVersionUID = 1L;
}