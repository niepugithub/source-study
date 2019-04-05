package com.source.test;

import com.source.domain.Employee;
import com.source.domain.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/4/5 13:40
 **/
public class SelectTest {

    SqlSession sqlSession;

    @Before
    public void initialSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession();

    }

    @Test
    public void testSelectOne() {
        Employee employee = sqlSession.selectOne(
                "selectEmployeeById", 1);
        System.out.println(employee);

        employee = sqlSession.selectOne(
                "selectEmployeeById", 1);

        System.out.println(employee);

    }

    @Test
    public void testMapperSelectEmployeeById() {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectEmployeeById(1);
        System.out.println(employee);
    }
}
