package com.hanlu.test;

import com.hanlu.dao.StudentDao;
import com.hanlu.pojo.Student;
import com.hanlu.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author HMY
 * @date 2018/12/18-23:51
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        MybatisTest mybatisTest = new MybatisTest();
        mybatisTest.findAllStu();
        ArrayList<Student> studentList= new ArrayList<Student>();
        StudentDao studentDao= new StudentDao();
        Scanner inn= new Scanner(System.in);
        while(true){
            System.out.println("----------------- 欢迎使用学生管理系统------------------");
            System.out.println("1.添加学生信息");
            System.out.println("2.修改学生信息");
            System.out.println("3.查询学生信息");
            System.out.println("4.删除学生信息");
            System.out.println("0.退出系统");
            System.out.println("请选择....");
            int nn= inn.nextInt();
            switch (nn) {
                case 1:
                    mybatisTest.studentAdd();
                    break;
                case 2:
                    mybatisTest.studentEdit();
                    break;
                case 3:
                    mybatisTest.search();
                    break;
                case 4:
                    mybatisTest.del();
                    break;
                default:
                    break;
            }
        }
    }


    public void findAllStu() throws IOException {
        SqlSession session = MybatisUtils.getSession();
        List<Student> list = session.selectList("com.hanlu.mapper.StudentMapper.findAllStu");
        for (Student stu:list){
            System.out.println(stu.toString());
        }
        session.close();
    }


    public void studentAdd() throws IOException {
        String flag1="yes";
        do{
            Student student=new Student();
            Scanner in =new Scanner(System.in);
            System.out.println("请输入学生学号：");
            student.setSnum(in.next());
            System.out.println("请输入学生姓名：");
            student.setName(in.next());
            System.out.println("请输入学生年龄：");
            student.setAge(in.nextInt());
            System.out.println("请输入学生简介：");
            student.setIntro(in.next());
            StudentDao studentDao = new StudentDao();
            studentDao.studentAdd(student);
            System.out.println("是否继续添加学生信息(yes/no)?");
            flag1=in.next();
        } while(flag1.equals("yes"));

    }
    public void studentEdit(){
        Scanner inn= new Scanner(System.in);
        Student student=new Student();
        Scanner in =new Scanner(System.in);
        System.out.println("请输入要编辑学生学号：");
        student.setId(in.nextInt());
        System.out.println("1.编辑学生姓名");
        System.out.println("2.编辑学生年龄");
        System.out.println("3.编辑学生简介");
        System.out.println("4.编辑学生编号");
        System.out.println("请选择....");
        int nn= inn.nextInt();
        switch (nn) {
            case 1:
                System.out.println("请输入要编辑学生姓名：");
                student.setName(in.next());
                break;
            case 2:
                System.out.println("请输入要编辑学生年龄：");
                student.setAge(in.nextInt());
                break;
            case 3:
                System.out.println("请输入要编辑学生简介：");
                student.setIntro(in.next());
                break;
            case 4:
                System.out.println("请输入要编辑学生编号：");
                student.setSnum(in.next());
                break;
            default:
                break;
        }
        StudentDao studentDao = new StudentDao();
        studentDao.studentEdit(student);
    }

    public void search(){
        Scanner inn= new Scanner(System.in);
        Student student=new Student();
        Scanner in =new Scanner(System.in);
        System.out.println("请输入要查询学生的姓名：");
        String name = in.next();
        StudentDao studentDao = new StudentDao();
        List<Student> list = studentDao.studentFindByName(name);
        for(Student student1:list){
            System.out.println(student1.toString());
        }
    }
    public void del(){
        Scanner inn= new Scanner(System.in);
        Student student=new Student();
        Scanner in =new Scanner(System.in);
        System.out.println("请输入要删除学生的ID：");
        int id = in.nextInt();
        StudentDao studentDao = new StudentDao();
        studentDao.studentDel(id+"");
    }
}
