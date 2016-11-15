/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.controller;

import com.sg.soupastars.dao.SoupaStarsDao;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    //Create Post
    
    //Get Post By ID
    
    //Update Post
    
    //Delete Post
}
