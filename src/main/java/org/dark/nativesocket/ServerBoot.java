package org.dark.nativesocket;

/**
 * @author xiaozefeng
 * @date 2018/8/23 上午10:45
 */
public class ServerBoot {
    private final static int port = 8000;

    public static void main(String[] args) {
        Server server = new Server(port);
        server.start();
    }
}
