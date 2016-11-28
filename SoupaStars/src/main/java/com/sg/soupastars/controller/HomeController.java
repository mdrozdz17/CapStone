/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.controller;

import com.sg.soupastars.dao.SoupaStarsCommentDao;
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
import com.sg.soupastars.dao.SoupaStarsPostDao;
import com.sg.soupastars.model.Comment;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeController {
    
    private SoupaStarsPostDao pdao;
     
   private SoupaStarsCommentDao cdao;
    
    
    @Inject
    public HomeController(SoupaStarsPostDao pdao, SoupaStarsCommentDao cDao){
        this.pdao = pdao;
    }
    
    @RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
    public String displayHomePage(){
        return "home";
    }
    
      // Main  Page
    @RequestMapping(value={"/mainPage"},method=RequestMethod.GET)
    public String displayMainPage(){
        return "mainPage";
    }
    
    
    // - Retrieve a Post by Id (GET)
//        - /post/{postId}
//        - Response Body: POST in JSON  
    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Post getPost(@PathVariable("id") int id) {
        return pdao.getPostById(id);
    }

//- Create a Post (POST)
//       - RequestBody - JSON object of our Post
    // - ResponseBody - JSON object of our Post
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Post createPost(@Valid @RequestBody Post post) {
        pdao.addPost(post);
        return post;
    }

//- Delete a Post (DELETE)
//        - post/{postId}
//        - Note: No RequestBody, no ResponseBody
    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("id") int id) {
        pdao.removePost(id);
    }

//- Update a Post (PUT)
//        - post/{postId}
//        - RequestBody: JSON object of our Post, with the postId
    @RequestMapping(value = "/post/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@PathVariable("id") int id, @Valid @RequestBody Post post) {
        post.setPostId(id);
        pdao.updatePost(post);
    }
    
//- Retrieve ALL Posts (GET)
//        - /post
    @RequestMapping(value="/post", method=RequestMethod.GET)
    @ResponseBody public List<Post> getAllPosts(){
        int x=1;
        return pdao.getAllPosts();
    }
    
    
    @RequestMapping(value = "/displayPost", method = RequestMethod.GET)
    public String displayPost(Model model) throws FileNotFoundException {
        List<Post> allPost = pdao.getAllPosts();
        model.addAttribute("post", allPost);

        // return the logical view
        return "displayPost";
    }
    
    // Comments 
   
    
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Comment getComment(@PathVariable("id") int id) {
        return cdao.getCommentById(id);
    }

//- Create a Comment (POST)
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Comment createComment(@Valid @RequestBody Comment comment) {
        cdao.addComment(comment);
        return comment;
    }

//- Delete a Comment (DELETE)
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable("id") int id) {
        cdao.removeComment(id);
    }

//- Update a Comment (PUT)
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@PathVariable("id") int id, @Valid @RequestBody Comment comment) {
        comment.setCommentId(id);
        cdao.updateComment(comment);
    }
    
//- Retrieve ALL Comments (GET)
    @RequestMapping(value="/comment", method=RequestMethod.GET)
    @ResponseBody public List<Comment> getAllComments(){
        return cdao.getAllComments();
    }
    
   
    
    // I am unsure about this. The RequestMapping cannot be /displayPost since it
    // would be ambigious. However we do not have a displayComment page.
    
    @RequestMapping(value = "/displayComment", method = RequestMethod.GET)
    public String displayComment(Model model) throws FileNotFoundException {
        List<Comment> allComment = cdao.getAllComments();
        model.addAttribute("comment", allComment);

        // return the logical view
        return "displayComment";
    }
  
}
