/*
 * @projectName raladmin
 * @package com.ral.admin.nio
 * @className com.ral.admin.nio.NioDemo01
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.nio;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import lombok.extern.slf4j.Slf4j;

/**
 * NioDemo01
 * @Description
 * @author renyunhui
 * @date 2021/3/18 18:15
 * @version 1.0
 */
@Slf4j
public class NioDemo01 {

    public static void main(String[] args) {
        String msg = "hello";
        // 创建一个固定大小的 buffer => (HeapByteBuffer)
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
        byte[] temp = new byte[1024];
        buffer.put(bytes);
        // 切换到读模式
        buffer.flip();
        temp[0] = buffer.get();
        log.info(new String(temp, Charset.defaultCharset()));

        // 清除以及读取过得数据 clear() => 清空缓冲区所有数据
        buffer.compact();
        msg = " world";
        buffer.put(msg.getBytes(StandardCharsets.UTF_8));
        log.info(new String(buffer.array(), Charset.defaultCharset()));
    }
}
