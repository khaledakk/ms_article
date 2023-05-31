package com.seddik.mcroservice_project.ms_article.service;

import com.seddik.mcroservice_project.ms_article.entities.Article;
import com.seddik.mcroservice_project.ms_article.feignClient.StockFeignClient;
import com.seddik.mcroservice_project.ms_article.mapper.ArticleMapper;
import com.seddik.mcroservice_project.ms_article.repository.ArticleRepository;
import com.seddik_commons.dto.ArticleDto;
import com.seddik_commons.dto.StockDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ArticleServiceImp implements IArticleService{
    private final ArticleRepository articleRepository;
    private final IStockDto stockDto;
    private final ArticleMapper articleMapper;
    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Map<Object, Object> fields, long id) {
        Optional<Article> article = articleRepository.findById(id);
        Assert.isTrue(article.isPresent(),"Article not found");
        fields.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Article.class,(String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field,article.get(),value);
        });



        return articleRepository.save(article.get()) ;
    }

    @Override
    public ArticleDto retriveArticleById(long id) {
        Optional <Article> article = articleRepository.findById(id);

       // ArticleDto articleDto = articleMapper.ArtitcletoDto(article,stockDto.getStockDto());
        Assert.isTrue(article.isPresent(),"Article not found");
        //ArticleDto articleDto = stockFeignClient.setArticleDto(article.get());
        StockDto stockDto1 = stockDto.retriveStockById(article.get().getStockid());
        ArticleDto articleDto = articleMapper.ArtitcletoDto(article.get(),stockDto1);

        return articleDto;
    }

    @Override
    public List<Article> retriveAllArticle() {

        return articleRepository.findAll();
    }

    @Override
    public void removeArticle(long id) {
        Optional <Article> article = articleRepository.findById(id);
        Assert.isTrue(article.isPresent(),"Article not found");
        articleRepository.delete(article.get());
    }
}
