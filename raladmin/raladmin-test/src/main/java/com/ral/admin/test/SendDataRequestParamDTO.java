/**
 * @projectName jrjc
 * @package com.thunisoft.jrjc.jrjc.jr.dto
 * @className com.thunisoft.jrjc.jrjc.jr.dto.SendDataRequestDTO
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package com.ral.admin.test;

import java.io.Serializable;

import cn.hutool.json.JSONArray;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * SendDataRequestDTO
 * @description 发送数据请求参数类
 * @author tangchuan
 * @date 2020年2月25日 下午3:22:56
 * @version v3.1.3
 */
@Data
@ToString
@Builder
public class SendDataRequestParamDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String xtxxBh;

    /**
     * 平台统一案号
     */
    private String pttyah;

    /**
     * 业务系统标识
     */
    private String ywxtbs;

    /**
     * 存放路径,使用文件对接时，有值
     */
    private String cflj;

    /**
     * 发送单位编号
     */
    private String fsdwbh;

    /**
     * 接收单位编号
     */
    private String jsdwbh;

    /**
     * 业务类别
     */
    private String ywlb;

    /**
     * 业务阶段编号
     */
    private String ywjdbh;

    /**
     * 数据标识
     */
    private String sjbs;

    /**
     * 案件名称
     */
    private String ajmc;

    /**
     * 嫌疑人名称
     */
    private JSONArray xyrmcs;

    /**
     * 数据包md5
     */
    private String sjbmd5;

    /**
     * 发送时间
     */
    private String fssj;

    /**XML内容*/
    private String xmldata;

}
