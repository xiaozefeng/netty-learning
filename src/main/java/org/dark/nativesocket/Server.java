package org.dark.nativesocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xiaozefeng
 * @date 2018/8/23 上午10:40
 */
public class Server {

    private ServerSocket serverSocket;

    public Server(int port) {
        init(port);
    }

    private void init(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("服务端启动成功，端口：" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        new Thread(this::doStart).start();
    }

    private void doStart() {
        try {
            Socket client = serverSocket.accept();
            new ClientHandler(client).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
