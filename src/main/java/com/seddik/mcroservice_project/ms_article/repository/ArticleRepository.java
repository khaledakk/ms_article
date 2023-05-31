package com.seddik.mcroservice_project.ms_article.repository;


import com.seddik.mcroservice_project.ms_article.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
}
