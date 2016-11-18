/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars;

import com.sg.soupastars.dao.SoupaStarsStaticPageDaoDBImpl;
import com.sg.soupastars.model.StaticPage;
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
public class SoupaStarsStaticPageDaoDBImplTests {
    
    private SoupaStarsStaticPageDaoDBImpl dao;
    
    public SoupaStarsStaticPageDaoDBImplTests(){
        
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
        
        dao = (SoupaStarsStaticPageDaoDBImpl) ctx.getBean("soupaStarsStaticPageDaoDBImpl");
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from Static Page");
    }
    
    @After
    public static void tearDown(){
        
    }
    
    @Test
    public void addGetDeleteStaticPage(){
        StaticPage sp = new StaticPage();
        sp.setTitle("candy");
        sp.setBody("yum");
        sp.setActive("active");
        sp.setExpirationDate("12/30/2016");
        dao.addStaticPage(sp);
        StaticPage fromDb = dao.getStaticPageById(sp.getStaticId());
        assertEquals(fromDb.getStaticId(), sp.getStaticId());
        assertEquals(fromDb.getBody(), sp.getBody());
        assertEquals(fromDb.getActive(), sp.getActive());
        assertEquals(fromDb.getExpirationDate(), sp.getExpirationDate());
        dao.removeStaticPage(sp.getStaticId());
        assertNull(dao.getStaticPageById(sp.getStaticId()));
    }
    
}
