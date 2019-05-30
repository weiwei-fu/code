package com.fww.code.rtsp;

import org.springframework.scheduling.support.SimpleTriggerContext;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by @author fww on 2019-01-17.
 */
public class Demo {

    public static void main(String[] args) throws IOException {
        String host = "192.168.30.58";
        int port = 554;

        Socket socket = new Socket(host, port);

        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好  yiwangzhibujian";
        //首先需要计算得知消息的长度
        byte[] sendBytes = message.getBytes("UTF-8");
        //然后将消息的长度优先发送出去
        outputStream.write(sendBytes.length >>8);
        outputStream.write(sendBytes.length);
        //然后将消息再次发送出去
        outputStream.write(sendBytes);
        outputStream.flush();
        //==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
        message = "第二条消息";
        sendBytes = message.getBytes("UTF-8");
        outputStream.write(sendBytes.length >>8);
        outputStream.write(sendBytes.length);
        outputStream.write(sendBytes);
        outputStream.flush();
        //==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
        message = "the third message!";
        sendBytes = message.getBytes("UTF-8");
        outputStream.write(sendBytes.length >>8);
        outputStream.write(sendBytes.length);
        outputStream.write(sendBytes);

        outputStream.close();
        socket.close();
    }
}
