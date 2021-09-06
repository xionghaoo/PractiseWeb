package xh.zero.aop;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTypeHandler extends BaseTypeHandler<Date> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        preparedStatement.setLong(i, date.getTime());
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        long time = resultSet.getLong(s);
        return new Date(time);
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long time = resultSet.getLong(i);
        return new Date(time);
    }

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long time = callableStatement.getLong(i);
        return new Date(time);
    }
}
