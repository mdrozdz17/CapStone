/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.dao;

import com.sg.soupastars.model.StaticPage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class SoupaStarsStaticPageDaoDBImpl implements SoupaStarsStaticPageDao {

    private static final String SQL_INSERT_STATICPAGE = "INSERT INTO StaticPage (Author, Body, ExpirationDate) VALUES (?, ?, ?)";
    private static final String SQL_DELETE_STATICPAGE = "DELETE FROM StaticPage WHERE PageID = ? ";
    private static final String SQL_SELECT_STATICPAGE = "SELECT * FROM StaticPage WHERE PageID=?";
    private static final String SQL_UPDATE_STATICPAGE = "UPDATE StaticPage SET body=?, title=?, active=? WHERE PageID=?";
    private static final String SQL_SELECT_ALL_STATICPAGES = "SELECT * FROM StaticPage";

    private JdbcTemplate jdbcTemplate;

       

   
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public StaticPage create(StaticPage staticPage) {

        jdbcTemplate.update(SQL_INSERT_STATICPAGE,
                staticPage.getBody(),
                staticPage.getTitle(),
                staticPage.getExpirationDate());

        Integer staticPageId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        staticPage.setPageId(staticPageId);
        return staticPage;

    }

    @Override
    public StaticPage read(Integer id) {

        StaticPage staticPage = jdbcTemplate.queryForObject(SQL_SELECT_STATICPAGE, new ContactMapper(), id);
        return staticPage;

    }

    @Override
    public void update(StaticPage staticPage) {

        jdbcTemplate.update(SQL_UPDATE_STATICPAGE,
                staticPage.getBody(),
                staticPage.getTitle(),
                staticPage.getExpirationDate(),
                staticPage.getPageId());

    }

    @Override
    public void delete(StaticPage staticPage) {

        jdbcTemplate.update(SQL_DELETE_STATICPAGE, staticPage.getPageId());

    }

    @Override
    public List<StaticPage> listAll() {

        List<StaticPage> staticPage = jdbcTemplate.query(SQL_SELECT_ALL_STATICPAGES, new ContactMapper());
        return staticPage;

    }

    @Override
    public List<StaticPage> listActivePages() {

        List<StaticPage> staticPage = jdbcTemplate.query(SQL_SELECT_ALL_STATICPAGES, new ContactMapper());
        List<StaticPage> pages = new ArrayList();
        String isActive = "Active";

        for (StaticPage s : staticPage)
        {
            if (s.getExpirationDate().equals(isActive) ) {

                pages.add(s);

            }

        }

        pages.size();

        return pages;

    }

    private static final class ContactMapper implements RowMapper<StaticPage> {

        @Override
        public StaticPage mapRow(ResultSet rs, int i) throws SQLException {

            StaticPage staticPage = new StaticPage();
            staticPage.setPageId(rs.getInt("id"));
            staticPage.setBody(rs.getString("body"));
            staticPage.setTitle(rs.getString("title"));
            staticPage.setExpirationDate(rs.getString("active"));

            return staticPage;

        }
    }

}