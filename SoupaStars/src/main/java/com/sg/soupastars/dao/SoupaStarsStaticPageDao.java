/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.dao;

import com.sg.soupastars.model.StaticPage;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface SoupaStarsStaticPageDao {
    
    public StaticPage addStaticPage(StaticPage staticPage);

    public StaticPage getStaticPageById(int staticPageId);

    public void updateStaticPage(StaticPage staticPage);

    public void removeStaticPage(int staticPageId);

    List<StaticPage> getAllStaticPages();

    List<StaticPage> listActivePages();

    public String getExpriationDate(int staticPageId);
}
    

