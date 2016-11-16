/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.controller;

import com.sg.soupastars.dao.SoupaStarsDao;
import com.sg.soupastars.model.Post;
import java.io.FileNotFoundException;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeController {
    
    private SoupaStarsDao dao;
    
    @Inject
    public HomeController(SoupaStarsDao dao){
        this.dao = dao;
    }
    
    @RequestMapping(value={"home","/"}, method=RequestMethod.GET)
    public String displayHomePage(){
        return "home";
    }
    
    
    // - Retrieve a Post by Id (GET)
//        - /dvd/{dvdId}
//        - Response Body: DVD in JSON  
    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Post getPost(@PathVariable("id") int id) {
        return dao.getPostById(id);
    }

//- Create a Post (POST)
//       - RequestBody - JSON object of our Post
    // - ResponseBody - JSON object of our Post
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Post createPost(@Valid @RequestBody Post post) {
        dao.addPost(post);
        return post;
    }

//- Delete a Post (DELETE)
//        - post/{postId}
//        - Note: No RequestBody, no ResponseBody
    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("id") int id) {
        dao.removePost(id);
    }

//- Update a Post (PUT)
//        - post/{postId}
//        - RequestBody: JSON object of our Post, with the postId
    @RequestMapping(value = "/post/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@PathVariable("id") int id, @Valid @RequestBody Post post) {
        post.setPostId(id);
        dao.updatePost(post);
    }
    
//- Retrieve ALL Posts (GET)
//        - /post
//        -ResponseBody: Array of Contacts, in JSON form
    @RequestMapping(value="/post", method=RequestMethod.GET)
    @ResponseBody public List<Post> getAllDVDS(){
        return dao.getAllPosts();
    }
    
    
    @RequestMapping(value = "/displayPost", method = RequestMethod.GET)
    public String displayPost(Model model) throws FileNotFoundException {
        // Get all DVD
        List<Post> allPost = dao.getAllPosts();
        // attach the DVD to Model for Spring MVC to pass along to the view
        model.addAttribute("post", allPost);

        // return the logical view
        return "displayPost";
    }
  
}
