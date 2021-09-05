package xh.zero.aop;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateTypeHandler implements TypeHandler<Date> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public Date getResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public Date getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public Date getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
