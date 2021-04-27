package org.ral.alibaba.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.ral.alibaba.handler.BlockExceptionHandler;
import org.springframework.stereotype.Service;

/**
 * @Author: RenYunHui
 * @Date: 2021-04-27 20:45
 * @Describe:
 * @Modify:
 */
@Service
@Slf4j
public class TestService {

    @SentinelResource(value = "say", blockHandler = "exceptionHandler",
            blockHandlerClass = {BlockExceptionHandler.class}, fallback = "sayPortFallback", fallbackClass = {BlockExceptionHandler.class})
    public String say(String port) {
        return "hello world - " + port;
    }
}
