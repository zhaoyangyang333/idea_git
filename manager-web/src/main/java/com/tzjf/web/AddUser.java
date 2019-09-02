package com.tzjf.web;

import com.tzjf.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    private UserService userService = UserService.getcon();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String name = new String(req.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
        userService.addUser(name);
        PrintWriter writer = resp.getWriter();
        writer.write("获取到新的数据了:name--"+name);
        ServletContext servletContext = req.getSession().getServletContext();
        Integer personNum = (Integer) servletContext.getAttribute("online-person");
        System.out.println("当前的在线人数为："+personNum);
        writer.flush();
        writer.close();
    }
}
