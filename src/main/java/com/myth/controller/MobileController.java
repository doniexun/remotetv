package com.myth.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myth.pojo.TvInfo;
import com.myth.pojo.socket.TvSocket;
import com.myth.service.TvService;
import com.myth.service.impl.TvServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

@Controller
public class MobileController {
    @Autowired
    private TvServiceImpl tvService;

    //以下为mobile端
    @RequestMapping(value = "/getConnection.html")
    public void getConnection(HttpServletRequest request, HttpServletResponse response) {
        String connectionInfo = request.getParameter("connectionInfo");
        int tvId = Integer.parseInt(connectionInfo.split("|_|")[2]);
        try {
            Socket socket = TvSocket.socketMap.get(tvId);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write((connectionInfo + "\n").getBytes("utf-8"));
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/getAppList.html")
    public void getAppList(HttpServletRequest request, HttpServletResponse response) {
        String connectionInfo = request.getParameter("connectionInfo");
        int tvId = Integer.parseInt(connectionInfo.split("|_|")[2]);
        if (TvSocket.connectInfo.indexOf(connectionInfo) > 0) {
            try {
                Socket socket = TvSocket.socketMap.get(tvId);
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write((connectionInfo + "\n").getBytes("utf-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @RequestMapping(value = "/openApp.html")
    public void openApp(HttpServletRequest request, HttpServletResponse response) {
    }
}
