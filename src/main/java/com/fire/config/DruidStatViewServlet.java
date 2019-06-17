//package com.fire.config;
//
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.annotation.WebServlet;
//import com.alibaba.druid.support.http.StatViewServlet;
//
//
//
////druid数据源状态监控.
//@SuppressWarnings("serial")
//@WebServlet(urlPatterns = "/druid/*",
//initParams = {
//    // IP白名单 (没有配置或者为空，则允许所有访问)
//    @WebInitParam(name = "allow", value = "127.0.0.1"),
//    // IP黑名单 (存在共同时，deny优先于allow)
//    @WebInitParam(name = "deny", value = ""),
//    // 用户名
//    @WebInitParam(name = "loginUsername", value = "admin"),
//    // 密码
//    @WebInitParam(name = "loginPassword", value = "admin"),
//    // 禁用HTML页面上的“Reset All”功能
//    @WebInitParam(name = "resetEnable", value = "false")
//})
//
//public class DruidStatViewServlet extends StatViewServlet{
//
//	
//	
//	
//	
//}
