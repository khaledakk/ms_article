package com.khaled.microservice_project.ms_article.entities;

import com.khaled_commons.entities.BaseEntity;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
//lombok annotation
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Article extends BaseEntity {
    private String nom;
    private int qte;
    private long stockid;
    private String orderid;

}
