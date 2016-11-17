/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.dao;

import com.sg.soupastars.model.Post;
import com.sg.soupastars.model.StaticPage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class SoupaStarsStaticPageDaoDBImpl implements SoupaStarsStaticPageDao {

    private static final String SQL_INSERT_STATICPAGE = "insert into static_page (body, title, active) VALUES (?, ?, ?)";
    private static final String SQL_DELETE_STATICPAGE = "delete from static_page where static_id = ? ";
    private static final String SQL_SELECT_STATICPAGE = "select * from static_page where static_id= ?";
    private static final String SQL_UPDATE_STATICPAGE = "update static_page set body= ?, title= ?, active= ? where static_id =?";
    private static final String SQL_SELECT_ALL_STATICPAGE = "select * from static_page";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)

    public StaticPage addStaticPage(StaticPage staticPage) {
        jdbcTemplate.update(SQL_INSERT_STATICPAGE,
                staticPage.getBody(),
                staticPage.getTitle(),
                staticPage.getActive());

        Integer staticPageId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        staticPage.setStaticId(staticPageId);
        return staticPage;

    }

    @Override
    public StaticPage getStaticPageById(int staticPageId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_STATICPAGE, new StaticPageMapper(), staticPageId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void updateStaticPage(StaticPage staticPage) {
        jdbcTemplate.update(SQL_UPDATE_STATICPAGE,
                staticPage.getBody(),
                staticPage.getTitle(),
                staticPage.getActive(),
                staticPage.getStaticId());

    }

    @Override
    public void removeStaticPage(int staticPageId) {
        jdbcTemplate.update(SQL_DELETE_STATICPAGE, staticPageId);
    }

    @Override
    public List<StaticPage> getAllStaticPages() {
        return jdbcTemplate.query(SQL_SELECT_ALL_STATICPAGE, new StaticPageMapper());
    }

    @Override
    public List<StaticPage> listActivePages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Method to list active pages
    
//    @Override
//    public List<StaticPage> listActivePages() {
//        List<StaticPage> staticPage = jdbcTemplate.query(SQL_SELECT_ALL_STATICPAGE, new StaticPageMapper());
//        List<StaticPage> pages = new ArrayList();
//        String isActive = "Active";
//
//        for (StaticPage s : staticPage) {
//            if (s.getActive().equals(isActive)) {
//
//                pages.add(s);
//
//            }
//
//        }
//
//        pages.size();
//
//        return pages;
//    }

    private static final class StaticPageMapper implements RowMapper<StaticPage> {

        @Override
        public StaticPage mapRow(ResultSet rs, int i) throws SQLException {
            StaticPage staticPage = new StaticPage();
            staticPage.setStaticId(rs.getInt("static_id"));
            staticPage.setBody(rs.getString("body"));
            staticPage.setTitle(rs.getString("title"));
            staticPage.setActive(rs.getString("active"));

            return staticPage;

        }

    }
}
