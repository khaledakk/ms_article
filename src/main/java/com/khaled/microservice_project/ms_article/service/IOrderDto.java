package com.khaled.microservice_project.ms_article.service;

import com.khaled_commons.dto.OrderDto;
import com.khaled_commons.dto.StockDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "orderservice",url = "localhost:3000/")
public interface IOrderDto {

    @GetMapping("order/{id}")
    public OrderDto retriveOrderById(@PathVariable("id") String id);
}
