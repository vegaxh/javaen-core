package com.javaen.core.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * <p>
 * Project Name: javaen-core
 * <br>
 * Description:
 * <br>
 * File Name: WebUtils
 * <br>
 * Copyright: Copyright (C) 2019 All Rights Reserved.
 * <br>
 *
 * @author: vegaxh 
 * <p>
 * Date                 Author      Version     Description
 * ------------------------------------------------------------------
 * 2019/8/25 10:51     |vegaxh      |v1.0.0       |Create
 */
public interface WebUtils {

    public static void writeHtml(HttpServletResponse res, String str) {
        try {
            res.setContentType("text/html;charset=utf-8");
            res.setHeader("cache-control", "no-cache");
            PrintWriter out = res.getWriter();
            out.write(str);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeJson(HttpServletResponse res, String str) {
        try {
            res.setContentType("application/json;charset=utf-8");
            res.setHeader("cache-control", "no-cache");
            PrintWriter out = res.getWriter();
            out.write(str);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeXML(HttpServletResponse res, String str) {
        try {
            res.setContentType("application/xml;charset=utf-8");
            res.setHeader("cache-control", "no-cache");
            PrintWriter out = res.getWriter();
            out.write(str);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeGBKXML(HttpServletResponse res, String str) {
        try {
            res.setContentType("application/xml;charset=gbk");
            res.setHeader("cache-control", "no-cache");
            PrintWriter out = res.getWriter();
            out.write(str);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
