/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.dao;

import com.sg.soupastars.model.Comment;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface SoupaStarsCommentDao {
     
    public Comment addComment(Comment comment);
    
    public Comment getCommentById(int commentId);

    public void removeComment(int commentId);
    
    public void updateComment(Comment comment);
    
    List<Comment> getAllComments(); 
}
