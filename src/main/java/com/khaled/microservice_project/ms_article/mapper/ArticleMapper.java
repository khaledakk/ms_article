package com.khaled.microservice_project.ms_article.mapper;

import com.khaled.microservice_project.ms_article.entities.Article;
import com.khaled_commons.dto.ArticleDto;
import com.khaled_commons.dto.OrderDto;
import com.khaled_commons.dto.StockDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleMapper {

    public ArticleDto ArtitcletoDto(Article article, StockDto stockDto, OrderDto orderDto){
       ArticleDto articleDto=new ArticleDto();
       articleDto.setNom(article.getNom());
       articleDto.setQte(article.getQte());
       articleDto.setStockDto(stockDto);
         articleDto.setOrderDto(orderDto);
       return articleDto;
    }
    public Article ArticleDtotoArticle(ArticleDto articleDto){
        Article article=new Article();
        article.setNom(articleDto.getNom());
        article.setQte(articleDto.getQte());

        return article;
    }

}
