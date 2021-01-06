package com.sxteng.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ServerSocketChannelServer {

    public static void main(String[] args) throws IOException {

        Selector selector =  Selector.open();

        ServerSocketChannel serverSocketChannel =  ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        InetSocketAddress addr = new InetSocketAddress(9000);
        serverSocketChannel.socket().bind(addr);

        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys =  selector.selectedKeys();
            Iterator<SelectionKey>  iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey selectionKey =  iterator.next();
                iterator.remove();

                if(selectionKey.isValid() && selectionKey.isReadable()) {
                    System.out.println("is readable ============");
                    SocketChannel sc = (SocketChannel) selectionKey.channel();
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    //从channel读数据到缓冲区
                    int readBytes = 0;
                    try {
                        readBytes = sc.read(readBuffer);
                    } catch (IOException e) {
                        sc.close();
                    }
                    if (readBytes > 0){
                        //Flips this buffer.  The limit is set to the current position and then
                        // the position is set to zero，就是表示要从起始位置开始读取数据
                        readBuffer.flip();
                        //eturns the number of elements between the current position and the  limit.
                        // 要读取的字节长度
                        byte[] bytes = new byte[readBuffer.remaining()];
                        //将缓冲区的数据读到bytes数组
                        readBuffer.get(bytes);
                        String body = new String(bytes, "UTF-8");
                        System.out.println("the time server receive order: " + body);
                    }
                }

                if (selectionKey.isValid() && selectionKey.isAcceptable()) {
                    ServerSocketChannel sc = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = sc.accept();
                    socketChannel.configureBlocking(false);
                    System.out.println("accept ============ socketChannel");
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }
            }

        }
    }


}
