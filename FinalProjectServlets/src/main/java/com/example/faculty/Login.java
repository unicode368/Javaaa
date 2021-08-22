package com.example.faculty;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res) throws IOException {
        PrintWriter pw=res.getWriter();
        res.setContentType("text/html");
        String user=req.getParameter("Username");
        String pass=req.getParameter("Password");
        pw.println("Login Success...!");
        if(user.equals("Sobaka") && pass.equals("Sobaka"))
            pw.println("Login Success...!");
        else
            pw.println("Login Failed...!");
        pw.close();
    }

    public void doGet(HttpServletRequest request,  HttpServletResponse response) {
        try{
            response.sendRedirect("login.jsp");
        } catch (Exception exp){
            System.out.println(exp);
        }
    }
}