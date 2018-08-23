package org.dark.nativesocket;


import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author xiaozefeng
 * @date 2018/8/23 上午10:44
 */
public class ClientHandler {

    private final static int MAX_DATA_LEN = 1024;
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        System.out.println("新客户端接入");
        new Thread(this::doStart).start();
    }

    private void doStart() {
        try {
            InputStream inputStream = socket.getInputStream();
            for (; ; ) {
                byte[] data = new byte[MAX_DATA_LEN];
                int len;
                while ((len = inputStream.read(data)) != -1) {
                    String message = new String(data, 0, len);
                    System.out.println("客户端传来消息:" + message);
                    socket.getOutputStream().write(data);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
