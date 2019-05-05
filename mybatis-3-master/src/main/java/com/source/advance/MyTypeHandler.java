package com.source.advance;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义将List类型参数转换为Employee
 *
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/4/17 22:51
 **/
// 这里千万主要要写成实际传递参数的实现类型，而不是父类List，不然无法匹配到
@MappedTypes(ArrayList.class)
@MappedJdbcTypes({JdbcType.VARCHAR})
public class MyTypeHandler extends BaseTypeHandler<List> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.toString());
    }

    @Override
    public List getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String s = rs.getString(columnName);
        List list = new ArrayList();
        for (String ss : s.split(",")) {
            list.add(ss);
        }
        return list;
    }

    @Override
    public List getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public List getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
