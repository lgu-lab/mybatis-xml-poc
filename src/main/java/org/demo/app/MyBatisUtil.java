package org.demo.app;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
    private static final String MYBATIS_CONFIG = "mybatis-config.xml";
    
    private static SqlSessionFactory sqlSessionFactory;
    static {
		try {
			try ( InputStream inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG) ) {
				sqlSessionFactory = 
						  new SqlSessionFactoryBuilder().build(inputStream);
			}
			System.out.println("SqlSessionFactory ready.");
		} catch (IOException e) {
			throw new RuntimeException("Cannot read config file " + MYBATIS_CONFIG);
		}    	
    }
    
	public static SqlSession openSession() {

		return sqlSessionFactory.openSession();
	}

}
