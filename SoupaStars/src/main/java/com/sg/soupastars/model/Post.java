/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Post {
    public String title;
    public int year;
    public String month;
    public int day;
    public String author;
    public int postId;
    public List<Integer> commentIdList;
    public String body;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
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

    /**
     * @return the postId
     */
    public int getPostId() {
        return postId;
    }

    /**
     * @param postId the postId to set
     */
    public void setPostId(int postId) {
        this.postId = postId;
    }

    /**
     * @return the commentIdList
     */
    public List<Integer> getCommentIdList() {
        return commentIdList;
    }

    /**
     * @param commentIdList the commentIdList to set
     */
    public void setCommentIdList(List<Integer> commentIdList) {
        this.commentIdList = commentIdList;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }
    
    
    @Override
    public int hashCode(){
        int hash = 5;
        hash = 37 * hash + this.postId;
        hash = 37 * hash + Objects.hashCode(this.author);
        hash = 37 * hash + Objects.hashCode(this.body);
        hash = 37 * hash + Objects.hashCode(this.year);
        hash = 37 * hash + Objects.hashCode(this.day);
        hash = 37 * hash + Objects.hashCode(this.month);
        hash = 37 * hash + Objects.hashCode();



    }
}
