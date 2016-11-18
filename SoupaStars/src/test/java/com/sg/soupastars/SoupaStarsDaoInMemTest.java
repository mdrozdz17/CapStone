/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars;

import com.sg.soupastars.dao.SoupaStarsCommentInMemImpl;
import com.sg.soupastars.model.Comment;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class SoupaStarsDaoInMemTest {
 
    private SoupaStarsCommentInMemImpl dao;
    
    public SoupaStarsDaoInMemTest(){
        
        
    }
    
    @BeforeClass
    public static void setUpClass(){
        
    }
    
    @AfterClass
    public static void tearDownClass(){
        
    }
    
    @Before
    public void setup(){
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-application.xml");
        dao = (SoupaStarsCommentInMemImpl) ctx.getBean("SoupaStarsCommentInMemImpl");
    
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    }
    
    @After
    public void tearDown(){
        
    }
    
    @Test
    public void addGetDeleteComment(){
        Comment nc = new Comment();
        nc.setName("Alyssa");
        nc.setEmail("arice713@yahoo.com");
        nc.setText("hi");
        nc.setDate(11122016);
        dao.addComment(nc);
        Comment fromDb = dao.getCommentById(nc.getCommentId());
        assertEquals(fromDb.getCommentId(), nc.getCommentId());
        assertEquals(fromDb.getName(), nc.getName());
        assertEquals(fromDb.getEmail(), nc.getEmail());
        assertEquals(fromDb.getText(), nc.getText());
        assertEquals(fromDb.getDate(), nc.getDate());
        dao.removeComment(nc.getCommentId());
        assertNull(dao.getCommentById(nc.getCommentId()));
    }
    
    }

