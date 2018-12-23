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
 * @date 2018/11/22-22:31
 */
@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type=request.getParameter("type");
        if(type.equals("addPage")){
            request.getRequestDispatcher("/WEB-INF/page/studentAdd.jsp").forward(request,response);
        }else if (type.equals("add")){
            String snum = request.getParameter("snum");
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            String intro = request.getParameter("intro");
            StudentDao stuDao=new StudentDao();
            Student stu=new Student();
            stu.setSnum(snum);
            stu.setName(name);
            stu.setAge(Integer.parseInt(age));
            stu.setIntro(intro);
            stuDao.studentAdd(stu);
            request.getRequestDispatcher("/StudentServlet").forward(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
