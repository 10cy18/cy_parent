package com.cy.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.search.dao.ArticleSearchDao;
import com.cy.search.pojo.Article;

/**
 * @Author: cy
 * @Date: 2019/2/19 13:48
 */
@Service
public class ArticleSearchService {
    @Autowired
    private ArticleSearchDao articleSearchDao;
    /**
     * 增加文章
     * @param article
     */
    public void add(Article article){
        articleSearchDao.save(article);
    }
}
