package com.myth.socket;

import com.myth.repository.Repository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TvSocket implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("TvSocket启动");
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(1234);
            while (true) {
                Socket socket = serverSocket.accept();
                socket.setKeepAlive(true);
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                inputStream.read(bytes);
                String tvId = new String(bytes, "utf-8").trim();
                System.out.println("tv" + tvId + "上线");
                Repository.getTvSocketMap().put(Integer.parseInt(tvId), socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
