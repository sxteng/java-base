package com.sxteng.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ServerSocketCilent {


    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        SocketAddress socketAddress = new InetSocketAddress("localhost", 9000);
        socketChannel.connect(socketAddress);

        int sendCount = 0;

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //这里最好使用selector处理   这里只是为了写的简单
        while (sendCount < 10) {
            buffer.clear();
            System.out.println("======");
            //向服务端发送消息
            buffer.put(("current time : " + System.currentTimeMillis()).getBytes());
            //读取模式
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();

            //从服务端读取消息
            int readLenth = socketChannel.read(buffer);
            //读取模式
            buffer.flip();
            byte[] bytes = new byte[readLenth];
            buffer.get(bytes);
            System.out.println(new String(bytes, "UTF-8"));
            buffer.clear();


            sendCount++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
