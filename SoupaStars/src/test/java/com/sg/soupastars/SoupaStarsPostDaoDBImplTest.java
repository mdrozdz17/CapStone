/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars;

import com.sg.soupastars.dao.SoupaStarsPostDaoDBImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class SoupaStarsPostDaoDBImplTest {
    
    private SoupaStarsPostDaoDBImpl dao;
    
    public SoupaStarsPostDaoDBImplTest(){
        
    }
    
    @BeforeClass
    public static void setUpClass(){
        
    }
    
    @AfterClass
    public static void tearDownClass(){
        
    }
    
    @Before
    public void setUp(){
        ApplicationContext ctx  = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        
        dao = (SoupaStarsPostDaoDBImpl) ctx. getBean("SoupaStarsPostDaoDBImpl");
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from posts");
        
    }
    
    @After
    public void tearDown(){
        
    }
    
    
    }