/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.soupastars.model;

/**
 *
 * @author apprentice
 */
public class StaticPage {

    private int id;

    private String title;

    private String body;

    private String active;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}