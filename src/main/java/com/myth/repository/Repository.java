package com.myth.repository;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private static Map<Integer, Socket> tvSocketMap = new HashMap<>();
    private static List<String> connectionInfo = new ArrayList<>();

    public static Map<Integer, Socket> getTvSocketMap() {
        return tvSocketMap;
    }

    public static void setTvSocketMap(Map<Integer, Socket> tvSocketMap) {
        Repository.tvSocketMap = tvSocketMap;
    }

    public static List<String> getConnectionInfo() {
        return connectionInfo;
    }

    public static void setConnectionInfo(List<String> connectionInfo) {
        Repository.connectionInfo = connectionInfo;
    }

    public static Socket getTvSocketByCode(int tvCode) {
        return tvSocketMap.get(tvCode);
    }
}
