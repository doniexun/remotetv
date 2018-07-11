package com.myth.pojo.socket;

import com.myth.pojo.TvInfo;

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
    public static Map<Integer, Socket> socketMap = new HashMap<>();
    public static List<String> connectInfo = new ArrayList<>();
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(1234);
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String getTvInfo = reader.readLine();
                reader.close();
                String tvSendedInfo[] = getTvInfo.split("|_|");
                socketMap.put(Integer.parseInt(tvSendedInfo[0]), socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
