/*
 * @projectName test
 * @package com.example.test.api.dto
 * @className com.example.test.api.dto.InvokeApi
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package com.ral.admin.test;


import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * InvokeApi
 * @description 调用接口的接口
 * @author dengpu
 * @date 2021年03月02日 17:19
 * @version 3.2.0
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class InvokeApi {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/xmlData/{sjbs}")
    public Result sendXmlData(@PathVariable(value = "sjbs") String sjbs){
        try{
            SendDataRequestParamDTO data = SendDataRequestParamDTO.builder().pttyah("(2021)川第874号").ywlb(null).fsdwbh("100005").jsdwbh("2400").ywxtbs("t3c")
                    .ywjdbh("0120B").sjbs("B38E99934C43095CDA5DB5A97FCEF6A9").ajmc("刘莎莎盗窃案").xyrmcs(null).xmldata(getDocumentString()).fssj(DateUtil.now()).xtxxBh(null).build();
            ResponseEntity<Result> resultResponseEntity = restTemplate
                    .postForEntity("http://172.25.17.125:8082/jrjc/api/send/xmldata", data, Result.class);
            return resultResponseEntity.getBody();
        }catch (Exception e){
            log.error("调用失败",e);
            return Result.error("调用失败");
        }
    }

    private String getDocumentString() throws Exception {
        InputStream file = this.getClass().getClassLoader().getResourceAsStream("file/ywxx.xml");
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(file);
        return read.asXML();
    }
}
