/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.dao;

import com.sg.soupastars.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author apprentice
 */
public class SoupaStarsUserDBImpl implements SoupaStarsUserDao {
    
     private static final String SQL_INSERT_USER = "insert into user (UserName, Password) VALUES (?, ?)";
    private static final String SQL_DELETE_USER = "delete from user where user_id = ? ";
    private static final String SQL_SELECT_USER = "select * from user where user_id= ?";
    private static final String SQL_UPDATE_USER = "update static_page set UserName= ?, Password = ?, where user_id =?";
    private static final String SQL_SELECT_ALL_USER = "select * from user";
    
      private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User addUserName(User user) {
        jdbcTemplate.update(SQL_INSERT_USER,
               user.getUserName(),
               user.getPassword());
        
         Integer userId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        user.setUserId(userId);
        return user;
    }

    @Override
    public User getUserNameById(int userId) {
               try {
            return jdbcTemplate.queryForObject(SQL_SELECT_USER, new UserMapper(), userId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    
    }
    

    @Override
    public void removeUserName(int userId) {
        jdbcTemplate.update(SQL_DELETE_USER, new UserMapper());
    }

    @Override
    public void updateUserInfo(User user) {
        jdbcTemplate.update(SQL_UPDATE_USER,
                user.getUserName(),
                user.getPassword());
    }


    @Override
    public List<User> getAllUserNames() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USER, new UserMapper());
    }
    
           private static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("userId"));
            user.setUserName(rs.getString("UserName"));
            user.setPassword(rs.getString("Password"));
          
            return user;

        }

    }
    
}
