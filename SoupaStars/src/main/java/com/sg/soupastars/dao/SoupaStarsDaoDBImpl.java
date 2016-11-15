/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.dao;

import com.sg.soupastars.model.Post;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class SoupaStarsDaoDBImpl implements SoupaStarsDao{
   
    private static final String SQL_INSERT_POST = "insert into posts (title, year, month, day, author) values (?,?,?,?,?)";
    private static final String SQL_DELETE_POST = "delete form posts where post_id = ?";
    private static final String SQL_SELECT_POST = "select * from posts where post_id =  ?";
    private static final String SQL_UPDATE_POST = "update contacts set title = ?, year = ?, month = ?, day = ?, author = ? where post_id = ?";
    private static final String SQL_SELECT_ALL_POSTS = "select * from posts";
    private static final String SQL_SELECT_POSTS_
    @Override
    public Post addPost(Post post) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Post getPostById(int PostId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> getAllPostsByTitle(String titleToSearch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> getAllPosts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatePost(Post post) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePost(int postId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> searchPosts(Map<SearchTerm, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
