/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars;

import com.sg.soupastars.dao.SoupaStarsUserDBImpl;
import com.sg.soupastars.model.User;
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
public class SoupaStarsUserDBImplTests {
    
    private SoupaStarsUserDBImpl dao;
    
    public SoupaStarsUserDBImplTests(){
        
    }
    
    @BeforeClass
    public static void setUpClass(){
        
    }
    
    @AfterClass
    public static void tearDownClass(){
        
    }
    
    @Before
    public void setUp(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = (SoupaStarsUserDBImpl) ctx.getBean("SoupStarsUserDBImpl");
        
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbctemplate");
        cleaner.execute("delete from User");
    }
    
    @After
    public void tearDown(){
        
    }
    
    @Test
    public void addGetDeleteUser(){
        User us = new User();
        us.setUserName("Meow");
        us.setPassword("cat");
        dao.addUserName(us);
        User fromDb = dao.getUserNameById(us.getUserId());
        assertEquals(fromDb.getUserId(), us.getUserId());
        assertEquals(fromDb.getUserName(), us.getUserName());
        assertEquals(fromDb.getPassword(), us.getPassword());
        assertNull(dao.getUserNameById(us.userId));
    }
}
