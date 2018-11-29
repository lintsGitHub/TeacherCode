package com.nf147.sss.handler;

import org.apache.ibatis.type.IntegerTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FakeIntegerHandler extends IntegerTypeHandler {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Integer parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter * parameter);
    }
}
