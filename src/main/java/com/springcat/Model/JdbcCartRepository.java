package com.springcat.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcCartRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public JdbcCartRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void addCats(List<String> moreCats) {
        for (String catId: moreCats) {
            jdbc.update("insert into cart(catId) values(?)", catId);
        }
    }

    public Iterable<Cat> findAll() {
        return jdbc.query("select catId from cart", this::mapRowToCat);
    }

    public Cat mapRowToCat(ResultSet rs, int rowNumber) throws SQLException {
        int catId = rs.getInt("catId");
        return findCatById(catId);
    }

    public Cat findCatById(int catId) {
        return jdbc.queryForObject("select id, name, gender, longHaired, roundFace, lively, picPath, thPicPath from cat where id=?",
                JdbcCatRepository::mapRowToCat,catId);
    }
}
