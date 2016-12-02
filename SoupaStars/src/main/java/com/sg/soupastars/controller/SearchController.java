/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.controller;

import com.sg.soupastars.dao.SoupaStarsPostDao;
import com.sg.soupastars.model.Post;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    
    
//    @RequestMapping(value = "search/posts", method = RequestMethod.POST)
//    @ResponseBody
//    public List<Post> searchPost(@RequestBody Map<String, String> searchMap){
//       
//    }
}
