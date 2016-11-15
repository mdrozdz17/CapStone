/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.model;

import java.util.List;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class User {
    public int userId;
    @NotEmpty(message="Please enter a valid user name.")
    @Length(max=15, message="User name must be no longer than 15 characters")
    public String userName;
    @NotEmpty(message="Please enter a valid user name.")
    @Length(min = 8, max=16, message="password must be between 8 and 16 characters")
    public String password;
    public List<Integer> postList;

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the postList
     */
    public List<Integer> getPostList() {
        return postList;
    }

    /**
     * @param postList the postList to set
     */
    public void setPostList(List<Integer> postList) {
        this.postList = postList;
    }
}
