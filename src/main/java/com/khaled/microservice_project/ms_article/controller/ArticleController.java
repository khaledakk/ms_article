package com.khaled.microservice_project.ms_article.controller;

import com.khaled.microservice_project.ms_article.entities.Article;
import com.khaled.microservice_project.ms_article.service.ArticleServiceImp;
import com.khaled_commons.dto.ArticleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleServiceImp articleServiceImp;
    @PatchMapping("{id}")
    public Article updateArticle(@RequestBody Map<Object, Object> fields, @PathVariable long id){
        return articleServiceImp.updateArticle(fields,id);
    }
    @GetMapping("/getArticle/{id}")
    public ArticleDto retriveArticleById(@PathVariable long id){

        return articleServiceImp.retriveArticleById(id);
    }
    @PostMapping("/ajouterArticle")
    public Article ajouterArticle(@RequestBody Article article){
        return articleServiceImp.createArticle(article);
    }

}
