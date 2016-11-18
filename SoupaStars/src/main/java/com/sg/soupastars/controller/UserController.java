/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.controller;

import com.sg.soupastars.dao.SoupaStarsUserDao;
import com.sg.soupastars.model.User;
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
public class UserController {

    private SoupaStarsUserDao dao;

    @Inject
    public UserController(SoupaStarsUserDao dao) {
        this.dao = dao;
    }

    // - Retrieve a User by Id (GET)
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserName(@PathVariable("id") int id) {
        return dao.getUserNameById(id);
    }

    //- Create a User (POST)
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User createUserName(@Valid @RequestBody User user) {
        dao.addUserName(user);
        return user;
    }

    //- Delete a User (DELETE)
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserName(@PathVariable("id") int id) {
        dao.removeUserName(id);
    }

    //- Update a User (PUT)
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUserName(@PathVariable("id") int id, @Valid @RequestBody User user) {
        user.setUserId(id);
        dao.updateUserInfo(user);
    }

    //- Retrieve ALL Users (GET)
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUserNames() {
        return dao.getAllUserNames();
    }

    @RequestMapping(value = "/displayUsers", method = RequestMethod.GET)
    public String displayUserNames(Model model) throws FileNotFoundException {
        List<User> allUsers = dao.getAllUserNames();
        model.addAttribute("user", allUsers);

        // return the logical view
        return "displayUsers";
    }

}
