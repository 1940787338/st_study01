package com.mobin.carbon.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {
    private static String logFilePath;
    private static BufferedWriter writer;
    private static boolean isInitialized = false;

    private static Integer requestNum = 0;

    // 获取当前程序路径
    private static String getCurrentPath() {
        return System.getProperty("user.dir");
    }

    // 初始化日志记录器
    private static void initializeLogger() {
        if (!isInitialized) {
            logFilePath = getCurrentPath() + File.separator + "log_" + ".txt";
            try {
                writer = new BufferedWriter(new FileWriter(logFilePath, true));
                isInitialized = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 写入日志
    public static void writeLog(HttpServletRequest request, String log) {
        if (!isInitialized) {
            initializeLogger();
        }

        try {
            String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

            String logEntry = "------------------------------啊彬科技------------------------------" +
                    "\n" + currentTime + ": " + log + "\n各请求总访问次数: " + ++requestNum + RequestUtil.getAll(request) + "\n";
            writer.write(logEntry);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 关闭日志记录器
    public static void closeLogger() {
        if (isInitialized) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}