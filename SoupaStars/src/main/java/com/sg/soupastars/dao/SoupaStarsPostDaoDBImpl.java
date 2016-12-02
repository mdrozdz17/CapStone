/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.dao;

import com.sg.soupastars.model.Comment;
import com.sg.soupastars.model.Post;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */

public class SoupaStarsPostDaoDBImpl implements SoupaStarsPostDao{
   
    private static final String SQL_INSERT_POST = "insert into Post (Title, PostYear, PostMonth, PostDay, Author, PostBody, Category) values (?,?,?,?,?,?,?)";
    private static final String SQL_DELETE_POST = "delete from Post where PostID = ?";
    private static final String SQL_INSERT_TAG = "insert into Tag (TagBody) values (?)";
    private static final String SQL_SELECT_POSTTAG = "insert into PostTag (PostId, TagId) values (?,?)";
    private static final String SQL_SELECT_POST = "select * from Post where PostID =  ?";
    private static final String SQL_UPDATE_POST = "update Post set Title = ?, PostYear = ?, PostMonth = ?, PostDay = ?, Author = ? , PostBody = ?, Category = ? where PostID = ?";
    private static final String SQL_SELECT_ALL_POSTS = "select * from Post";
    private static final String SQL_SELECT_POSTS_BY_TITLE = "select * from Post where Title = ?";
    private static final String SQL_SELECT_TAGS_BY_POSTID = "select TagBody from PostTag join Tag using (TagID) where PostID = ?";
    private static final String SQL_SELECT_COMMENTIDS_BY_POSTID = "select CommentID from PostComment join Comments using (CommentID) where PostID = ?";
    private static final String SQL_SELECT_COMMENTS_BY_POSTID = "select * from PostComment join Comments using (CommentID) where PostID = ?";
    private static final String SQL_SELECT_POST_BY_SEARCHTERM = "select * from Post where Title like ? or Author like ? or PostBody like ? or Category like ?";
    private static final String SQL_INSERT_POSTS_TAGS = "insert into posts_tags (PostID, TagID) values(?, ?)";

    // #2a - Declare JdbcTemplate reference - the instance will be handed to us by Spring
    private JdbcTemplate jdbcTemplate;
    // #2b - We are using Setter Injection to direct Spring to hand us an instance of
    // the JdbcTemplate (see the Spring Configuration section below for configuration
    // details).

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Post addPost(Post post) {
        jdbcTemplate.update(SQL_INSERT_POST,
        post.getTitle(),
        post.getYear(),
        post.getMonth(),
        post.getDay(),
        post.getAuthor(),
        post.getBody(),
        post.getCategory());
        post.setPostId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
         insertPostTags(post);
        return post;
        
    }
    
    
        private void insertPostTags(Post post) {
        final int postId = post.getPostId(); // Assume for talking that we have a Book (bookId = 1) 
        final int[] tagId = post.getTagId(); // with 2 authors (Author Ids: [1,2])
        // use the batchUpdate so we only make one call to the database
        jdbcTemplate.batchUpdate(SQL_INSERT_POSTS_TAGS, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                // For reference:  "insert into books_authors (book_id, author_id) values(?, ?)";
                ps.setInt(1, postId); // Set parameter 1 = value of book Id - 1 indicates 1st question mark
                ps.setInt(2, tagId[i]); // Set parameter 2 = the author[i] where i is the iteration; 2 indicates 2nd question mark
                // NOTE: This handles the iteration for us - we don't need to do it manually
            }

            @Override
            public int getBatchSize() {
                return tagId.length;
            }
        });
    }
 

    @Override
    public Post getPostById(int PostId) {
          try {
        Post post = jdbcTemplate.queryForObject(SQL_SELECT_POST, new PostMapper(), PostId);
        List<String> tagList = (List<String>) jdbcTemplate.query(SQL_SELECT_TAGS_BY_POSTID, new TagMapper(), PostId);
        post.setTagList(tagList);
        List<Comment> commentList = jdbcTemplate.query(SQL_SELECT_COMMENTS_BY_POSTID, new CommentMapper(), post.postId);
        post.setCommentList(commentList);
        return post;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    
        @Override
    public List<Post> read(Integer postId) {

        List<Post> b = jdbcTemplate.query(SQL_SELECT_POSTTAG, new PostMapper(), postId);

        return b;
    }

    @Override
    public List<Post> getAllPostsByTitle(String titleToSearch) {
          return jdbcTemplate.query(SQL_SELECT_POSTS_BY_TITLE, new PostMapper());

    }

    @Override
    public List<Post> getAllPosts() {
        List<Post> postList = jdbcTemplate.query(SQL_SELECT_ALL_POSTS, new PostMapper());
        for (Post post : postList) {
            List<String> tagList =  jdbcTemplate.query(SQL_SELECT_TAGS_BY_POSTID, new TagMapper(), post.postId);
            post.setTagList(tagList);
            List<Comment> commentList = jdbcTemplate.query(SQL_SELECT_COMMENTS_BY_POSTID, new CommentMapper(), post.postId);
            post.setCommentList(commentList);
        }
        return postList;
    }

    @Override
    public void updatePost(Post post) {
               jdbcTemplate.update(SQL_UPDATE_POST,
                post.getTitle(),
                post.getYear(),
                post.getMonth(),
                post.getDay(),
                post.getAuthor(),
                post.getBody(),
                post.getCategory(),
                post.getPostId());
                
    }

    @Override
    public void removePost(int postId) {
        jdbcTemplate.update(SQL_DELETE_POST, postId);
    }


    @Override
    public List<Post> searchPosts(String searchTerm) {
        searchTerm = "%" + searchTerm + "%";
        List<Post> list;
        try {
             return list = jdbcTemplate.query(SQL_SELECT_POST_BY_SEARCHTERM, new PostMapper(), searchTerm, searchTerm, searchTerm, searchTerm);
        } catch (EmptyResultDataAccessException ex){
            return null;
        }            
          
    }


    
     private static final class PostMapper implements RowMapper<Post> {

        @Override
        public Post mapRow(ResultSet rs, int i) throws SQLException {
           Post post = new Post();
           post.setPostId(rs.getInt("PostID"));
            post.setTitle(rs.getString("Title"));
            post.setYear(rs.getInt("PostYear"));
            post.setMonth(rs.getString("PostMonth"));
            post.setDay(rs.getInt("PostDay"));
            post.setAuthor(rs.getString("Author"));
            post.setBody(rs.getString("PostBody"));
            post.setCategory(rs.getString("Category"));
            
            return post;
            
        }
        
    }
     
     private static final class TagMapper implements RowMapper<String> {
         
         @Override
         public String mapRow(ResultSet rs, int i) throws SQLException {
             String tagText = rs.getString("TagBody");
             return tagText;
         }
     }
     
     private static final class CommentMapper implements RowMapper<Comment> {
         
         @Override
         public Comment mapRow(ResultSet rs, int i) throws SQLException {
             Comment comment = new Comment();
             comment.setCommentId(rs.getInt("CommentID"));
             comment.setDate(rs.getString("commentDate"));
             comment.setEmail(rs.getString("email"));
             comment.setName(rs.getString("userName"));
             comment.setText(rs.getString("commentText"));
             return comment;
         }
     }

}

