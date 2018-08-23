package org.dark.nativesocket;

import java.io.IOException;
import java.net.Socket;

/**
 * @author xiaozefeng
 * @date 2018/8/23 上午10:51
 */
public class Client {

    public static final String HOST = "127.0.0.1";
    public static final int PORT = 8000;
    public static final int SLEEP_TIME = 5000;

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket(HOST, PORT);
        new Thread(() -> {
            System.out.println("客户端启动成功");
            for (; ; ) {
                try {
                    String message = "hello world";
                    System.out.println("客户端发送消息:" + message);
                    socket.getOutputStream().write(message.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sleep();

            }

        }).start();


    }

    private static void sleep() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
