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
public interface SoupaStarsDao {
    
    public Post addPost(Post post);
    
    public Post getPostById(int PostId);
    
    public List<Post> getAllPostsByTitle(String titleToSearch);
    
    public List<Post> getAllPosts();
    
    public void updatePost(Post post);
    
    public void removePost(int postId);
    
    
   public List<Post> searchPosts(Map<SearchTerm,String> criteria);
   
   //public List<PostCount> getPostCounts();
    
}
