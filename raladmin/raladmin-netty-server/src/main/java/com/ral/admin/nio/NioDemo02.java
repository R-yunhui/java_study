/*
 * @projectName raladmin
 * @package com.ral.admin.nio
 * @className com.ral.admin.nio.NioDemo02
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

import lombok.extern.slf4j.Slf4j;

/**
 * NioDemo02
 * @Description
 * @author renyunhui
 * @date 2021/3/22 14:46
 * @version 1.0
 */
@Slf4j
public class NioDemo02 {
    public static void main(String[] args) {
        File file = new File(ClassLoader.getSystemResource("test/test.txt").getPath());
        nioRead(file);
        nioWrite(ClassLoader.getSystemResource("test").getPath() + "/demo.txt");
    }

    public static void nioRead(File file) {
        try (FileChannel channel = new FileInputStream(file).getChannel()
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            log.info("当前限制是:{},容量是:{},位置是:{}", buffer.limit(), buffer.capacity(), buffer.position());
            while (channel.read(buffer) != -1) {
                // 注意，读取后，将位置置为0，将limit置为容量, 以备下次读入到字节缓冲中，从0开始存储
                log.info("当前限制是:{},容量是:{},位置是:{}", buffer.limit(), buffer.capacity(), buffer.position());
                log.info(new String(buffer.array()));
                buffer.clear();
            }
        } catch (IOException e) {
            log.error("读取文件信息失败:", e);
        }
    }

    public static void nioWrite(String fileName) {
        try (FileChannel channel = new FileOutputStream(fileName).getChannel()
        ) {
            ByteBuffer src = StandardCharsets.UTF_8.encode("hello");
            // 字节缓冲的容量和limit会随着数据长度变化，不是固定不变的
            log.info("初始化容量:{},limit：{}", src.capacity(), src.limit());
            int length;
            while ((length = channel.write(src)) != 0) {
                // 注意，这里不需要clear，将缓冲中的数据写入到通道中后 第二次接着上一次的顺序往下读
                log.info("写入长度:" + length);
            }
        } catch (IOException e) {
            log.error("读取文件信息失败:", e);
        }
    }
}
