package com.seddik.mcroservice_project.ms_article.feignClient;

import com.seddik.mcroservice_project.ms_article.entities.Article;
import com.seddik_commons.dto.ArticleDto;
import com.seddik_commons.dto.StockDto;
import com.seddik_commons.entities.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@Service
@RequiredArgsConstructor

public class StockFeignClient {

    private RestTemplate restTemplate;


    public StockDto getStock(long id){
        restTemplate = new RestTemplate();
        StockDto stockDto = restTemplate.getForObject("http://localhost:8090/msStock/stock/getstck/"+id, StockDto.class);
        return stockDto;
    }

    public ArticleDto setArticleDto(Article article){
        ArticleDto articleDto = new ArticleDto();
        articleDto.setNom(article.getNom());
        articleDto.setQte(article.getQte());

        articleDto.setStockDto(getStock(article.getStockid()));
        return articleDto;
    }


}