package com.hanlu.utils;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 工具类
 */
public class MybatisUtils {
	private static SqlSessionFactory sqlSessionFactory = null;
	static {
		try {
			Reader reader =
					Resources.getResourceAsReader("mybatis.xml");
			sqlSessionFactory =
					new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}

	public static void closeSession() {
		getSession().close();
	}
}
