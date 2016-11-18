/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.controller;

import com.sg.soupastars.dao.SoupaStarsStaticPageDao;
import com.sg.soupastars.model.Comment;
import com.sg.soupastars.model.Post;
import com.sg.soupastars.model.StaticPage;
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
public class StaticPageController {
    
    private SoupaStarsStaticPageDao dao;
    
    @Inject
    public StaticPageController(SoupaStarsStaticPageDao dao) {
        this.dao=dao;
    }
    
       // - Retrieve a StaticPage by Id (GET)
    @RequestMapping(value = "/staticPage/{id}", method = RequestMethod.GET)
    @ResponseBody
    public StaticPage getStaticPage (@PathVariable("id") int id) {
        return dao.getStaticPageById(id);
    }

//- Create a StaticPage (POST)
    @RequestMapping(value = "/staticPage", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public StaticPage createStaticPage(@Valid @RequestBody StaticPage staticPage) {
        dao.addStaticPage(staticPage);
        return staticPage;
    }

//- Delete a StaticPage (DELETE)
    @RequestMapping(value = "/staticPage/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStaticPage(@PathVariable("id") int id) {
        dao.removeStaticPage(id);
    }

//- Update a StaticPage (PUT)
    @RequestMapping(value = "/staticPage/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStaticPage(@PathVariable("id") int id, @Valid @RequestBody StaticPage staticPage) {
        staticPage.setStaticId(id);
        dao.updateStaticPage(staticPage);
    }
    
//- Retrieve ALL StaticPages (GET)
    @RequestMapping(value="/staticPage", method=RequestMethod.GET)
    @ResponseBody public List<StaticPage> getAllStaticPages(){
        return dao.getAllStaticPages();
    }
    
    
    @RequestMapping(value = "/displayStaticPage", method = RequestMethod.GET)
    public String displayStaticPage(Model model) throws FileNotFoundException {
        List<StaticPage> allStaticPages = dao.getAllStaticPages();
        model.addAttribute("staticPage", allStaticPages);

        // return the logical view
        return "displayStaticPage";
    }
    
}