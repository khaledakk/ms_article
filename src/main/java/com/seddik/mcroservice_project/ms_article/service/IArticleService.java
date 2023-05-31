package com.seddik.mcroservice_project.ms_article.service;



import com.seddik.mcroservice_project.ms_article.entities.Article;
import com.seddik_commons.dto.ArticleDto;

import java.util.List;
import java.util.Map;

public interface IArticleService {
    Article createArticle(Article article);
    Article updateArticle(Map<Object, Object> fields, long id);
    ArticleDto retriveArticleById(long id);
    List<Article> retriveAllArticle();
    void removeArticle(long id);

}
