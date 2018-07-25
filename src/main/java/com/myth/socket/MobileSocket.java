package com.myth.socket;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.Socket;

public class MobileSocket implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("MobileSocket启动");
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
