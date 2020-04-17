package com.cy.search.dao;

/**
 * @Author: cy
 * @Date: 2019/2/19 13:48
 */

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.cy.search.pojo.Article;

/**
 * 文章数据访问层接口
 */
public interface ArticleSearchDao extends
        ElasticsearchRepository<Article,String> {
}
