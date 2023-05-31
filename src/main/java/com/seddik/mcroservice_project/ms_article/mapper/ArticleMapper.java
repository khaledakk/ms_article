package com.seddik.mcroservice_project.ms_article.mapper;

import com.seddik.mcroservice_project.ms_article.entities.Article;
import com.seddik_commons.dto.ArticleDto;
import com.seddik_commons.dto.StockDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleMapper {

    public ArticleDto ArtitcletoDto(Article article, StockDto stockDto){
       ArticleDto articleDto=new ArticleDto();
       articleDto.setNom(article.getNom());
       articleDto.setQte(article.getQte());
       articleDto.setStockDto(stockDto);
       return articleDto;
    }
    public Article ArticleDtotoArticle(ArticleDto articleDto){
        Article article=new Article();
        article.setNom(articleDto.getNom());
        article.setQte(articleDto.getQte());

        return article;
    }

}
