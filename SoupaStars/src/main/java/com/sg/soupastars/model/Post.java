/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.model;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import javax.persistence.Column;
//import org.hibernate.search.annotations.Field;
//import org.hibernate.search.annotations.Index;
//import org.hibernate.search.annotations.Analyze;
//import org.hibernate.search.annotations.Store;

/**
 *
 * @author apprentice
 */
public class Post {
   Calendar cal = Calendar.getInstance();
   // Allows us to get current User logged in
   Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    public String title;
    public int year = LocalDate.now().getYear();
    public String month = new SimpleDateFormat("MMMM").format(cal.getTime());
    public int day = LocalDate.now().getDayOfMonth();
    public String author = authentication.getName();
    public int postId;
    public List<Comment> commentList;
    public String body;
    public String Category;
    public List<String> tagList;
    private int tagId;


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
    public int getYear ()  {
        return LocalDate.now().getYear();
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = LocalDate.now().getYear();
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
    public List<Comment> getCommentList() {
        return commentList;
    }

    /**
     * @param commentList the commentList to set
     */
    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
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

    /**
     * @return the Category
     */
    public String getCategory() {
        return Category;
    }

    /**
     * @param Category the Category to set
     */
    public void setCategory(String Category) {
        this.Category = Category;
    }

    /**
     * @return the tagList
     */
    public List<String> getTagList() {
        return tagList;
    }

    /**
     * @param tagList the tagList to set
     */
    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
    
}
