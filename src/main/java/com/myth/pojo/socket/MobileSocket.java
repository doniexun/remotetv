package com.myth.pojo.socket;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MobileSocket implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    class MythMobileServerRunnable implements Runnable {

        private Socket socket;
        public MythMobileServerRunnable(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
        }
    }
}
