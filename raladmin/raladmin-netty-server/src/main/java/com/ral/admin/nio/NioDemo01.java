/*
 * @projectName raladmin
 * @package com.ral.admin.nio
 * @className com.ral.admin.nio.NioDemo01
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.nio;

import java.nio.ByteBuffer;

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
        String msg = "nio学习";
        // 创建一个固定大小的buffer（HeapByteBuffer）
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byte[] byteArr = msg.getBytes();
        // 写入数据到 buffer
        byteBuffer.put(byteArr);
        // 缓冲区为双向的 可以写可以读 切换为读模式
        byteBuffer.flip();
        byte[] tempArr = new byte[1024];
        int start = 0;
        while (byteBuffer.hasRemaining()) {
            // 获取byteBuffer中的数据
            byte temp = byteBuffer.get();
            start++;
            tempArr[start] = temp;
        }
        log.info(new String(tempArr));
    }
}
