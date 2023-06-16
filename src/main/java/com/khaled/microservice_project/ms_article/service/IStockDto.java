package com.khaled.microservice_project.ms_article.service;

import com.khaled_commons.dto.StockDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "msstock",url = "localhost:8090/msStock/stock/getstck/")
public interface IStockDto {

    @GetMapping("{id}")
  public  StockDto  retriveStockById(@PathVariable("id") long id);
}
