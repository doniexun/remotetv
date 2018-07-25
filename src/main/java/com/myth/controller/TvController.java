package com.myth.controller;

import com.myth.pojo.TvInfo;
import com.myth.repository.Repository;
import com.myth.socket.TvSocket;
import com.myth.service.impl.TvServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        Repository.getConnectionInfo().add(request.getParameter("connectionInfo"));
    }
}
