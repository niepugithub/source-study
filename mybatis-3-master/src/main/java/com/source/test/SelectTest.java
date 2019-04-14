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
import java.util.List;

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
        List<Employee> employees = sqlSession.selectList(
                "selectEmployeeById", 1);
        System.out.println(employees);

        Employee employee = sqlSession.selectOne(
                "selectEmployeeById", 1);

        System.out.println(employee);

    }

    @Test
    public void testMapperSelectEmployeeById() {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectEmployeeById(1);
        System.out.println(employee);
    }

    @Test
    public void testSelectList() {
        List<Employee> employees = sqlSession.selectList(
                "selectEmployeeByGender", "男");
        System.out.println(employees);

        List<Employee> employee = sqlSession.selectList(
                "selectEmployeeByGender", "男");

        System.out.println(employee);
    }

    @Test
    public void testInsert() {
        Employee employee = new Employee("insert用户", "zhSan@qq.com", "男", 2, "LOGIN");
        int i = sqlSession.insert("addEmployee", employee);
        sqlSession.commit();
        System.out.println(i);
        System.out.println(employee);
        // 插入数据，这里记得手动提交事务，否则还可能会出现返回插入成功，但是数据库中没数据的情况
    }

    @Test
    public void testDynamic() {
        Employee employee = new Employee(null, null, "男", 2, "LOGIN");
        List<Employee> employees = sqlSession.selectList("dynamicQueryEmployee", employee);
        System.out.println(employees);
        System.out.println(employees.size());

    }
}
