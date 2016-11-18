/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.dao;

import com.sg.soupastars.model.StaticPage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class SoupaStarsStaticPageInMemImpl implements SoupaStarsStaticPageDao {
       private Map<Integer, StaticPage> staticMap = new HashMap<>();
    private static int staticIdCounter = 0;

    @Override
    public StaticPage addStaticPage(StaticPage staticPage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StaticPage getStaticPageById(int staticPageId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateStaticPage(StaticPage staticPage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeStaticPage(int staticPageId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StaticPage> getAllStaticPages() {
        List<StaticPage> allStaticPages = new ArrayList<>(staticMap.values());
        return allStaticPages;
    }

    @Override
    public List<StaticPage> listActivePages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getExpriationDate(int staticPageId) {
        return getStaticPageById(staticPageId).getExpirationDate();
    }

}
