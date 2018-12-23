package com.hanlu.servlet;


import com.hanlu.dao.StudentDao;
import com.hanlu.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author HMY
 * @date 2018/11/22-23:05
 */
@WebServlet("/StudentEditServlet")
public class StudentEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao stuDao=new StudentDao();
        String id = request.getParameter("id");
        List<Student> students = stuDao.studentFindById(id);
        request.setAttribute("students",students);
        request.getRequestDispatcher("/WEB-INF/page/studentEdit.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
