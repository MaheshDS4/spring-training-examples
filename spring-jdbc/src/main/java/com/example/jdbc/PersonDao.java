package com.example.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {
    private final JdbcTemplate jdbc;

    public PersonDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // simple insert
    public void insert(Person p) {
        jdbc.update("INSERT INTO person(id,name,email) VALUES (?,?,?)", p.getId(), p.getName(), p.getEmail());
    }

    // PreparedStatement style (JdbcTemplate handles prepared statements)
    public void insertWithPrepared(int id, String name, String email) {
        jdbc.update(connection -> {
            var ps = connection.prepareStatement("INSERT INTO person(id,name,email) VALUES (?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            return ps;
        });
    }

    public List<Person> listAll() {
        return jdbc.query("SELECT id,name,email FROM person", new PersonRowMapper());
    }

    // ResultSetExtractor example
    public Person findByIdUsingExtractor(int id) {
        return jdbc.query("SELECT id,name,email FROM person WHERE id = " + id, new ResultSetExtractor<Person>() {
            @Override
            public Person extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    return new Person(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
                }
                return null;
            }
        });
    }

    // RowMapper class
    static class PersonRowMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Person(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
        }
    }

    public void updateEmail(int id, String newEmail) {
        jdbc.update("UPDATE person SET email = ? WHERE id = ?", newEmail, id);
    }

    public void delete(int id) {
        jdbc.update("DELETE FROM person WHERE id = ?", id);
    }
}
