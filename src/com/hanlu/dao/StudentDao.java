package com.hanlu.dao;

import com.hanlu.pojo.Student;
import com.hanlu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author HMY
 * @date 2018/12/19-20:14
 */
public class StudentDao {

    /*SqlSessionFactory sqlSessionFactory;
    SqlSession session;
    public StudentDao() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
    }*/

    public List<Student> findAllStu(){
        SqlSession session = null;
        List<Student> stulist = null;
        try {
            session = MybatisUtils.getSession();
            stulist = session.selectList("com.hanlu.mapper.StudentMapper.findAllStu");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession();
        }
        return stulist;
    }



    public void studentAdd(Student student){
        try {
            SqlSession session = MybatisUtils.getSession();
            session.insert("com.hanlu.mapper.StudentMapper.studentAdd",student);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession();
        }
    }


    public void studentDel(String id){
        try {
            SqlSession session = MybatisUtils.getSession();
            session.update("com.hanlu.mapper.StudentMapper.studentDel",id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession();
        }
    }

    public List<Student> studentFindById(String id){
        SqlSession session = null;
        List<Student> list = null;
        try {
            session = MybatisUtils.getSession();
            list = session.selectList("com.hanlu.mapper.StudentMapper.studentFindById", id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession();
        }
        return list;
    }
    public List<Student> studentFindByName(String name){
        List<Student> listname = null;
        try {
            SqlSession session = MybatisUtils.getSession();
            listname = session.selectList("com.hanlu.mapper.StudentMapper.studentFindByName", name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession();
        }
        return listname;
    }

    public void studentEdit(Student student){
        try {
            SqlSession session = MybatisUtils.getSession();
            session.update("com.hanlu.mapper.StudentMapper.studentEdit",student);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSession();
        }
    }
}
