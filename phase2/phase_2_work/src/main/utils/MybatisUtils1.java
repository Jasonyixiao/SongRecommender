package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils1 {

    //sqlSessionFatory sqlSession
    private static SqlSessionFactory sqlSessionFactory;
    static{
        try {
            // Every mybatis application centers around an instance of sqlSessionFactory, which can be built using
            // sqlSessionFactoryBuilder.
            // SqlSessionFactoryBuilder can build a SqlSessionFactory instance from an XML configuration file
            // We use the below three line to get sqlSessionFactory.
            // MyBatis includes a utility class, calle d Resources, that contains a number of methods that make it
            // simpler to load resources from the classpath and other locations.
            String resource = "Mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //MyBatis includes a utility class, called Resources, that contains a number of methods
    //that make it simpler to load resources from the classpath and other locations.
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(); // this returns a sqlSession
    }
    //TODO change the database to TOPNINEDATA

    // Note: this class configures the resource file and creates an intance of sqlSession that can be used to manipulate
    // the database

}
