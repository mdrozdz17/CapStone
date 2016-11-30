/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.dao;

import com.sg.soupastars.model.Comment;
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
public class SoupaStarsCommentDBImpl implements SoupaStarsCommentDao {
    
    private static final String SQL_INSERT_COMMENT = "insert into comment (name, email, text, date) VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE_COMMENT = "delete from comment where comment_id = ? ";
    private static final String SQL_SELECT_COMMENT = "select * from comment where comment_id= ?";
    private static final String SQL_UPDATE_COMMENT = "update static_page set name= ?, email= ?, text= ?, date = ?, where comment_id =?";
    private static final String SQL_SELECT_ALL_COMMENT = "select * from comment";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Comment addComment(Comment comment) {
         jdbcTemplate.update(SQL_INSERT_COMMENT,
                comment.getName(),
                comment.getEmail(),
                comment.getText(),
                comment.getDate());

        Integer commentId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        comment.setCommentId(commentId);
        return comment;

    }
    

    @Override
    public Comment getCommentById(int commentId) {
            try {
            return jdbcTemplate.queryForObject(SQL_SELECT_COMMENT, new CommentMapper(), commentId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    
    }

    @Override
    public void removeComment(int commentId) {
       jdbcTemplate.update(SQL_DELETE_COMMENT, new CommentMapper());
    }

    @Override
    public void updateComment(Comment comment) {
        jdbcTemplate.update(SQL_UPDATE_COMMENT,
                comment.getName(),
                comment.getEmail(),
                comment.getText(),
                comment.getDate());
    }

    @Override
    public List<Comment> getAllComments() {
        return jdbcTemplate.query(SQL_SELECT_ALL_COMMENT, new CommentMapper());
    }
    
       private static final class CommentMapper implements RowMapper<Comment> {

        @Override
        public Comment mapRow(ResultSet rs, int i) throws SQLException {
            Comment comment = new Comment();
            comment.setCommentId(rs.getInt("comment_id"));
            comment.setName(rs.getString("name"));
            comment.setEmail(rs.getString("email"));
            comment.setText(rs.getString("text"));
            comment.setDate(rs.getString("date"));
            
            return comment;

        }

    }
    
}
