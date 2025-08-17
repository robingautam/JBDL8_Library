package org.gfg.JBDL8_DigitalLibrary.repository;

import org.gfg.JBDL8_DigitalLibrary.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AuthorRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Author checkAuthor(String email, String mobileNo){
        String query = "SELECT * FROM Author WHERE email=? AND mobileNo=?";
        Author author = jdbcTemplate.queryForObject(query, new RowMapper<Author>() {
            @Override
            public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
                if (rs==null || rs.wasNull()){
                    return null;
                }
               Author mapAuthor = new Author();
               mapAuthor.setName(rs.getString(2));
               mapAuthor.setEmail(rs.getString(3));
               return mapAuthor;
            }
        },email,mobileNo);

        System.out.println("Author: "+author);
        return author;
    }


    public int createAuthor(Author author){
        String query = "INSERT INTO Author (name, email, mobileNo) VALUES (?,?,?)";
       int rowsUpdated = jdbcTemplate.update(query,author.getName(),author.getEmail(),author.getMobileNo());
       if (rowsUpdated>0){
           System.out.println("Author information has been inserted");
       }
       return rowsUpdated;
    }
}
