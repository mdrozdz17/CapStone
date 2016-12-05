/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.controller;

import com.sg.soupastars.dao.SoupaStarsPostDao;
import com.sg.soupastars.model.Post;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
public class SearchController {
    private SoupaStarsPostDao dao;
    
    @Inject
    public SearchController(SoupaStarsPostDao dao){
        this.dao = dao;
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String displaySearchPage(){
        
        return "search";
    }
    
    
    
@RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody 
        public String searchPost (HttpServletRequest req, Model model){
            String searchString = req.getParameter("searchTerm");
        List<Post> results = dao.searchPosts(searchString);
        model.addAttribute(results);
        return "search";
    }
}
