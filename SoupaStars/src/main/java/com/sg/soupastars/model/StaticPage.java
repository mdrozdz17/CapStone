/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.soupastars.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author apprentice
 */
public class StaticPage {

    private int pageId;
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    private String author = authentication.getName();
    
    @NotEmpty(message ="Please enter a Title.")
    @Length(max=50, message = "Title must be no longer than 50 characters.")
    private String title;
      @NotEmpty(message ="Please enter a Body.")
    @Length(max=100000,message = " Title must be no longer than 100000 characters.")
    private String body;
    
    private String expirationDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }
}