/*
 * @projectName test
 * @package com.example.test.commons
 * @className com.example.test.commons.Result
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package com.ral.admin.test;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Result
 * @description TODO
 * @author dengpu
 * @date 2021年03月02日 17:32
 * @version 3.2.0
 */
@Builder
@Getter
@Setter
public class Result {

    private Integer code;
    private String msg;

    public static Result error(String msg){
        return Result.builder().code(HttpStatus.BAD_REQUEST.value()).msg(msg).build();
    }
    public static Result success(String msg){
        return Result.builder().code(HttpStatus.OK.value()).msg(msg).build();
    }

}
