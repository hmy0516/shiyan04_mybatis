package com.hanlu.servlet;


import com.hanlu.dao.StudentDao;
import com.hanlu.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author HMY
 * @date 2018/11/22-22:05
 */
@WebServlet(name="manage", value={"/StudentServlet"})
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao studentDao = new StudentDao();
        List<Student> stulist = studentDao.findAllStu();
        request.setAttribute("stulist",stulist);
        request.getRequestDispatcher("/WEB-INF/page/studentManagement.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
