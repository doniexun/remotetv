package com.myth.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myth.pojo.TvInfo;
import com.myth.service.TvService;
import com.myth.service.impl.TvServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MobileController {
    @Autowired
    private TvServiceImpl tvService;

    //以下为mobile端
    @RequestMapping(value = "/getConnection.html")
    public void getConnection(HttpServletRequest request, HttpServletResponse response) {
        
    }
    @RequestMapping(value = "/getAppList.html")
    public void getAppList(HttpServletRequest request, HttpServletResponse response) {
    }
    @RequestMapping(value = "/openApp.html")
    public void openApp(HttpServletRequest request, HttpServletResponse response) {
    }
}
