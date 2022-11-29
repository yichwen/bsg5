package com.bsg5.chapter08;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class MusicRepository {

    JdbcTemplate jdbcTemplate;

    MusicRepository(JdbcTemplate template) {
        jdbcTemplate=template;
    }

    @Transactional
    public List<String> getMatchingArtistNames(String prefix) {
        String selectSQL = "SELECT name FROM artists WHERE " + "lower(name) like lower(?) " + "order by name asc";
        /*
         * Note use of Object[] for query arguments, and
         * the use of a lambda to map from a row to a String
         */
        return jdbcTemplate.query(
                selectSQL,
                new Object[]{prefix + "%"},
                (rs, rowNum) -> rs.getString("name"));
    }

    @Transactional
    Artist findArtistById(Integer id) {
        return jdbcTemplate.query(
                "SELECT id, name FROM artists WHERE id=?",
                new Object[]{id},
                (rs, rowNum) ->
                        new Artist(
                                rs.getInt("id"),
                                rs.getString("name"
                                )
                        )
        )
                .stream()
                .findFirst()
                .orElse(null);
    }

}
