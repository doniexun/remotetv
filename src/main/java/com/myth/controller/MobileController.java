package com.myth.controller;

import com.myth.repository.Repository;
import com.myth.service.impl.TvServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.Socket;

@Controller
public class MobileController {
    @Autowired
    private TvServiceImpl tvService;

    //以下为mobile端

    //开启连接
    @RequestMapping(value = "/getConnection.html")
    public ModelAndView getConnection(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("请求：/getConnection.html");
        try {
            request.setCharacterEncoding("utf-8");
            String connectionInfo = request.getParameter("connectionInfo");
            int tvCode = Integer.parseInt(connectionInfo.split("_")[2]);
            Socket socket = Repository.getTvSocketByCode(tvCode);
            if (socket == null) {
                response.setHeader("content-type", "text/html;charset=UTF-8");
                response.getWriter().write("0");//连接失败，要连接的设备不在线
                return new ModelAndView( "connectionInfo");
            }
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write((connectionInfo + "\n").getBytes("utf-8"));
            outputStream.flush();
            new Thread(() -> {
                try {
                    InputStream inputStream = socket.getInputStream();
                    byte[] bytes = new byte[1024];
                    inputStream.read(bytes);
                    String isBinding = new String(bytes, "utf-8");
                    if (isBinding.equals("1")) {
                        Repository.getConnectionInfo().add(connectionInfo);
                        response.setHeader("content-type", "text/html;charset=UTF-8");
                        response.getWriter().write("1");//连接成功
                    } else {
                        response.setHeader("content-type", "text/html;charset=UTF-8");
                        response.getWriter().write("0");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("error");
        }
        return new ModelAndView( "connectionInfo");
    }

    //获取App列表
    @RequestMapping(value = "/getAppList.html")
    public ModelAndView getAppList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("请求：/getAppList.html");
        String connectionInfo = request.getParameter("connectionInfo");
        int tvCode = Integer.parseInt(connectionInfo.split("_")[2]);
        if (Repository.getConnectionInfo().indexOf(connectionInfo) >= 0) {//查询两者是否已经连接
            try {
                Socket socket = Repository.getTvSocketByCode(tvCode);
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(("getAppList" + "\n").getBytes("utf-8"));
                new Thread(() -> {
                    try {
                        InputStream inputStream = socket.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                        String line = null;
                        String jsonData = "";
                        while ((line = reader.readLine()) != null) {
                            jsonData += line;
                        }
                        response.setHeader("content-type", "text/html;charset=UTF-8");
                        response.getWriter().write(jsonData);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            } catch (Exception e) {
                e.printStackTrace();
                return new ModelAndView("error");
            }
            return new ModelAndView("appList");
        } else return new ModelAndView("error");
    }

    //打开指定App
    @RequestMapping(value = "/openApp.html")
    public ModelAndView openApp(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("请求：/openApp.html");
        String appName = request.getParameter("appName");
        String connectionInfo = request.getParameter("connectionInfo");
        int tvCode = Integer.parseInt(connectionInfo.split("_")[2]);
        try {
            Socket socket = Repository.getTvSocketByCode(tvCode);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(("openApp_" + appName).getBytes("utf-8"));
            new Thread(() -> {
                try {
                    InputStream inputStream = socket.getInputStream();
                    byte[] bytes = new byte[1024];
                    inputStream.read(bytes);
                    String isOk = new String(bytes, "utf-8");
                    if (isOk.equals("1")) {
                        response.setHeader("content-type", "text/html;charset=UTF-8");
                        response.getWriter().write("1");//打开成功
                    } else {
                        response.setHeader("content-type", "text/html;charset=UTF-8");
                        response.getWriter().write("0");//失败
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
            return new ModelAndView("error");
        }
        return new ModelAndView("appList");
    }

    //注册
    @RequestMapping(value = "/register.html")
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("请求：/register.html");
        return new ModelAndView("register");
    }

    //测试
    @RequestMapping(value = "/index.html")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
