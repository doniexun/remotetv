package com.myth.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myth.pojo.TvInfo;
import com.myth.pojo.socket.TvSocket;
import com.myth.service.impl.TvServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class TvController {
    @Autowired
    private TvServiceImpl tvService;

    //以下为tv端
    @RequestMapping(value = "/sendAppList.html")
    public void sendAppList(HttpServletRequest request, HttpServletResponse response) {
        int tvId = Integer.parseInt(request.getParameter("tvId"));
        String tvInfosJson = request.getParameter("tvInfosJson");
        TvInfo tvInfo = new TvInfo();
        tvInfo.setTvAppList(tvInfosJson);
        tvInfo.setTvCode(tvId);
        tvService.updateByPrimaryKey(tvInfo);
    }
    @RequestMapping(value = "/isBinding.html")
    public void isBinding(HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping(value = "/agreeBinding.html")
    public void agreeBinding(HttpServletRequest request, HttpServletResponse response) {
        TvSocket.connectInfo.add(request.getParameter("connectionInfo"));
    }
}
