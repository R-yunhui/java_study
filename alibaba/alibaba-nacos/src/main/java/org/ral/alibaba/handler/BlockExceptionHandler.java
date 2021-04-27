package org.ral.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: RenYunHui
 * @Date: 2021-04-27 20:53
 * @Describe:
 * @Modify:
 */
@Slf4j
public class BlockExceptionHandler {

    /**
     * say 方法的回调函数
     * Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
     * @param port 端口
     * @return 返回值
     */
    public String sayPortFallback(String port) {
        return "sayPortFallback -" + port;
    }

    /**
     * say方法的 Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
     * @param port 端口
     * @param e BlockException异常
     * @return 返回值
     */
    public String exceptionHandler(String port, BlockException e) {
        log.error("执行say方法失败:" + e);
        return "exceptionHandler -" + port;
    }
}
