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
 * @date 2018/12/19-22:08
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        StudentDao studentDao = new StudentDao();
        List<Student> stulist = studentDao.studentFindByName(name);
        System.out.println("sdfsdf");
        System.out.println(stulist.size());
        request.removeAttribute("stulist");
        request.setAttribute("stulist",stulist);
        System.out.println("saaww");
        request.getRequestDispatcher("/WEB-INF/page/studentManagement.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
