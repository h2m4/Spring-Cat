package com.springcat.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcCatRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcCatRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Iterable<Cat> findAll() {
        return jdbc.query("select id, name, gender, longHaired, roundFace, lively, picPath, thPicPath from cat",
                JdbcCatRepository::mapRowToCat);
    }

    public static Cat mapRowToCat(ResultSet rs, int rowNum) throws SQLException {
        return new Cat(rs.getLong("id"),
                rs.getString("name"),
                rs.getString("gender"),
                rs.getBoolean("longHaired"),
                rs.getBoolean("roundFace"),
                rs.getBoolean("lively"),
                rs.getString("picPath"),
                rs.getString("thPicPath")
                );
    }
}
