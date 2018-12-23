package com.hanlu.servlet;


import com.hanlu.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HMY
 * @date 2018/11/22-22:44
 */
@WebServlet("/StudentDelServlet")
public class StudentDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao stuDao=new StudentDao();
        String id = request.getParameter("id");
        stuDao.studentDel(id);
        request.getRequestDispatcher("/StudentServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
