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
    
StaticPage create(StaticPage staticPage);

    StaticPage selectPageById(Integer id);

    void update(StaticPage staticPage);

    void delete(StaticPage staticPage);

    List<StaticPage> getAllStaticPages();

    List<StaticPage> listActivePages();

}
    

