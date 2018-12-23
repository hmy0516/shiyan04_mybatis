package com.hanlu.servlet;


import com.hanlu.dao.StudentDao;
import com.hanlu.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HMY
 * @date 2018/11/22-23:09
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String snum = request.getParameter("snum");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String intro = request.getParameter("intro");
        StudentDao stuDao=new StudentDao();
        Student stu=new Student();
        stu.setId(Integer.parseInt(id));
        stu.setSnum(snum);
        stu.setName(name);
        stu.setAge(Integer.parseInt(age));
        stu.setIntro(intro);
        stuDao.studentEdit(stu);
        response.sendRedirect("/StudentServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
