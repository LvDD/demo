package com.lvdong.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

/**
 * Created by lvdong on 2017/5/3.
 */
public class NioDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("D://nio_test.txt", "rw");
        FileChannel channel = accessFile.getChannel();
        //创建初始容量48的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(48);

        int read = channel.read(buffer); // 读取通道内的数据到缓冲区
        while (read != -1) { //保证还有内容可读
            buffer.flip();//切换到读模式
            while (buffer.hasRemaining()) {
                System.out.println(buffer.get());//每次读取一个字节
            }

            buffer.clear();//切换到写模式
            channel.read(buffer);
        }
        channel.close();//通道关闭
    }
}
