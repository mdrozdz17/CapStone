/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars;

import com.sg.soupastars.dao.SoupaStarsPostDao;
import com.sg.soupastars.model.Post;
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
public class SoupaStarsPostDaoDBImplTest {

}
    

  //private SoupaStarsPostDao dao;
    
  // public SoupaStarsPostDaoDBImplTest(){
        
    //}
    

//  private SoupaStarsPostDao dao;
//    
//   public SoupaStarsPostDaoDBImplTest(){
//        
//    }
//    

//    @BeforeClass
//    public static void setUpClass(){
//        
//    }
//    
//    @AfterClass
//    public static void tearDownClass(){
//        
//    }
//    
//    @Before
//    public void setUp(){
//    ApplicationContext ctx  = new ClassPathXmlApplicationContext("test-applicationContext.xml");
//        
//        dao = (SoupaStarsPostDao) ctx. getBean("SoupaStarsPostDaoDBImpl");
//        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
//        cleaner.execute("delete from posts");
//        
//    }
//    
//    @After
//    public void tearDown(){
//        
//    }
//    
//    @Test
//    public void addGetDeletePost(){
//     Post pt = new Post();
//        pt.setTitle("Cookies");
//        pt.setYear(2016);
//        pt.setMonth("December");
//        pt.setDay(02);
//        pt.setAuthor("Alyssa");
//        pt.setBody("hello");
//        pt.setCategory("Food");
//        dao.addPost(pt);
//        Post fromDb = dao.getPostById(pt.getPostId());
//        assertEquals(fromDb.getPostId(), pt.getPostId());
//        assertEquals(fromDb.getTitle(), pt.getTitle());
//        assertEquals(fromDb.getYear(), pt.getYear());
//        assertEquals(fromDb.getMonth(), pt.getMonth());
//        assertEquals(fromDb.getDay(), pt.getDay());
//        assertEquals(fromDb.getAuthor(), pt.getAuthor());
//        assertEquals(fromDb.getBody(), pt.getBody());
//        assertEquals(fromDb.getCategory(), pt.getCategory());
//        dao.removePost(pt.getPostId());
//        assertNull(dao.getPostById(pt.getPostId()));
//        
//        
//    }
//   }